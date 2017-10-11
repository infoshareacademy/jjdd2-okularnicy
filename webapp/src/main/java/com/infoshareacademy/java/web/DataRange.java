package com.infoshareacademy.java.web;

import com.infoshareacademy.baseapp.*;
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
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

@WebServlet("/DataRange")
@MultipartConfig
public class DataRange extends HttpServlet {
    private final Logger logger = LogManager.getLogger("log4j-burst-filter");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        FundBase fundBase = new FundBase();

        String stringToFund = getServletContext().getAttribute("unZippedDir").toString();
        stringToFund += "/";
        stringToFund += getServletContext().getAttribute("choseFundString").toString();

        ArrayList<Fund> fundsList = fundBase.readFoundIntoList(stringToFund);

        req.setAttribute("fundsList", fundsList);

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher ("/WEB-INF/dataRangeDoGet.jsp");
        dispatcher.forward(req, resp);
}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            Part startDate = req.getPart("startDate");
            Part endDate = req.getPart("endDate");
            Scanner scannerStartDate = new Scanner(startDate.getInputStream());
            Scanner scannerEndDate = new Scanner(endDate.getInputStream());
            String startLocalDate = scannerStartDate.nextLine();
            String endLocalDate = scannerEndDate.nextLine();
            getServletContext().setAttribute("startLocalDate", startLocalDate);
            getServletContext().setAttribute("endLocalDate", endLocalDate);
            logger.info("Data pocztątkowa została ustawiona" + startLocalDate);
            logger.info("Data końcowa została ustawiona" + endLocalDate);


        resp.sendRedirect("extremaLokalne");
    }
}