package com.infoshareacademy.java.web;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import com.google.gson.Gson;


public class JsonReader {

    public Configuration readJsonFile(String path) throws IOException {
        try (Reader reader = new FileReader(path)) {
            Configuration configuration = new Gson().fromJson(reader, Configuration.class);
            System.out.println(configuration);
            return configuration;
        }
    }
}