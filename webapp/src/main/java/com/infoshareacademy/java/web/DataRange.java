package com.infoshareacademy.java.web;

import com.infoshareacademy.baseapp.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

@WebServlet("/DataRange")
@MultipartConfig
public class DataRange extends HttpServlet {

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

        req.setAttribute("fundsList", fundsList);

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher ("/WEB-INF/dataRangeDoGet.jsp");
        dispatcher.forward(req, resp);

}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        // tutaj powinna byc juz wyswietlona wartosc
        Part startDate = null;
        Part endDate = null;
        startDate = req.getPart("startDate");
        endDate = req.getPart("endDate");
        Scanner scannerStartDate = null;
        Scanner scannerEndDate = null;
        scannerStartDate = new Scanner(startDate.getInputStream());
        scannerEndDate = new Scanner(endDate.getInputStream());
        String startLocalDate = scannerStartDate.nextLine();
        String endLocalDate = scannerEndDate.nextLine();
        getServletContext().setAttribute("startLocalDate", startLocalDate);
        getServletContext().setAttribute("endLocalDate", endLocalDate);
        writer.println(startLocalDate);
        writer.println(endLocalDate);

        resp.sendRedirect("extremaLokalne");
    }
}