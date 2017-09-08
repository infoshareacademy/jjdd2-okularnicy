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

    public String getName() {
        return name;
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
}






