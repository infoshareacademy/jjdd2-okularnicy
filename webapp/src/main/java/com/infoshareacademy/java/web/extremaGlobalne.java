package com.infoshareacademy.java.web;

import com.infoshareacademy.baseapp.Extremum;
import com.infoshareacademy.baseapp.Fund;
import com.infoshareacademy.baseapp.FundBase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/extremaGlobalne")
@MultipartConfig
public class extremaGlobalne extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FundBase fundBase = new FundBase();

        String pathToFund = getServletContext().getAttribute("unZippedDir").toString();
        pathToFund += "/";
        pathToFund += getServletContext().getAttribute("choseFundString").toString();

        List<Fund> fundsList = fundBase.readFoundIntoList(pathToFund);
        Extremum extremum = new Extremum();
        Fund fundMin = extremum.findMin(fundsList);
        Fund fundMax = extremum.findMax(fundsList);
        String fundMinDate = fundMin.getDate().toString();
        String fundMinClose = fundMin.getClose().toString();
        String fundMaxDate = fundMax.getDate().toString();
        String fundMaxClose = fundMax.getClose().toString();

        req.setAttribute("fundMinDate", fundMinDate);
        req.setAttribute("fundMinClose", fundMinClose);
        req.setAttribute("fundMaxDate", fundMaxDate);
        req.setAttribute("fundMaxClose", fundMaxClose);

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher ("/WEB-INF/extremaGlobalneDoGet.jsp");
        dispatcher.forward(req, resp);
    }
}
