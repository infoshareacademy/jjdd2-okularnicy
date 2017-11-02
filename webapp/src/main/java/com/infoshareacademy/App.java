package com.infoshareacademy;

import com.infoshareacademy.baseapp.email.EmailScheduler;
import com.infoshareacademy.baseapp.email.EmailService;
import com.infoshareacademy.java.web.Configuration;
import com.infoshareacademy.java.web.JsonReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jcp.xml.dsig.internal.dom.Utils;

import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.io.InputStream;
import java.text.ParseException;

@ApplicationPath("/")
public class App extends Application {

    private final Logger logger = LogManager.getLogger("log4j-burst-filter");
    Configuration configuration = new Configuration();
    JsonReader jsonReader = new JsonReader();

    public App() throws ParseException {
        logger.log(Level.INFO, "start");
        String json = loadJSONFromProject("../../../webapp/WEB-INF/configuration.json");
        logger.log(Level.INFO, "tresc jsona: " + json);


        new EmailScheduler().startSendingEMails(60);

        logger.log(Level.INFO, "wyslano e-mail");

    }

    public static String loadJSONFromProject(String filename) {
        String json = "";
        try {
            InputStream is = Utils.class.getResourceAsStream(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return json;
    }

}
