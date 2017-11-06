package com.infoshareacademy.java.web.statistics;

import com.infoshareacademy.baseapp.statistics.DurationTransformationService;
import com.infoshareacademy.baseapp.statistics.Statistics;
import com.infoshareacademy.java.web.Configuration;
import com.infoshareacademy.java.web.JsonReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    private final Logger logger = LogManager.getLogger("log4j-burst-filter");
    private Statistics statistics = Statistics.getInstance();
    Configuration configuration = new Configuration();
    JsonReader jsonReader = new JsonReader();

    private Duration duration1;
    private Duration duration2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            boolean isAdmin = Boolean.valueOf(req.getSession().getAttribute("admin").toString());

            if(!isAdmin) {
                logger.info("Użytkownik nie jest adminem");
                RequestDispatcher dispatcher = getServletContext()
                        .getRequestDispatcher("/WEB-INF/startDoGet.jsp");
                dispatcher.forward(req, resp);
            }

            logger.log(Level.INFO, "start metody StatisticsServlet.doGet");
            configuration = jsonReader.readJsonFile(getServletContext().getResource("/WEB-INF/configuration.json").getPath());

            ServletContext servletContext = getServletContext();

            duration1 = (Duration) servletContext.getAttribute("duration1");
            if (duration1 == null) {
                logger.log(Level.INFO, "servletContext.getAttribute(\"duration1\")=null");
                duration1 = Duration.ofDays(configuration.getInitialDaysDuration1())
                        .plusHours(configuration.getInitialHoursDuration1())
                        .plusMinutes(configuration.getInitialMinutesDuration1())
                        .plusSeconds(configuration.getInitialSecondsDuration1());
                servletContext.setAttribute("duration1", duration1);
            } else {
                logger.log(Level.INFO, "servletContext.getAttribute(\"duration1\")=" + duration1.toString());
            }

            duration2 = (Duration) servletContext.getAttribute("duration2");
            if (duration2 == null) {
                logger.log(Level.INFO, "servletContext.getAttribute(\"duration2\")=null");
                duration2 = Duration.ofDays(configuration.getInitialDaysDuration2())
                        .plusHours(configuration.getInitialHoursDuration2())
                        .plusMinutes(configuration.getInitialMinutesDuration2())
                        .plusSeconds(configuration.getInitialSecondsDuration2());
                servletContext.setAttribute("duration2", duration2);
            } else {
                logger.log(Level.INFO, "servletContext.getAttribute(\"duration2\")=" + duration2.toString());
            }

            setStatisticsAttributes(duration1, duration2);

            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/WEB-INF/statistics.jsp");
            dispatcher.forward(req, resp);
        } catch (RuntimeException e) {
            logger.error("Blad na stronie extrema globalne: " + e);
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/WEB-INF/error.jsp");
            dispatcher.forward(req, resp);
        } catch (IOException e) {
            logger.error("Blad na stronie extrema globalne: " + e);
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/WEB-INF/error.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            logger.log(Level.INFO, "start metody StatisticsServlet.doPost");
            Integer days1 = Integer.parseInt(req.getParameter("days1"));
            Integer hours1 = Integer.parseInt(req.getParameter("hours1"));
            Integer minutes1 = Integer.parseInt(req.getParameter("minutes1"));
            Integer seconds1 = Integer.parseInt(req.getParameter("seconds1"));
            Integer days2 = Integer.parseInt(req.getParameter("days2"));
            Integer hours2 = Integer.parseInt(req.getParameter("hours2"));
            Integer minutes2 = Integer.parseInt(req.getParameter("minutes2"));
            Integer seconds2 = Integer.parseInt(req.getParameter("seconds2"));

            ServletContext servletContext = getServletContext();

            duration1 = Duration.ofDays(days1)
                    .plusHours(hours1)
                    .plusMinutes(minutes1)
                    .plusSeconds(seconds1);
            servletContext.setAttribute("duration1", duration1);

            duration2 = Duration.ofDays(days2)
                    .plusHours(hours2)
                    .plusMinutes(minutes2)
                    .plusSeconds(seconds2);
            servletContext.setAttribute("duration2", duration2);

            setStatisticsAttributes(duration1, duration2);

            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/WEB-INF/statistics.jsp");
            dispatcher.forward(req, resp);
        } catch (RuntimeException e) {
            logger.error("Blad na stronie extrema globalne: " + e);
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/WEB-INF/error.jsp");
            dispatcher.forward(req, resp);
        } catch (IOException e) {
            logger.error("Blad na stronie extrema globalne: " + e);
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/WEB-INF/error.jsp");
            dispatcher.forward(req, resp);
        }
    }

    private void setStatisticsAttributes(Duration duration1, Duration duration2) {
        ServletContext servletContext = getServletContext();
        DurationTransformationService durationTransformation = new DurationTransformationService();

        Long daysDuration1 = durationTransformation.getDays(duration1);
        Long hoursDuration1 = durationTransformation.getHours(duration1);
        Long minutesDuration1 = durationTransformation.getMinutes(duration1);
        Long secondsDuration1 = durationTransformation.getSeconds(duration1);
        servletContext.setAttribute("daysDuration1", daysDuration1);
        servletContext.setAttribute("hoursDuration1", hoursDuration1);
        servletContext.setAttribute("minutesDuration1", minutesDuration1);
        servletContext.setAttribute("secondsDuration1", secondsDuration1);

        Long daysDuration2 = durationTransformation.getDays(duration2);
        Long hoursDuration2 = durationTransformation.getHours(duration2);
        Long minutesDuration2 = durationTransformation.getMinutes(duration2);
        Long secondsDuration2 = durationTransformation.getSeconds(duration2);
        servletContext.setAttribute("daysDuration2", daysDuration2);
        servletContext.setAttribute("hoursDuration2", hoursDuration2);
        servletContext.setAttribute("minutesDuration2", minutesDuration2);
        servletContext.setAttribute("secondsDuration2", secondsDuration2);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime last1 = now.minus(duration1);
        LocalDateTime last2 = now.minus(duration2);

        servletContext.setAttribute("NumberOfVisitsLast1", statistics.getNumberOfVisits(last1, now));
        servletContext.setAttribute("OccurrenceMapLast1", statistics.getOccurrenceMap(last1, now));
        servletContext.setAttribute("NumberOfVisitsLast2", statistics.getNumberOfVisits(last2, now));
        servletContext.setAttribute("OccurrenceMapLast2", statistics.getOccurrenceMap(last2, now));
        servletContext.setAttribute("NumberOfVisitsTotal", statistics.getNumberOfVisits());
        servletContext.setAttribute("OccurrenceMapTotal", statistics.getOccurrenceMap());
        servletContext.setAttribute("RecordsListTotal", statistics.getAllFormatted());
    }
}
