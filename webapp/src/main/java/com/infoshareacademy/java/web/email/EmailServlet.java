package com.infoshareacademy.java.web.email;

import com.infoshareacademy.baseapp.email.EmailService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

@WebServlet("finanse/email")
public class EmailServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger("log4j-burst-filter");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/emailDoPost.jsp");
        dispatcher.forward(req, resp);
        logger.log(Level.INFO, "przekierowanie na emailDoPost.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpServletResponseWrapper responseWrapper = new HttpServletResponseWrapper(resp) {
            private final StringWriter sw = new StringWriter();

            @Override
            public PrintWriter getWriter() throws IOException {
                return new PrintWriter(sw);
            }

            @Override
            public String toString() {
                return sw.toString();
            }
        };

        req.getRequestDispatcher("/WEB-INF/emailDoPost.jsp").include(req, responseWrapper);
        String report = responseWrapper.toString();



        logger.log(Level.INFO, "start metody EmailServlet.doPost");
        String emailAddress = req.getParameter("emailAddress");
        logger.log(Level.INFO, "przyjeto parametr emailAddress=" + emailAddress);

        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("emailAddress", emailAddress);
        logger.log(Level.INFO, "ustawiono atrybut emailAddress=" + emailAddress);



        EmailService email = new EmailService("infoshareokularnicy@wp.pl", "okularnicY", "smtp.wp.pl", 465);
        logger.info("Utworzono obiekt klasy EmailService.");
        try {
            email.send(emailAddress, "Report", report);
        } catch (MessagingException e) {
            logger.error("Pojawił się błąd podczas wysyłania e-maila: " + e.getMessage());
            resp.sendRedirect("emailError");
            return;
        }
        logger.info("Wysłano e-mail.");
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/emailDoPost.jsp");
        dispatcher.forward(req, resp);
        logger.log(Level.INFO, "przekierowanie na emailDoPost.jsp");
    }
}
