package com.infoshareacademy.java.web;

import com.infoshareacademy.baseapp.StartingParameters;
import com.infoshareacademy.baseapp.UnZip;
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

            req.setAttribute("filesHashMap", filesHashMap);

            //resp.sendRedirect("analizator");

            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher ("/WEB-INF/analizatorDoGet.jsp");
            dispatcher.forward(req, resp);
        } catch (IOException e) {

            logger.log(Level.ERROR, "Wyjątek: IOException");
        } catch (ServletException e) {
            logger.log(Level.ERROR, "Wyjątek: ServletException");

        }
    }
}
