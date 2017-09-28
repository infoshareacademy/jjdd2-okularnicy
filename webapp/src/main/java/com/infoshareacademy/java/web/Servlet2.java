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

        writer.println("<p>getServletContext().getAttribute(\"pathLST\"): ");
        writer.println(getServletContext().getAttribute("pathLST"));
        writer.println("</p>");

        writer.println("<p>getServletContext().getAttribute(\"pathZIP\"): ");
        writer.println(getServletContext().getAttribute("pathZIP"));
        writer.println("</p>");


        //--------------------------------------
        writer.println("<form action=\"index2\" method=\"post\" enctype=\"multipart/form-data\">");
        writer.println("<button type=\"submit\">Wyslij</button>");
        writer.println("</form>");
        //--------------------------------------

        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UnZip unZip = new UnZip();
        /*UnZip unZip = new UnZip();
        unZip.unZip();*/

        //UnZip unZip = new UnZip();



        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<p>tutaj bedzie rozpakowywanie plikow</p>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
