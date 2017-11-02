package com.infoshareacademy.java.web.email;

import com.infoshareacademy.baseapp.email.EmailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/email")
public class EmailServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger("log4j-burst-filter");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/emailDoGet.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmailService email = new EmailService("infoshareokularnicy@wp.pl", "okularnicY", "smtp.wp.pl", 465);
        logger.info("Utworzono obiekt klasy EmailService.");
        try {
            email.send("infoshareokularnicy@wp.pl", "subject2", "hello world");
        } catch (MessagingException e) {
            //e.printStackTrace();
            logger.error("Pojawił się błąd podczas wysyłania e-maila: " + e.getMessage());
            resp.sendRedirect("emailError");
            return;
        }
        logger.info("Wysłano e-mail.");
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/emailDoPost.jsp");
        dispatcher.forward(req, resp);
    }
}
