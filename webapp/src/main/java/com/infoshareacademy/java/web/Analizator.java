package com.infoshareacademy.java.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.time.LocalDateTime;

@WebServlet("/analizator")
public class Analizator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException, ServletException {

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher ("/WEB-INF/analizator.jsp");
        req.setAttribute("date", LocalDateTime.now());
        dispatcher.forward(req, resp);

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
    }
}
