package com.infoshareacademy.java.web;

import com.infoshareacademy.baseapp.UnZip;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/index2")
public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");

        writer.println("<p>Servlet2, doGet</p>");
        writer.println("<br/>");

        writer.println("<p>Pliki zostały zapisane na dysku. Do naszej dyspozycji mamy poniższe ServletContext:</p>");







        writer.println("<p>getServletContext().getAttribute(\"LSTDir\"): ");
        writer.println(getServletContext().getAttribute("LSTDir"));
        writer.println("</p>");

        writer.println("<p>getServletContext().getAttribute(\"ZIPDir\"): ");
        writer.println(getServletContext().getAttribute("ZIPDir"));
        writer.println("</p>");


        writer.println("<p>getServletContext().getAttribute(\"targetDir\"): ");
        writer.println(getServletContext().getAttribute("targetDir"));
        writer.println("</p>");

        writer.println("<p>getServletContext().getAttribute(\"unZippedDir\"): ");
        writer.println(getServletContext().getAttribute("unZippedDir"));
        writer.println("</p>");


        writer.println("<br/>");

        //--------------------------------------
        writer.println("<form action=\"index2\" method=\"post\" enctype=\"multipart/form-data\">");
        writer.println("<p>Aby rozpakować archiwum ZIP kliknij ponizszy przycisk</p>");
        writer.println("<button type=\"submit\">Rozpakuj</button>");
        writer.println("</form>");
        //--------------------------------------

        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String ZIPDir = String.valueOf(getServletContext().getAttribute("ZIPDir"));
        String unZippedDir = String.valueOf(getServletContext().getAttribute("unZippedDir"));


        UnZip unZip = new UnZip();
        unZip.unZip(ZIPDir,unZippedDir);








        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<p>rozpakowano archiwum ZIP</p>");

        writer.println("<p>link do glownego servletu (docelowo będzie automatyczne przejscie): ");
        writer.println("<a href=\"index3\">next</a>");
        writer.println("</p>");



        writer.println("</body>");
        writer.println("</html>");
    }
}
