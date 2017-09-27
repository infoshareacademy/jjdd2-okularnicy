import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Part fileLST = null;
            Part fileZIP = null;
            fileLST = req.getPart("fileLST");
            fileZIP = req.getPart("fileZIP");
            InputStream inputStreamLST = null;
            InputStream inputStreamZIP = null;
            inputStreamLST = fileLST.getInputStream();
            inputStreamZIP = fileZIP.getInputStream();
            String tmpDir = System.getProperty("java.io.tmpdir");
            String LSTDir = tmpDir + "/plik.lst.txt";
            String ZIPDir = tmpDir + "/plik.zip.txt";
            OutputStream outputStreamLST = null;
            OutputStream outputStreamZIP = null;
            outputStreamLST = new FileOutputStream(new File(LSTDir));
            outputStreamZIP = new FileOutputStream(new File(ZIPDir));
            int readLST = 0;
            int readZIP = 0;
            byte[] bytesLST = new byte[1024];
            byte[] bytesZIP = new byte[1024];
            while ((readLST = inputStreamLST.read(bytesLST)) != -1) {
                outputStreamLST.write(bytesLST, 0, readLST);
            }
            while ((readZIP = inputStreamZIP.read(bytesZIP)) != -1) {
                outputStreamZIP.write(bytesZIP, 0, readZIP);
            }

            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = resp.getWriter();
            writer.println("<p>done</p>");
            writer.println("<p>tutaj będzie link do drugiego servletu</p>");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
