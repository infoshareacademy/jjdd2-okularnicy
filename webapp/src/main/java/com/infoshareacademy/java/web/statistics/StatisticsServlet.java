package com.infoshareacademy.java.web.statistics;

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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String days1 = req.getParameter("days1");
        getServletContext().setAttribute("days1", days1);
        String hours1 = req.getParameter("hours1");
        getServletContext().setAttribute("hours1", hours1);
        String minutes1 = req.getParameter("minutes1");
        getServletContext().setAttribute("minutes1", minutes1);
        String seconds1 = req.getParameter("seconds1");
        getServletContext().setAttribute("seconds1", seconds1);

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/statisticsDoGet.jsp");
        dispatcher.forward(req, resp);

    }

    public void setDurationAttributes(Duration duration, Integer index){
        DurationTransformationService durationTransformation = new DurationTransformationService();
        Long daysDuration = durationTransformation.getDays(duration);
        Long hoursDuration = durationTransformation.getHours(duration);
        Long minutesDuration = durationTransformation.getMinutes(duration);
        Long secondsDuration = durationTransformation.getSeconds(duration);
        getServletContext().setAttribute("daysDuration"+index.toString(), daysDuration);
        getServletContext().setAttribute("hoursDuration"+index.toString(), hoursDuration);
        getServletContext().setAttribute("minutesDuration"+index.toString(), minutesDuration);
        getServletContext().setAttribute("secondsDuration"+index.toString(), secondsDuration);
    }
}
