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
import java.rmi.UnexpectedException;

@WebServlet("/email")
public class EmailWeb extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher ("/WEB-INF/emailDoGet.jsp");
        //if req.getParameter("errorCode")
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //com.infoshareacademy.baseapp.email.Email email = new com.infoshareacademy.baseapp.email.Email("infoshareokularnicy@wp.pl", "okularnicY", "smtp.wp.pl", 465);
        Email email = new Email("infoshareokularnicy@wp.pl", "okularnicY", "smtp.wp.pl", 465);
        //resp.getWriter().print("Hello world!");


        //resp.sendRedirect("email");

        /*try {
            email.send("infoshareokularnicy@wp.pl", "subject2", "hello world");
        } catch (MessagingException e) {
            //e.printStackTrace();
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher ("/WEB-INF/emailErrorSending?errorCode=555");
            resp.sendRedirect("emailErrorSending");
        }
*/

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher ("/WEB-INF/emailDoPost.jsp");
        dispatcher.forward(req, resp);
    }
}
