package com.infoshareacademy.java.web.statistics;

import com.infoshareacademy.baseapp.report.Report;
import com.infoshareacademy.baseapp.statistics.Record;
import com.infoshareacademy.baseapp.statistics.Statistics;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/finanse/statistics")
public class StatisticsServlet extends HttpServlet{
    
    private Report report = Report.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(report.generateReport());
    }
}
