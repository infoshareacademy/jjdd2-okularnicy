import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Scanner;

@WebServlet("/index3")
@MultipartConfig
public class Servlet3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");

        writer.println("<form action=\"index\" method=\"post\" enctype=\"multipart/form-data\">");
        writer.println("<input type=\"file\" name=\"userfile3\"/>");
        writer.println("<button type=\"submit\">Wyslij</button>");
        writer.println("</form>");

        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part userfile3 = req.getPart("userfile3");
        InputStream inputStream = userfile3.getInputStream();

        OutputStream outputStream = null;
        outputStream = new FileOutputStream(new File("/home/komputer/savedFile"));

        int read = 0;
        byte[] bytes = new byte[1024];

        while ((read = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, read);
        }

        resp.getWriter().println("done");




        /*Scanner scanner = new Scanner(inputStream);
        while(scanner.hasNextLine()){
            resp.getWriter().println(scanner.nextLine());
        }*/
    }
}

