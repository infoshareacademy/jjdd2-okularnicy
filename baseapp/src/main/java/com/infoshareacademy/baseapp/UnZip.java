package com.infoshareacademy.baseapp;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZip {
    private final Logger logger = LogManager.getLogger("log4j-burst-filter");

    public void unZip(String zipFile, String outputFolder){

        byte[] buffer = new byte[1024];
        File folder = new File(outputFolder);
        if(!folder.exists()){
            folder.mkdir();
        }
        ZipInputStream zipInputStream = null;
        try {
            zipInputStream = new ZipInputStream(new FileInputStream(zipFile));
            ZipEntry zipEntry = zipInputStream.getNextEntry();
            while(zipEntry!=null){
                String fileName = zipEntry.getName();
                File newFile = new File(outputFolder + File.separator + fileName);
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fileOutputStream = new FileOutputStream(newFile);
                int length;
                while((length = zipInputStream.read(buffer)) > 0){
                    fileOutputStream.write(buffer, 0, length);
                }
                fileOutputStream.close();
                zipEntry = zipInputStream.getNextEntry();
            }
            zipInputStream.closeEntry();
            zipInputStream.closeEntry();

        } catch (FileNotFoundException e) 
            logger.log(Level.ERROR, "Wyjątek: FileNotFoundException");
        } catch (IOException f) {
            logger.log(Level.ERROR, "Wyjątek: IOException");

        }
    }
}