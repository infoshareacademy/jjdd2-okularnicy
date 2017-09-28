package main.java.com.infoshareacademy.baseapp;

import java.util.Comparator;

public class MyDescComparator implements Comparator<Fund> {

    @Override
    public int compare(Fund o1, Fund o2) {
        if (o1.getClose() < o2.getClose()) {
            return 1;
        } else if (o1.getClose() > o2.getClose()) {
            return -1;
        }
        return 0;
    }
}