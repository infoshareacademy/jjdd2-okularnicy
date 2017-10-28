package com.infoshareacademy.java.web;

import com.auth0.SessionUtils;
import com.infoshareacademy.baseapp.StartingParameters;
import com.infoshareacademy.baseapp.UnZip;
import com.infoshareacademy.java.web.beans.UserDAOBeanLocal;
import com.infoshareacademy.java.web.beans.UsersLoginsDAOBeanLocal;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@WebServlet("/finanse/start")
@MultipartConfig
public class Start extends HttpServlet {

    @Inject
    UserService userService;

    private final Logger logger = LogManager.getLogger("log4j-burst-filter");
    Configuration configuration = new Configuration();
    JsonReader jsonReader = new JsonReader();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        configuration = jsonReader.readJsonFile(getServletContext().getResource("/WEB-INF/configuration.json").getPath());
        logger.log(Level.INFO, "uruchomiono aplikacje");
        final String accessToken = (String) SessionUtils.get(req, "accessToken");
        final String idToken = (String) SessionUtils.get(req, "idToken");
        if (accessToken != null) {
            req.setAttribute("userId", accessToken);
        } else if (idToken != null) {
            req.setAttribute("userId", idToken);
        } else {
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/WEB-INF/error.jsp");
            dispatcher.forward(req, resp);
        }

        boolean isAdmin = userService.initUserSession(accessToken);

        if (isAdmin) {
            resp.sendRedirect("/finanse/admin");
        }

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/startDoGet.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Part fileLST = req.getPart("fileLST");
            Part fileZIP = req.getPart("fileZIP");
            InputStream inputStreamLST = fileLST.getInputStream();
            InputStream inputStreamZIP = fileZIP.getInputStream();
            logger.info("Rozpoczęto wczytywanie plików");

            String tmpDir = System.getProperty("java.io.tmpdir");
            UUID uuid = UUID.randomUUID();
            String targetDir = tmpDir + "/" + configuration.getWorkFiles() + uuid.toString();//to properties
            logger.info("Ustawiono ścieżkę tymczasową na: " + targetDir);

            FileUtils.deleteDirectory(new File(targetDir));

            getServletContext().setAttribute("targetDir", targetDir);
            File targetDirFolder = new File(targetDir);
            if (!targetDirFolder.exists()) {
                targetDirFolder.mkdir();
            }

            logger.info("Ustawiono ścieżkę docelową na: " + targetDir);

            String LSTDir = targetDir + "/" + configuration.getFileLst();
            getServletContext().setAttribute("LSTDir", LSTDir);
            logger.info("Ustawiono ścieżkę do pliku LST: " + LSTDir);

            String ZIPDir = targetDir + "/" + configuration.getFileZip();
            getServletContext().setAttribute("ZIPDir", ZIPDir);
            logger.info("Ustawiono ścieżkę do pliku ZIP: " + ZIPDir);

            OutputStream outputStreamLST = new FileOutputStream(new File(LSTDir));
            OutputStream outputStreamZIP = new FileOutputStream(new File(ZIPDir));
            int readLST = 0;
            int readZIP = 0;
            byte[] bytesLST = new byte[1024];
            byte[] bytesZIP = new byte[1024];
            while ((readLST = inputStreamLST.read(bytesLST)) != -1) {
                outputStreamLST.write(bytesLST, 0, readLST);
            }
            while ((readZIP = inputStreamZIP.read(bytesZIP)) != -1) {
                outputStreamZIP.write(bytesZIP, 0, readZIP);
            }
            logger.info("Zakończono zapisywanie plików na dysku");

            String unZippedDir = targetDir + "/" + configuration.getUnzippeDir();//to properties
            getServletContext().setAttribute("unZippedDir", unZippedDir);
            File unZippedDirFolder = new File(unZippedDir);
            if (!unZippedDirFolder.exists()) {
                unZippedDirFolder.mkdir();
            }
            logger.info("Ustawiono folder docelowy do dekompresji plików: " + unZippedDir);

            UnZip unZip = new UnZip();
            unZip.unZip(ZIPDir, unZippedDir);
            logger.info("Zakończono rozpakowywanie plików z archiwum");


            String[] LSTDirArray = new String[] {LSTDir};
            Map<String, String> filesHashMap = new HashMap<String, String>();
            StartingParameters startingParameters = new StartingParameters();
            filesHashMap.putAll(startingParameters.startingParametersIntoMap(LSTDirArray));
            logger.info("Wczytanie danych z pliku LST do mapy");
            Map<String, String> filesHashMapToSent = new HashMap<String, String>();

            int mapsEntry = 0;
            int fundsFound = 0;

            Set<Map.Entry<String, String>> entries = filesHashMap.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                mapsEntry++;
                String pathToFund = getServletContext().getAttribute("unZippedDir").toString();
                pathToFund += "/";
                pathToFund += entry.getValue();
                File f = new File(pathToFund);
                if (f.exists() && !f.isDirectory()) {
                    fundsFound++;
                    filesHashMapToSent.put(entry.getKey(), entry.getValue());
                }
            }
            logger.info("Zakończono zestawienie danych plik LST - plik ZIP");

            if ((mapsEntry == fundsFound) && (fundsFound > 0)) {
                getServletContext().setAttribute("lstCorrectness", 1);
                logger.info("Zestawienie LST-ZIP zakończono pomyślnie");
            } else if (fundsFound > 0) {
                getServletContext().setAttribute("lstCorrectness", 0);
                logger.warn("Zestawienie LST-ZIP - brakuje co najmniej jednego pliku");
            } else {
                getServletContext().setAttribute("lstCorrectness", -1);
                logger.error("Zestawienie LST-ZIP - brak pliku");
            }

            getServletContext().setAttribute("mapsEntry", mapsEntry);
            getServletContext().setAttribute("fundsFound", fundsFound);
            getServletContext().setAttribute("filesHashMap", filesHashMapToSent);

            if (getServletContext().getAttribute("lstCorrectness").toString().equals("-1")) {
                RequestDispatcher dispatcher = getServletContext()
                        .getRequestDispatcher ("/WEB-INF/ErrorZIP.jsp");
                dispatcher.forward(req, resp);
                logger.info("Przekierowanie na stronę błędu");
            } else {
                RequestDispatcher dispatcher = getServletContext()
                        .getRequestDispatcher ("/WEB-INF/analizatorDoGet.jsp");
                dispatcher.forward(req, resp);
                logger.info("Przekierowanie na kolejną stronę");
            }
        } catch (IOException e) {
            logger.log(Level.ERROR, "Wyjątek: IOException");
        } catch (ServletException e) {
            logger.log(Level.ERROR, "Wyjątek: ServletException");
        }
    }

}