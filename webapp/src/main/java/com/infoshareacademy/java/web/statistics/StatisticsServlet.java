package com.infoshareacademy.java.web.statistics;

import com.infoshareacademy.baseapp.statistics.Statistics;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/finanse/statistics")
public class StatisticsServlet extends HttpServlet {

    @Inject
    private Statistics statistics;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime last1 = now.minusSeconds(10);
        LocalDateTime last2 = now.minusSeconds(20);
        getServletContext().setAttribute("NumberOfVisitsLast1", statistics.getNumberOfVisits(last1, now));
        getServletContext().setAttribute("OccurrenceMapLast1", statistics.getOccurrenceMap(last1, now));
        getServletContext().setAttribute("NumberOfVisitsLast2", statistics.getNumberOfVisits(last2, now));
        getServletContext().setAttribute("OccurrenceMapLast2", statistics.getOccurrenceMap(last2, now));
        getServletContext().setAttribute("NumberOfVisitsTotal", statistics.getNumberOfVisits());
        getServletContext().setAttribute("OccurrenceMapTotal", statistics.getOccurrenceMap());
        getServletContext().setAttribute("RecordsListTotal", statistics.getAll());
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/statisticsDoGet.jsp");
        dispatcher.forward(req, resp);
    }
}
