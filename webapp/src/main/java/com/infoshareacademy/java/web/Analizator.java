package com.infoshareacademy.java.web;

import com.infoshareacademy.baseapp.statistics.Record;
import com.infoshareacademy.baseapp.statistics.Statistics;
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
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

@WebServlet("/finanse/analizator")
@MultipartConfig
public class Analizator extends HttpServlet {
    private final Logger logger = LogManager.getLogger(getClass().getName());

    private Statistics statistics = Statistics.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/analizatorDoGet.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part choseFund = null;
        choseFund = req.getPart("choseFund");
        Scanner scanner = new Scanner(choseFund.getInputStream());
        String nextLine = scanner.nextLine();
        String choseFundString = nextLine.split(",")[0];
        String choseFundStringFullName = nextLine.split(",")[1];
        getServletContext().setAttribute("choseFundString", choseFundString);
        getServletContext().setAttribute("choseFundStringFullName", choseFundStringFullName);
        logger.info("Użytkownik wybrał fundusz: " + choseFundString + " " + choseFundStringFullName);
        Record record = new Record(choseFundStringFullName, LocalDateTime.now());
        statistics.add(record);
        logger.info("Do statystyk zapisano record: " + record.toString());
        resp.sendRedirect("menu");
        logger.info("Przekierowanie na stronę menu");
    }
}