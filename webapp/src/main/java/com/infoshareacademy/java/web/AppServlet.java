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

        resp.setContentType("text/html:charset=UTF-8");
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
        writer.println("<li><a href=\"#strona główna\">STRONA GŁÓWNA</a></li>");
        writer.println("<li><a href=\"#search in base\">SZUKAJ</a></li>");
        writer.println("<ul>");
        writer.println(	"<li><a href=\"#find global extremes\">EKSTREMA GLOBALNE</a></li>");
        writer.println(	"<li><a href=\"#find locale extremes\">EKSTREMA LOKALNE</a></li>");
        writer.println(	"<li><a href=\"#find ...............\">WALUTY</a></li>");
        writer.println(	"</ul>");
        writer.println("<li><a href=\"#statystyki\">STATYSTYKI</a></li>");
        writer.println("<li><a href=\"#kontakt\">KONTAKT</a></li>");
        writer.println("<li><a href=\"#exit\">LOGOWANIE</a></li>");
        writer.println("</ul>");
        writer.println("</nav>");
        writer.println("</header>");

        writer.println("<aside>");
        writer.println("<ul>");
        writer.println("<li><a href=\"#strona główna\">STRONA GŁÓWNA</a></li>");
        writer.println("<li><a href=\"#search in base\">SZUKAJ</a></li>");
        writer.println("<ul>");
        writer.println(	"<li><a href=\"#find global extremes\">EKSTREMA GLOBALNE</a></li>");
        writer.println(	"<li><a href=\"#find locale extremes\">EKSTREMA LOKALNE</a></li>");
        writer.println(	"<li><a href=\"#find ...............\">WALUTY</a></li>");
        writer.println(	"</ul>");
        writer.println("<li><a href=\"#statystyki\">STATYSTYKI</a></li>");
        writer.println("<li><a href=\"#kontakt\">KONTAKT</a></li>");
        writer.println("<li><a href=\"#exit\">LOGOWANIE</a></li>");
        writer.println("</ul>");
        writer.println("<aside");

        writer.println("<article id=\"strona główna\">");
        writer.println("<H1> Analizator finansowy </H1>");
        writer.println("<br><br>");
        writer.println("<p>Witaj w programie ANALIZATOR FINANSOWY</p>");
        writer.println("<br><br>");
        writer.println("<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod");
        writer.println("ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,");
        writer.println("quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo.</p>");
        writer.println("<br><br>");

        writer.println("</article>");
        writer.println("<article id=\"search in base\">");
        writer.println("<H2>Wyszukaj w bazie</H2>");
        writer.println("jakas mala instrukcje nt.tego w jaki sposob uzywac naszego analizatora, info co ma zrobic uzytkownik zeby uzyskac to czego szuka");
        writer.println("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod");
        writer.println("tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,");

        writer.println("<form action=\"numbers\" method=\"post\">");
        writer.println("<input type=\"text\" name=\"userinput\">");
        writer.println("<button type=\"submit\">Wyślij</button>");
        writer.println("</form>");
        writer.println("<br><br>");
        writer.println("<form action=\"numbers\" method=\"post\">");
        writer.println("<select name=\"Wybierz jedną z opcji\">");
        writer.println("<option>Wyszukaj ekstrema globalne</option>");
        writer.println("<option>Wyszukaj ekstrema lokalne </option>");
        writer.println("<option>Wyszukaj walutę</option>");
        writer.println("</form>");
        writer.println("</article>");

        writer.println("<article id=\"find global extremes>");
        writer.println("<H2>Wyszukaj ekstrema globalne</H2>");
        writer.println("<form action=\"numbers\" method=\"post\">");
        writer.println("<input type=\"text\" name=\"\">");
        writer.println("<button type=\"submit\">Wyślij</button>");
        writer.println("</form>");
        writer.println("tutaj wyswietli sie wynik po wyborze  ");

        writer.println("</article>");
    }
}
