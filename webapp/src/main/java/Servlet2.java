import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/index2")
public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        writer.println("<p>getServletContext().getAttribute(\"pathLST\"): ");
        writer.println(getServletContext().getAttribute("pathLST"));
        writer.println("</p>");

        writer.println("<p>getServletContext().getAttribute(\"pathZIP\"): ");
        writer.println(getServletContext().getAttribute("pathZIP"));
        writer.println("</p>");
    }
}
