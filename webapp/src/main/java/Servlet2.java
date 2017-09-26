import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Scanner;

@WebServlet("/index2")
@MultipartConfig
public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html lang=\"en\">");
        writer.println("<head>");
        writer.println("<title>File Upload</title>");
        writer.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<form method=\"POST\" action=\"upload\" enctype=\"multipart/form-data\" >");
        writer.println("File:");
        writer.println("<input type=\"file\" name=\"file\" id=\"file\" /> <br/>");
        writer.println("Destination:");
        writer.println("<input type=\"text\" value=\"/tmp\" name=\"destination\"/>");
        writer.println("</br>");
        writer.println("<input type=\"submit\" value=\"Upload\" name=\"upload\" id=\"upload\" />");
        writer.println("</form>");
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part userfile = req.getPart("userfile");
        InputStream inputStream = userfile.getInputStream();


        File uploadedfile;
        Scanner scanner = new Scanner(inputStream);
        while(scanner.hasNextLine()){
            resp.getWriter().println(scanner.nextLine());
        }
    }
}
