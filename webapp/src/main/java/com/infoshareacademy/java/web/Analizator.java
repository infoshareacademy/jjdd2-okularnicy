package com.infoshareacademy.java.web;

import com.infoshareacademy.baseapp.StartingParameters;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.Map.Entry;

@WebServlet("/analizator")
@MultipartConfig
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


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("we are here");

        Part file2 = null;
        file2 = req.getPart("file2");
        Scanner s = new Scanner(file2.getInputStream());
        String abcd = s.nextLine();
        writer.println(abcd);





    }
}
