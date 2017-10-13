package com.infoshareacademy.java.web.email;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/email")
public class Email extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher ("/WEB-INF/emailDoGet.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        com.infoshareacademy.baseapp.email.Email email = new com.infoshareacademy.baseapp.email.Email("infoshareokularnicy@wp.pl", "okularnicY", "smtp.wp.pl", 465);
        email.send("infoshareokularnicy@wp.pl", "subject2", "hello world");
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher ("/WEB-INF/emailDoPost.jsp");
        dispatcher.forward(req, resp);
    }
}
