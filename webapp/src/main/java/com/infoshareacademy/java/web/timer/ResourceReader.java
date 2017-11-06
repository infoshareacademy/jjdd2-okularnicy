package com.infoshareacademy.java.web.timer;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;

public class ResourceReader {
    private final Logger logger = LogManager.getLogger(getClass());

    String result;

    public String getStringFromResource(String file) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(file);
        logger.info("getStringFromResource.InputStream=" + is);
        try {
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            result = new String(buffer, "UTF-8");
        } catch (Exception ex) {
            logger.info(ex.getMessage());
        }
        return result;
    }
}
