package com.infoshareacademy.java.web.statistics;

import com.infoshareacademy.baseapp.statistics.Statistics;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/q")
public class StatisticsServlet extends HttpServlet{
    @Inject
    private Statistics statistics = new Statistics();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("jestes w statystykach");
        resp.getWriter().println("total>>" + statistics.getNumberOfVisits() + "<<");
    }
}
