package com.infoshareacademy.java.web.timer;

import com.google.gson.Gson;
import com.infoshareacademy.java.web.Configuration;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


public class TimerJsonReader {

    public TimerConfiguration readJsonFile(String json) throws IOException {
        TimerConfiguration timerConfiguration = new Gson().fromJson(json, TimerConfiguration.class);
        return timerConfiguration;
    }
}