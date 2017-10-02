package main.java;

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
import java.util.Scanner;

@WebServlet("/index")
@MultipartConfig
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");

        writer.println("<form action=\"index\" method=\"post\" enctype=\"multipart/form-data\">");
        writer.println("<input type=\"file\" name=\"userfile\"/>");
        writer.println("<button type=\"submit\">Wyslij</button>");
        writer.println("</form>");

        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part userfile = req.getPart("userfile");
        InputStream inputStream = userfile.getInputStream();
        Scanner scanner = new Scanner(inputStream);
        while(scanner.hasNextLine()){
            resp.getWriter().println(scanner.nextLine());
        }
    }
}
