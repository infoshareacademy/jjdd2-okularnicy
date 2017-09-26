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
public class Servlet4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");

        writer.println("<form action=\"index\" method=\"post\" enctype=\"multipart/form-data\">");

        writer.println("<p>Tutaj wskaż plik LST: ");
        writer.println("<input type=\"file\" name=\"fileLST\"/>");
        writer.println("</p>");

        writer.println("<p>Tutaj wskaż archiwum ZIP: ");
        writer.println("<input type=\"file\" name=\"fileZIP\"/>");
        writer.println("</p>");

        writer.println("<button type=\"submit\">Wyslij</button>");

        writer.println("</form>");

        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Part fileLST = null;
        fileLST = req.getPart("fileLST");
        InputStream inputStreamLST = null;
        inputStreamLST = fileLST.getInputStream();
        Scanner scannerLST = null;
        scannerLST = new Scanner(inputStreamLST);
        for (int i = 0; i < 3; i++) {
            resp.getWriter().println(scannerLST.nextLine());
        }
        resp.getWriter().println("== k o n i e c LST==");

        Part fileZIP = null;
        fileZIP = req.getPart("fileZIP");
        InputStream inputStreamZIP = null;
        inputStreamZIP = fileZIP.getInputStream();
        Scanner scannerZIP = null;
        scannerZIP = new Scanner(inputStreamZIP);
        for (int i = 0; i < 3; i++) {
            resp.getWriter().println(scannerZIP.nextLine());
        }
        resp.getWriter().println("== k o n i e c ZIP==");


        /*try {
            Part userfile3 = null;
            userfile3 = req.getPart("userfile3");
            InputStream inputStream = null;
            inputStream = userfile3.getInputStream();
            String tmpDir = System.getProperty("java.io.tmpdir");
            tmpDir = tmpDir + "/plik";
            OutputStream outputStream = null;
            outputStream = new FileOutputStream(new File(tmpDir));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            resp.getWriter().println("done");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }*/

    }
}
