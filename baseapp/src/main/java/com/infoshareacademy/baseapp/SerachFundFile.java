package com.infoshareacademy.baseapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SerachFundFile {

    private String fileName;
    private String choosedFileName;
    Map<String, String> funds = new HashMap<>();
    ArrayList<String> hintsMap = new ArrayList<>();
    Scanner userInput = new Scanner(System.in);
    private boolean whileRun = true;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private void printHintsMap() {
        for (String s : hintsMap) {
            System.out.println(s);
        }
    }

    public String getChoosedFileName() {
        return choosedFileName;
    }

    public void setChoosedFileName(String choosedFileName) {
        this.choosedFileName = choosedFileName;
    }

    public String searchEngine(Map<String, String> fundsMap) {

        while (whileRun) {

           System.out.println("Podaj nazwę funduszu lub waluty:");
           String keyWord = userInput.nextLine();

            if (null != fundsMap.get(keyWord)) {
                hintsMap.add(fundsMap.get(keyWord));
                setFileName(hintsMap.get(0));
                setChoosedFileName(keyWord);
                System.out.println("Wybrałeś: " + getChoosedFileName());
                whileRun = false;
            } else {
                for (Map.Entry<String, String> entry : fundsMap.entrySet()) {
                    if (entry.getKey().startsWith(keyWord)) {
                        hintsMap.add(entry.getKey());
                    }
                }
                System.out.println("Twoje zpytanie pasuje do: " + "\n");
                printHintsMap();
                hintsMap.clear();
                System.out.println("Doprecyzuj zapytanie." + "\n");
            }
        }
        return fileName;
    }
}

