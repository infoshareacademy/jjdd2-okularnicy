package com.infoshareacademy.java.web;

import com.infoshareacademy.baseapp.FundBase;
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
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@WebServlet("/analizator")
@MultipartConfig
public class Analizator extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part choseFund = null;
        choseFund = req.getPart("choseFund");
        Scanner scanner = new Scanner(choseFund.getInputStream());
        String choseFundString = scanner.nextLine();
        getServletContext().setAttribute("choseFundString", choseFundString);

        resp.sendRedirect("menu");
    }
}