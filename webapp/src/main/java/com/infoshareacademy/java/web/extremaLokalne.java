package com.infoshareacademy.java.web;

import com.infoshareacademy.baseapp.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

@WebServlet("/extremaLokalne")
public class extremaLokalne extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FundBase fundBase = new FundBase();
        Program program = new Program();

        String startLocalDateString = getServletContext().getAttribute("startLocalDate").toString();
        LocalDate startLocalDate = LocalDate.parse(startLocalDateString);
        program.setStartDate(startLocalDate);
        String endLocalDateString = getServletContext().getAttribute("endLocalDate").toString();
        LocalDate endLocalDate = LocalDate.parse(endLocalDateString);
        program.setEndDate(endLocalDate);

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
            req.setAttribute("fundMaxDate", fundMaxDate);
            req.setAttribute("fundMaxClose", fundMaxClose);
        }

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/extremaLokalneDoGet.jsp");
        dispatcher.forward(req, resp);
    }
}