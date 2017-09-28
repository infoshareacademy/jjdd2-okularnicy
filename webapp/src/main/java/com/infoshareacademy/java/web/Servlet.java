package com.infoshareacademy.java.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Scanner;

@WebServlet("/index")
@MultipartConfig
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<p>Servlet1, doGet</p>");
        writer.println("<form action=\"index\" method=\"post\" enctype=\"multipart/form-data\">");
        writer.println("<p>Tutaj wskaż plik LST: ");
        writer.println("<input type=\"file\" name=\"fileLST\"/>");
        writer.println("</p>");
        writer.println("<p>Tutaj wskaż archiwum ZIP: ");
        writer.println("<input type=\"file\" name=\"fileZIP\"/>");
        writer.println("</p>");
        writer.println("<button type=\"submit\">Wyslij</button>");
        writer.println("</form>");
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
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
            File folder = new File(targetDir);
            if(!folder.exists()){
                folder.mkdir();
            }


            String LSTDir = targetDir + "/plik.lst.txt";
            String ZIPDir = targetDir + "/plik.zip.txt";
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

            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = resp.getWriter();

            writer.println("<p>Servlet1, doPost</p>");

            writer.println("<p>LSTDir: ");
            writer.println(LSTDir);
            writer.println("</p>");
            getServletContext().setAttribute("pathLST", LSTDir);
            writer.println("<p>getServletContext().getAttribute(\"pathLST\"): ");
            writer.println(getServletContext().getAttribute("pathLST"));
            writer.println("</p>");

            writer.println("<p>ZIPDir: ");
            writer.println(ZIPDir);
            writer.println("</p>");
            getServletContext().setAttribute("pathZIP", ZIPDir);
            writer.println("<p>getServletContext().getAttribute(\"pathZIP\"): ");
            writer.println(getServletContext().getAttribute("pathZIP"));
            writer.println("</p>");


            writer.println("<p>link do nastepnego servletu (docelowo będzie automatyczne przejscie): ");
            writer.println("<a href=\"index2\">next</a>");
            writer.println("</p>");


            //resp.sendRedirect("index2");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
