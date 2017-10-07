package com.infoshareacademy.java.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.time.LocalDateTime;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet("/start")
@MultipartConfig
public class Start extends HttpServlet{

    private final Logger logger = LogManager.getLogger("log4j-burst-filter");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.log(Level.INFO, "uruchomiono aplikacje");
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

            /*String unZippedDir = targetDir + "/unzipped";//to properties
            getServletContext().setAttribute("unZippedDir", unZippedDir);*/

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

            resp.sendRedirect("start2");
        } catch (IOException e) {
            logger.log(Level.ERROR, "Wyjątek: IOException");
        } catch (ServletException e) {
            logger.log(Level.ERROR, "Wyjątek: ServletException");
        }
    }
}