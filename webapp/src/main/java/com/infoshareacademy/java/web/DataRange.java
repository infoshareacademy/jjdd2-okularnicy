package com.infoshareacademy.java.web;

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
import java.time.LocalDate;
import java.util.ArrayList;

@WebServlet("/finanse/DataRange")
@MultipartConfig
public class DataRange extends HttpServlet {
    private final Logger logger = LogManager.getLogger("log4j-burst-filter");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            FundBase fundBase = new FundBase();

            String stringToFund = getServletContext().getAttribute("unZippedDir").toString();
            stringToFund += "/";
            stringToFund += getServletContext().getAttribute("choseFundString").toString();

            ArrayList<Fund> fundsList = fundBase.readFoundIntoList(stringToFund);
            LocalDate startDateOnList = fundsList.get(0).getDate();
            LocalDate endDateOnList = fundsList.get(fundsList.size() - 1).getDate();

            req.setAttribute("fundsList", fundsList);
            req.setAttribute("startDateOnList", startDateOnList);
            req.setAttribute("endDateOnList", endDateOnList);

            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/WEB-INF/dataRangeDoGet.jsp");
            dispatcher.forward(req, resp);
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