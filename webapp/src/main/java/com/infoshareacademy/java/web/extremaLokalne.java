package com.infoshareacademy.java.web;

import com.infoshareacademy.baseapp.Fund;
import com.infoshareacademy.baseapp.FundBase;
import com.infoshareacademy.baseapp.ListInRange;
import com.infoshareacademy.baseapp.Program;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/extremaLokalne")
public class extremaLokalne extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        FundBase fundBase = new FundBase();

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println(getServletContext().getAttribute("choseFundString"));
        writer.println("<br>");
        writer.println(getServletContext().getAttribute("unZippedDir"));
        writer.println("<br>");
        writer.println(getServletContext().getAttribute("startLocalDate"));
        writer.println("<br>");
        writer.println(getServletContext().getAttribute("endLocalDate"));
        writer.println("<br>");

        String stringToFund = null;
        stringToFund = getServletContext().getAttribute("unZippedDir").toString();
        stringToFund += "/";
        stringToFund += getServletContext().getAttribute("choseFundString").toString();
        writer.println(stringToFund);
        writer.println("<br>");

        Program program = new Program();
        ListInRange listInRange = new ListInRange(program);
        Fund fundMin = program.getExtremum().findMin(listInRange.setListInRange());
        Fund fundMax = program.getExtremum().findMax(listInRange.setListInRange());
        String fundMinDate = fundMin.getDate().toString();
        String fundMinClose = fundMin.getClose().toString();
        String fundMaxDate = fundMax.getDate().toString();
        String fundMaxClose = fundMax.getClose().toString();

        writer.println("Wartość minimalna: " + fundMin.getDate() + " => " + fundMin.getClose());
        writer.println("<br>");
        writer.println("Wartość maksymalna: " + fundMax.getDate() + " => " + fundMax.getClose());

        req.setAttribute("fundMinDate", fundMinDate);
        req.setAttribute("fundMinClose", fundMinClose);
        req.setAttribute("fundMaxDate", fundMaxDate);
        req.setAttribute("fundMaxClose", fundMaxClose);

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher ("/WEB-INF/localExtremumDoGet.jsp");
        dispatcher.forward(req, resp);





    }
}
