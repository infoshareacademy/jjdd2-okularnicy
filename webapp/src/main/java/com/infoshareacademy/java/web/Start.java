package com.infoshareacademy.java.web;

import com.infoshareacademy.baseapp.StartingParameters;
import com.infoshareacademy.baseapp.UnZip;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
import java.util.Map;
import java.util.Set;

@WebServlet("/start")
@MultipartConfig
public class Start extends HttpServlet{

    private final Logger logger = LogManager.getLogger("log4j-burst-filter");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher ("/WEB-INF/startDoGet.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Part fileLST = req.getPart("fileLST");
            Part fileZIP = req.getPart("fileZIP");
            InputStream inputStreamLST = fileLST.getInputStream();
            InputStream inputStreamZIP = fileZIP.getInputStream();

            String tmpDir = System.getProperty("java.io.tmpdir");
            String targetDir = tmpDir + "/okularnicyFiles";//to properties
            FileUtils.deleteDirectory(new File(targetDir));

            getServletContext().setAttribute("targetDir", targetDir);
            File targetDirFolder = new File(targetDir);
            if(!targetDirFolder.exists()){
                targetDirFolder.mkdir();
            }

            String LSTDir = targetDir + "/file.lst";
            getServletContext().setAttribute("LSTDir", LSTDir);

            String ZIPDir = targetDir + "/file.zip";
            getServletContext().setAttribute("ZIPDir", ZIPDir);

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

            String unZippedDir = targetDir + "/unzipped";//to properties
            getServletContext().setAttribute("unZippedDir", unZippedDir);
            File unZippedDirFolder = new File(unZippedDir);
            if(!unZippedDirFolder.exists()){
                unZippedDirFolder.mkdir();
            }

            UnZip unZip = new UnZip();
            unZip.unZip(ZIPDir,unZippedDir);

            String[] LSTDirArray = new String[] {LSTDir};
            Map<String, String> filesHashMap = new HashMap<String, String>();
            StartingParameters startingParameters = new StartingParameters();
            filesHashMap.putAll(startingParameters.startingParametersIntoMap(LSTDirArray));

            int mapsEntry=0;
            int fundsFound=0;

            Set<Map.Entry<String, String>> entries = filesHashMap.entrySet();
            for(Map.Entry<String, String> entry : entries){
                mapsEntry++;
                String pathToFund = getServletContext().getAttribute("unZippedDir").toString();
                pathToFund += "/";
                pathToFund += entry.getValue();
                File f = new File(pathToFund);
                if(f.exists() && !f.isDirectory()) {
                    fundsFound++;
                }
            }

            if ((mapsEntry == fundsFound) && (fundsFound > 0)){
                getServletContext().setAttribute("lstCorrectness", 1);
            } else if (fundsFound > 0) {
                getServletContext().setAttribute("lstCorrectness", 0);
            } else {
                getServletContext().setAttribute("lstCorrectness", -1);
            }

            getServletContext().setAttribute("mapsEntry", mapsEntry);
            getServletContext().setAttribute("fundsFound", fundsFound);
            getServletContext().setAttribute("filesHashMap", filesHashMap);

            if (getServletContext().getAttribute("lstCorrectness").toString().equals("-1")) {
                RequestDispatcher dispatcher = getServletContext()
                        .getRequestDispatcher ("/WEB-INF/startDoGet.jsp");
                dispatcher.forward(req, resp);
            } else {
                RequestDispatcher dispatcher = getServletContext()
                        .getRequestDispatcher ("/WEB-INF/analizatorDoGet.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (IOException e) {

            logger.log(Level.ERROR, "Wyjątek: IOException");
        } catch (ServletException e) {
            logger.log(Level.ERROR, "Wyjątek: ServletException");

        }
    }
}
