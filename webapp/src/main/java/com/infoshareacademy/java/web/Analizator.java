package com.infoshareacademy.java.web;

import com.infoshareacademy.baseapp.StartingParameters;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@WebServlet("/analizator")
public class Analizator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException, ServletException {
        String LSTDir = getServletContext().getAttribute("LSTDir").toString();
        String[] LSTDirArray = new String[] {LSTDir};

        HashMap<String, String> filesHashMap = new HashMap<String, String>();
        StartingParameters startingParameters = new StartingParameters();
        filesHashMap.putAll(startingParameters.startingParametersIntoMap(LSTDirArray));

        /*Map<String, String> foods = new HashMap<String, String>();
        foods.put("man", "mango");
        foods.put("app", "apple");
        foods.put("gra", "grapes");
        req.setAttribute("foods", foods);*/


        req.setAttribute("filesHashMap", filesHashMap);

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher ("/WEB-INF/analizatorDoGet.jsp");
        dispatcher.forward(req, resp);
    }
}
