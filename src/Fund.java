import java.time.LocalDate;

public class Fund {

    private String Name;
    private LocalDate Date;
    private double Open;
    private double High;
    private double Low;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public double getOpen() {
        return Open;
    }

    public void setOpen(double open) {
        Open = open;
    }

    public double getHigh() {
        return High;
    }

    public void setHigh(double high) {
        High = high;
    }

    public double getLow() {
        return Low;
    }

    public void setLow(double low) {
        Low = low;
    }

    public double getClose() {
        return Close;
    }

    public void setClose(double close) {
        Close = close;
    }

    public double getVolume() {
        return Volume;
    }

    public void setVolume(double volume) {
        Volume = volume;
    }

    private double Close;
    private double Volume;


}
