package main.java.com.infoshareacademy.baseapp;

import java.time.LocalDate;

public class Fund {

    private String name;
    private LocalDate date;
    private Double close;

    public Fund(String name, LocalDate date, Double close) {
        this.name = name;
        this.date = date;
        this.close = close;
    }

    public Fund(){
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fund fund = (Fund) o;

        return close.equals(fund.close);
    }

    @Override
    public int hashCode() {
        return close.hashCode();
    }

    @Override
    public String toString() {
        return "main.java.com.infoshareacademy.baseapp.Fund{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", close=" + close +
                '}'+ "\n";
    }
}