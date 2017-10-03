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
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

@WebServlet("/analizator")
public class Analizator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException, ServletException {


        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<p>cos</p>");

        HashMap<String, String> filesHashMap = new HashMap<String, String>();
        StartingParameters startingParameters = new StartingParameters();
        writer.println("</p>");
        writer.println(getServletContext().getAttribute("LSTDir").toString());
        writer.println("</p>");

        String path = getServletContext().getAttribute("LSTDir").toString();
        String[] pathArray = new String[] {path};
        filesHashMap.putAll(startingParameters.startingParametersIntoMap(pathArray));

        int i = 1;
        Set<Entry<String, String>> entries = filesHashMap.entrySet();
        for(Entry<String, String> entry : entries){
            writer.println("<p>");
            writer.println("iteracja nr ");
            writer.println(i);
            writer.println(" <b>key:</b>");
            writer.println( entry.getKey());
            writer.println(" <b>value:</b>");
            writer.println(entry.getValue());
            writer.println("</p>");

        }




        /*RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher ("/WEB-INF/analizator.jsp");
        req.setAttribute("date", LocalDateTime.now());
        dispatcher.forward(req, resp);*/
    }
}
