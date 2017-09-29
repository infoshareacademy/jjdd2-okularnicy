package com.infoshareacademy.java.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet ("/local")
public class LocalServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        writer.println("<header>");
        writer.println("Analizator finansowy");
        writer.println("<nav class=\"nav\">");
        writer.println("<ul>");
        writer.println("<li><a href=\"analizator\" target=\"_blank\">STRONA GŁÓWNA</a></li>");
        writer.println("<li><a>SZUKAJ</a></li>");
        writer.println("<ul>");
        writer.println(	"<li><a href=\"global\"target=\"_blank\" >EKSTREMA GLOBALNE</a></li>");
        writer.println(	"<li><a>EKSTREMA LOKALNE</a></li>");
        writer.println(	"<li><a href=\"currency\" target=\"_blank\">WALUTY</a></li>");
        writer.println(	"</ul>");
        writer.println("<li><a href=\"kontakt\" target=\"_blank\">KONTAKT</a></li>");
        writer.println("<li><a href=\"index\" target=\"_blank\" >WCZYTAJ PLIK</a></li>");
        writer.println("</ul>");
        writer.println("</nav>");
        writer.println("</header>");
        writer.println("<body>");
        writer.println("<article>");
        writer.println("<H1>Ekstrema lokalne</H2>");
        writer.println("<form action=\"formularz\" method=\"post\">");
        writer.println("<input type=\"text\" name=\"userinput\">");
        writer.println("<button type=\"submit\">Wyślij</button>");
        writer.println("</form>");
        writer.println("<br><br>");
        writer.println("</article>");
        writer.println("</body>");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();    }
}

