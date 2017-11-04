package com.infoshareacademy.java.web;

import com.infoshareacademy.baseapp.Fund;
import com.infoshareacademy.baseapp.FundBase;
import com.infoshareacademy.baseapp.ListInRange;
import com.infoshareacademy.baseapp.Program;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

@WebServlet("/finanse/extremaLokalne")
public class extremaLokalne extends HttpServlet {
    private final Logger logger = LogManager.getLogger(getClass().getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        FundBase fundBase = new FundBase();
        Program program = new Program();

        String startDateString = req.getParameter("startDate");
        program.setStartDate(LocalDate.parse(startDateString));
        String endDateString = req.getParameter("endDate");
        program.setEndDate(LocalDate.parse(endDateString));

        if (program.getEndDate().isBefore(program.getStartDate())) {
            resp.sendRedirect("DataRange");
        } else {

            String stringToFund = getServletContext().getAttribute("unZippedDir").toString();
            stringToFund += "/";
            stringToFund += getServletContext().getAttribute("choseFundString").toString();

            ArrayList<Fund> fundsList = fundBase.readFoundIntoList(stringToFund);
            program.setFundsList(fundsList);
            ListInRange listInRange = new ListInRange(program);
            Fund fundMin = program.getExtremum().findMin(listInRange.setListInRange());
            Fund fundMax = program.getExtremum().findMax(listInRange.setListInRange());
            String fundMinDate = fundMin.getDate().toString();
            String fundMinClose = fundMin.getClose().toString();
            String fundMaxDate = fundMax.getDate().toString();
            String fundMaxClose = fundMax.getClose().toString();

            req.setAttribute("fundMinDate", fundMinDate);
            req.setAttribute("fundMinClose", fundMinClose);
            logger.info("Wartośc minimum w ekstremum lokalnym " + fundMinClose);
            req.setAttribute("fundMaxDate", fundMaxDate);
            req.setAttribute("fundMaxClose", fundMaxClose);
            logger.info("Wartośc maksimum w ekstremum lokalnym " + fundMinClose);
        }

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/extremaLokalneDoGet.jsp");
        dispatcher.forward(req, resp);
    }
}