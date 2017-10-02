package com.infoshareacademy.java.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

@WebServlet("/analizator")
public class AppServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        writer.println("<!DOCTYPE html>");
        writer.println("<html lang=\"pl\">");
        writer.println("<meta http-equiv=\"x-ua-compatibile\" content=\"ie-edge, chrome-1\">");
        writer.println("<meta name=\"keywords\">");

        writer.println("<meta name=\"author\" content=\"Okularnicy\">");

        writer.println("<title>ANALIZATOR FINANSOWY</title>");
        writer.println("<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\">");
        writer.println("<body text=\"green\">");
        writer.println("<header>");
        writer.println("Analizator finansowy");
        writer.println("<nav class=\"nav\">");
        writer.println("<ul>");
        writer.println("<li><a href=\"analizator\" target=\"_blank\">STRONA GŁÓWNA</a></li>");
        writer.println("<li><a>SZUKAJ</a></li>");
        writer.println("<ul>");
        writer.println(	"<li><a href=\"global\"target=\"_blank\" >EKSTREMA GLOBALNE</a></li>");
        writer.println(	"<li><a href=\"local\" target=\"_blank\">EKSTREMA LOKALNE</a></li>");
        writer.println(	"<li><a href=\"currency\" target=\"_blank\">WALUTY</a></li>");
        writer.println(	"</ul>");
        writer.println("<li><a href=\"kontakt\" target=\"_blank\">KONTAKT</a></li>");
        writer.println("<li><a href=\"index\" target=\"_blank\" >WCZYTAJ PLIK</a></li>");
        writer.println("</ul>");
        writer.println("</nav>");
        writer.println("</header>");

        writer.println("<article id=\"strona główna\">");
        writer.println("<H1> Analizator finansowy </H1>");
        writer.println("<br><br>");
        writer.println("<p>Witaj w programie ANALIZATOR FINANSOWY</p>");
        writer.println("<br><br>");

        writer.println("<H2>Wyszukaj w bazie</H2>");
        writer.println("<ul>");
        writer.println(	"<li><a href=\"global\"target=\"_blank\" >EKSTREMA GLOBALNE</a></li>");
        writer.println(	"<li><a href=\"local\" target=\"_blank\">EKSTREMA LOKALNE</a></li>");
        writer.println(	"<li><a href=\"currency\" target=\"_blank\"\">WALUTY</a></li>");
        writer.println("</ul>");





    }
}