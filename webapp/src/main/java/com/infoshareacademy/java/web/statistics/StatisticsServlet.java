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
        StringBuilder sb = new StringBuilder();
        
        sb.append("jestes w statystykach" + "\n");
        sb.append("" + "\n");
        sb.append("" + "\n");

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tenSecondsAgo = now.minusSeconds(10);
        LocalDateTime twentySecondsAgo = now.minusSeconds(20);

        sb.append("Calkowita liczba wyborow: " + statistics.getNumberOfVisits() + "\n");
        List<Record> recordsList = statistics.getAll();
        Map<String, Integer> numberOfVisitsEachName = new HashMap<>();
        for(Record record: recordsList){
            if ( numberOfVisitsEachName.containsKey(record.getName()) ){
                numberOfVisitsEachName.put(record.getName(), numberOfVisitsEachName.get(record.getName())+1);
            } else {
                numberOfVisitsEachName.put(record.getName(),1);
            }
        }
        sb.append(numberOfVisitsEachName.toString() + "\n");
        sb.append("" + "\n");
        sb.append("" + "\n");

        sb.append("w ciagu ostatnich 10 sekund: " + statistics.getNumberOfVisits(tenSecondsAgo, now) + "\n");
        recordsList = statistics.getAll(tenSecondsAgo, now);
        numberOfVisitsEachName = new HashMap<>();
        for(Record record: recordsList){
            if ( numberOfVisitsEachName.containsKey(record.getName()) ){
                numberOfVisitsEachName.put(record.getName(), numberOfVisitsEachName.get(record.getName())+1);
            } else {
                numberOfVisitsEachName.put(record.getName(),1);
            }
        }
        sb.append(numberOfVisitsEachName.toString() + "\n");
        sb.append("" + "\n");
        sb.append("" + "\n");

        sb.append("w ciagu ostatnich 20 sekund: " + statistics.getNumberOfVisits(twentySecondsAgo, now) + "\n");
        recordsList = statistics.getAll(twentySecondsAgo, now);
        numberOfVisitsEachName = new HashMap<>();
        for(Record record: recordsList){
            if ( numberOfVisitsEachName.containsKey(record.getName()) ){
                numberOfVisitsEachName.put(record.getName(), numberOfVisitsEachName.get(record.getName())+1);
            } else {
                numberOfVisitsEachName.put(record.getName(),1);
            }
        }
        sb.append(numberOfVisitsEachName.toString() + "\n");
        sb.append("" + "\n");
        sb.append("" + "\n");

        sb.append("Historia" + "\n");
        recordsList = statistics.getAll();
        for(Record record: recordsList){
            sb.append(record.getName() + ">>" + record.getDateTime() + "\n");
        }
        sb.append("" + "\n");
        sb.append("" + "\n");
        resp.getWriter().println(sb.toString());
    }
}
