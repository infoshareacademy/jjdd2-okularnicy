package com.infoshareacademy.java.web;

import com.infoshareacademy.baseapp.Extremum;
import com.infoshareacademy.baseapp.Fund;
import com.infoshareacademy.baseapp.FundBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/finanse/extremaGlobalne")
@MultipartConfig
public class extremaGlobalne extends HttpServlet {
    private final Logger logger = LogManager.getLogger(getClass().getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            FundBase fundBase = new FundBase();

            String pathToFund = getServletContext().getAttribute("unZippedDir").toString();
            pathToFund += "/";
            pathToFund += getServletContext().getAttribute("choseFundString").toString();
            logger.info("Ustawiono ścieżkę do pliku z wybranym funduszem/walutą");

            List<Fund> fundsList = fundBase.readFoundIntoList(pathToFund);
            logger.info("Wczytanie danych funduszu/waluty z wybranego pliku");
            Extremum extremum = new Extremum();
            Fund fundMin = extremum.findMin(fundsList);
            logger.info("Ustalono ekstremum min globalne na " + fundMin);
            Fund fundMax = extremum.findMax(fundsList);
            logger.info("Ustalono ekstremum max globalne na " + fundMax);
            String fundMinDate = fundMin.getDate().toString();
            String fundMinClose = fundMin.getClose().toString();
            String fundMaxDate = fundMax.getDate().toString();
            String fundMaxClose = fundMax.getClose().toString();

            req.setAttribute("fundMinDate", fundMinDate);
            req.setAttribute("fundMinClose", fundMinClose);
            req.setAttribute("fundMaxDate", fundMaxDate);
            req.setAttribute("fundMaxClose", fundMaxClose);
            req.setAttribute("fundList", fundsList
                    .stream()
                    .sorted(Comparator.comparing(Fund::getDate))
                    .collect(Collectors.toList()));

            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/WEB-INF/extremaGlobalneDoGet.jsp");
            dispatcher.forward(req, resp);
            logger.info("Przejście na stronę ekstremum globalnego");
        } catch (RuntimeException e) {
            logger.error("Blad na stronie extrema globalne: " + e);
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/WEB-INF/error.jsp");
            dispatcher.forward(req, resp);
        } catch (IOException e) {
            logger.error("Blad na stronie extrema globalne: " + e);
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/WEB-INF/error.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
