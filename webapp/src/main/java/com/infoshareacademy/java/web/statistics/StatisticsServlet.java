package com.infoshareacademy.java.web.statistics;

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
    @Inject
    @Singleton
    private Statistics statistics = Statistics.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("jestes w statystykach");
        resp.getWriter().println("");
        resp.getWriter().println("");

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tenSecondsAgo = now.minusSeconds(10);
        LocalDateTime twentySecondsAgo = now.minusSeconds(20);
        resp.getWriter().println("now(): "+ now);
        resp.getWriter().println("10 seconds ago: " + tenSecondsAgo);
        resp.getWriter().println("20 seconds ago: " + twentySecondsAgo);
        resp.getWriter().println("");
        resp.getWriter().println("");

        resp.getWriter().println("total>>" + statistics.getNumberOfVisits() + "<<");
        resp.getWriter().println("w ciagu ostatnich 10 sekund>>" + statistics.getNumberOfVisits(tenSecondsAgo, now) + "<<");
        resp.getWriter().println("w ciagu ostatnich 20 sekund>>" + statistics.getNumberOfVisits(twentySecondsAgo, now) + "<<");
        resp.getWriter().println("");
        resp.getWriter().println("");

        List<Record> recordsList = statistics.getAll();
        Map<String, Integer> numberOfVisitsEachName = new HashMap<>();
        for(Record record: recordsList){
            resp.getWriter().println(record.getName() + ">>" + record.getDateTime());
            if ( numberOfVisitsEachName.containsKey(record.getName()) ){
                numberOfVisitsEachName.put(record.getName(), numberOfVisitsEachName.get(record.getName())+1);
            } else {
                numberOfVisitsEachName.put(record.getName(),1);
            }
        }
        resp.getWriter().println("");
        resp.getWriter().println("");

        resp.getWriter().println(numberOfVisitsEachName.toString());
    }
}
