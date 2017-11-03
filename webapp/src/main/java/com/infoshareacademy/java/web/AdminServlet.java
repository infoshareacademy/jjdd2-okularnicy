package com.infoshareacademy.java.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/finanse/admin")
public class AdminServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean isUserAdmin = (Boolean) request.getSession().getAttribute("isAdmin");

        if (isUserAdmin) {
            response.sendRedirect("/finanse/statistics");
        }

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/permissionDenied.jsp");
        dispatcher.forward(request, response);

        }
    }

