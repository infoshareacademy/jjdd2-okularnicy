package com.infoshareacademy.java.web.statistics;

import com.infoshareacademy.baseapp.statistics.DurationTransformationService;
import com.infoshareacademy.baseapp.statistics.Statistics;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
        ServletContext servletContext = getServletContext();

        Duration duration1 = (Duration) servletContext.getAttribute("duration1");
        if (duration1 == null) {
            duration1 = Duration.ofDays(9).plusHours(8).plusMinutes(7).plusSeconds(6);
            servletContext.setAttribute("duration1", duration1);
        }

        Duration duration2 = (Duration) servletContext.getAttribute("duration2");
        if (duration2 == null) {
            duration2 = Duration.ofDays(5).plusHours(4).plusMinutes(3).plusSeconds(2);
            servletContext.setAttribute("duration2", duration2);
        }

        DurationTransformationService durationTransformation = new DurationTransformationService();

        Long daysDuration1 = durationTransformation.getDays(duration1);
        Long hoursDuration1 = durationTransformation.getHours(duration1);
        Long minutesDuration1 = durationTransformation.getMinutes(duration1);
        Long secondsDuration1 = durationTransformation.getSeconds(duration1);
        servletContext.setAttribute("daysDuration1", daysDuration1);
        servletContext.setAttribute("hoursDuration1", hoursDuration1);
        servletContext.setAttribute("minutesDuration1", minutesDuration1);
        servletContext.setAttribute("secondsDuration1", secondsDuration1);

        Long daysDuration2 = durationTransformation.getDays(duration1);
        Long hoursDuration2 = durationTransformation.getHours(duration1);
        Long minutesDuration2 = durationTransformation.getMinutes(duration1);
        Long secondsDuration2 = durationTransformation.getSeconds(duration1);
        servletContext.setAttribute("daysDuration2", daysDuration2);
        servletContext.setAttribute("hoursDuration2", hoursDuration2);
        servletContext.setAttribute("minutesDuration2", minutesDuration2);
        servletContext.setAttribute("secondsDuration2", secondsDuration2);







        LocalDateTime now = LocalDateTime.now();

        LocalDateTime last1 = now.minus(duration1);
        LocalDateTime last2 = now.minus(duration2);

        setStatisticsAttributes(now, last1, last2);

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/statisticsDoGet.jsp");
        dispatcher.forward(req, resp);
    }

    public void setStatisticsAttributes(LocalDateTime now, LocalDateTime last1, LocalDateTime last2){
        getServletContext().setAttribute("NumberOfVisitsLast1", statistics.getNumberOfVisits(last1, now));
        getServletContext().setAttribute("OccurrenceMapLast1", statistics.getOccurrenceMap(last1, now));
        getServletContext().setAttribute("NumberOfVisitsLast2", statistics.getNumberOfVisits(last2, now));
        getServletContext().setAttribute("OccurrenceMapLast2", statistics.getOccurrenceMap(last2, now));
        getServletContext().setAttribute("NumberOfVisitsTotal", statistics.getNumberOfVisits());
        getServletContext().setAttribute("OccurrenceMapTotal", statistics.getOccurrenceMap());
        getServletContext().setAttribute("RecordsListTotal", statistics.getAll());
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
}
