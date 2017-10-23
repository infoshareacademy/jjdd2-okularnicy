package com.infoshareacademy.java.web.statistics;

import com.infoshareacademy.java.web.report.Report;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/finanse/statistics")
public class StatisticsServlet extends HttpServlet{

    private Report report = Report.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(report.generateReport());
    }
}
