package com.infoshareacademy.java.web;

import com.infoshareacademy.baseapp.UnZip;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/start2")
public class Start2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher ("/WEB-INF/start2DoGet.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String targetDir = String.valueOf(getServletContext().getAttribute("targetDir"));
        String ZIPDir = String.valueOf(getServletContext().getAttribute("ZIPDir"));

        String unZippedDir = targetDir + "/unzipped";//to properties
        getServletContext().setAttribute("unZippedDir", unZippedDir);
        File unZippedDirFolder = new File(unZippedDir);
        if(!unZippedDirFolder.exists()){
            unZippedDirFolder.mkdir();
        }

        UnZip unZip = new UnZip();
        unZip.unZip(ZIPDir,unZippedDir);

        resp.sendRedirect("analizator");
    }
}
