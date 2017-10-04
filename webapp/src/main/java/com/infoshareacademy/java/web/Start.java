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

@WebServlet("/start")
@MultipartConfig
public class Start extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher ("/WEB-INF/startDoGet.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Part fileLST = null;
            Part fileZIP = null;
            fileLST = req.getPart("fileLST");
            fileZIP = req.getPart("fileZIP");
            InputStream inputStreamLST = null;
            InputStream inputStreamZIP = null;
            inputStreamLST = fileLST.getInputStream();
            inputStreamZIP = fileZIP.getInputStream();
            String tmpDir = System.getProperty("java.io.tmpdir");

            String targetDir = tmpDir + "/okularnicyFiles";
            getServletContext().setAttribute("targetDir", targetDir);
            File targetDirFolder = new File(targetDir);
            if(!targetDirFolder.exists()){
                targetDirFolder.mkdir();
            }

            String unZippedDir = targetDir + "/unzipped";
            getServletContext().setAttribute("unZippedDir", unZippedDir);
            File unZippedDirFolder = new File(unZippedDir);
            if(!unZippedDirFolder.exists()){
                unZippedDirFolder.mkdir();
            }

            String LSTDir = targetDir + "/plik.lst";
            getServletContext().setAttribute("LSTDir", LSTDir);

            String ZIPDir = targetDir + "/plik.zip";
            getServletContext().setAttribute("ZIPDir", ZIPDir);

            OutputStream outputStreamLST = null;
            OutputStream outputStreamZIP = null;
            outputStreamLST = new FileOutputStream(new File(LSTDir));
            outputStreamZIP = new FileOutputStream(new File(ZIPDir));
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

            /*RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher ("/WEB-INF/startDoPost.jsp");
            dispatcher.forward(req, resp);*/

            resp.sendRedirect("start2");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
