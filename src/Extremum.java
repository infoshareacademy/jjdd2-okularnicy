import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class Extremum {

    private Fund max;
    private Fund min;

    public Fund getMax() {
        return max;
    }

    public void setMax(Fund max) {
        this.max = max;
    }

    public Fund getMin() {
        return min;
    }

    public void setMin(Fund min) {
        this.min = min;
    }

    public Fund min() {

        Fund fund1 = new Fund("Fund1", LocalDate.of(2017, 9, 8), 100.00);
        Fund fund2 = new Fund("Fund2", LocalDate.of(2017, 9, 8), 102.00);
        Fund fund3 = new Fund("Fund3", LocalDate.of(2017, 9, 8), 104.00);
        Fund fund4 = new Fund("Fund4", LocalDate.of(2017, 9, 8), 103.00);
        Fund fund5 = new Fund("Fund5", LocalDate.of(2017, 9, 8), 101.00);

        ArrayList<Fund> test = new ArrayList<Fund>();
        test.add(fund1);
        test.add(fund2);
        test.add(fund3);
        test.add(fund4);
        test.add(fund5);

        Collections.sort(test, new MyComparator(false));
        setMin(test.get(0));
        return min;

    }

    public Fund max() {

        Fund fund1 = new Fund("Fund1", LocalDate.of(2017, 9, 8), 100.00);
        Fund fund2 = new Fund("Fund2", LocalDate.of(2017, 9, 8), 102.00);
        Fund fund3 = new Fund("Fund3", LocalDate.of(2017, 9, 8), 104.00);
        Fund fund4 = new Fund("Fund4", LocalDate.of(2017, 9, 8), 103.00);
        Fund fund5 = new Fund("Fund5", LocalDate.of(2017, 9, 8), 101.00);

        ArrayList<Fund> test = new ArrayList<Fund>();
        test.add(fund1);
        test.add(fund2);
        test.add(fund3);
        test.add(fund4);
        test.add(fund5);

        Collections.sort(test, new MyComparator(true));
        setMax(test.get(0));
        return max;

    }







}





