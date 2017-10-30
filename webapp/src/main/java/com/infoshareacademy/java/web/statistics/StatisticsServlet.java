package com.infoshareacademy.java.web.statistics;

import com.infoshareacademy.baseapp.statistics.DaysHoursMinutesSeconds;
import com.infoshareacademy.baseapp.statistics.DurationTransformationService;
import com.infoshareacademy.baseapp.statistics.Statistics;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

@WebServlet("/finanse/statistics")
public class StatisticsServlet extends HttpServlet {

    private Statistics statistics = Statistics.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDateTime now = LocalDateTime.now();
        Duration duration1 = Duration.ofSeconds(10);
        Duration duration2 = Duration.ofSeconds(20);
        LocalDateTime last1 = now.minus(duration1);
        LocalDateTime last2 = now.minus(duration2);

        setDurationAttributes(duration1,1);
        setDurationAttributes(duration2,2);

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

    public void setDurationAttributes(Duration duration, Integer index){
        DurationTransformationService durationTransformation = new DurationTransformationService();
        DaysHoursMinutesSeconds daysHoursMinutesSeconds = durationTransformation.getDaysHoursMinutesSeconds(duration);
        Long daysDuration = daysHoursMinutesSeconds.getDays();
        Long hoursDuration = daysHoursMinutesSeconds.getHours();
        Long minutesDuration = daysHoursMinutesSeconds.getMinutes();
        Long secondsDuration = daysHoursMinutesSeconds.getSecods();
        getServletContext().setAttribute("daysDuration"+index.toString(), daysDuration);
        getServletContext().setAttribute("hoursDuration"+index.toString(), hoursDuration);
        getServletContext().setAttribute("minutesDuration"+index.toString(), minutesDuration);
        getServletContext().setAttribute("secondsDuration"+index.toString(), secondsDuration);
    }
}
