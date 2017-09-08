import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Comparator;


public class Extremum implements Comparator<Fund> {



        public void testLista(){

            Fund max = fund1;
            Fund min;

        Fund fund1 = new Fund("Fund1", LocalDate.of(2017,9,8), 100, 500, 50, 200, 0);
        Fund fund2 = new Fund("Fund2", LocalDate.of(2017,9,8), 102, 508, 52, 205, 0);
        Fund fund3 = new Fund("Fund3", LocalDate.of(2017,9,8), 104, 510, 54, 207, 0);
        Fund fund4 = new Fund("Fund4", LocalDate.of(2017,9,8), 103, 502, 53, 209, 0);
        Fund fund5 = new Fund("Fund5", LocalDate.of(2017,9,8), 101, 503, 51, 212, 0);

        ArrayList<Fund> test = new ArrayList<Fund>();
        test.add(fund1);
        test.add(fund2);
        test.add(fund3);
        test.add(fund4);
        test.add(fund5);


            for (int i=0; i < test.size(); i++){
                int wynik = compare(max, fund1);
    }

      }




    @Override
    public int compare(Fund o1, Fund o2) {
        return o1.getClose().compareTo(o2.getClose());
    }
}

