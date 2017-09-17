import java.time.LocalDate;
import java.util.ArrayList;

public class TestLocalExtremum {
    public static void main(String[] args) {

        Fund fund1 = new Fund("Fund1", LocalDate.of(2017, 9, 8), 89.00);
        Fund fund2 = new Fund("Fund2", LocalDate.of(2017, 9, 9), 106.00);
        Fund fund3 = new Fund("Fund3", LocalDate.of(2017, 9, 10), 99.00);
        Fund fund4 = new Fund("Fund4", LocalDate.of(2017, 9, 11), 103.00);
        Fund fund5 = new Fund("Fund5", LocalDate.of(2017, 9, 14), 104.00);

        ArrayList<Fund> test = new ArrayList<Fund>();
        test.add(fund1);
        test.add(fund2);
        test.add(fund3);
        test.add(fund4);
        test.add(fund5);

        LocalExtremum localExtremum = new LocalExtremum();

        Fund fundMin = localExtremum.findMinByDate(test);
        Fund fundMax = localExtremum.findMaxByDate(test);
        System.out.println("Wartość minimalna: " + fundMin.getClose());
        System.out.println("Wartość maksymalna: " + fundMax.getClose());
    }
}