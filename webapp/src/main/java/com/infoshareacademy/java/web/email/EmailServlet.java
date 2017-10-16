package com.infoshareacademy.java.web.email;

import com.infoshareacademy.baseapp.email.Email;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher ("/WEB-INF/emailDoGet.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Email email = new Email("infoshareokularnicy@wp.pl", "okularnicY_", "smtp.wp.pl", 465);
        try {
            email.send("infoshareokularnicy@wp.pl", "subject2", "hello world");
        } catch (MessagingException e) {
            //e.printStackTrace();
            resp.sendRedirect("emailError");
        }
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher ("/WEB-INF/emailDoPost.jsp");
        dispatcher.forward(req, resp);
    }
}
