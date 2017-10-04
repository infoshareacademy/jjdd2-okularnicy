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
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/extremaGlobalne")
@MultipartConfig
public class extremaGlobalne extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        FundBase fundBase = new FundBase();

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println(getServletContext().getAttribute("choseFundString"));
        writer.println("<br>");
        writer.println(getServletContext().getAttribute("unZippedDir"));
        writer.println("<br>");

        String stringToFund = null;
        stringToFund = getServletContext().getAttribute("unZippedDir").toString();
        stringToFund += "/";
        stringToFund += getServletContext().getAttribute("choseFundString").toString();
        writer.println(stringToFund);
        writer.println("<br>");

        ArrayList<Fund> fundsList = fundBase.readFoundIntoList(stringToFund);
        Extremum extremum = new Extremum();
        Fund fundMin = extremum.findMin(fundsList);
        Fund fundMax = extremum.findMax(fundsList);

        writer.println("Wartość minimalna: " + fundMin.getDate() + " => " + fundMin.getClose());
        writer.println("<br>");
        writer.println("Wartość maksymalna: " + fundMax.getDate() + " => " + fundMax.getClose());

        //System.out.println("Wartość minimalna: " + extremum.findMin(fundsList));











        /*RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher ("/WEB-INF/extremaGlobalneDoGet.jsp");
        dispatcher.forward(req, resp);*/
    }
}
