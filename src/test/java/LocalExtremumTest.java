import org.junit.Before;
import org.junit.Test;
import org.mockito.cglib.core.Local;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LocalExtremumTest {

    private static final Fund FUND1 = newFund("SEB001", LocalDate.of(1998, 6, 1), 100.00);
    private static final Fund FUND2 = newFund("SEB001", LocalDate.of(2011, 1, 7), 212.27);
    private static final Fund FUND3 = newFund("SEB001", LocalDate.of(2015, 8, 13), 179.02);
    private static final Fund FUND4 = newFund("SEB001", LocalDate.of(2016, 6, 25), 102.52);
    private static final Fund FUND5 = newFund("SEB001", LocalDate.of(2017, 5, 11), 320.09);
    private static final LocalDate START_DATE = LocalDate.of(2015, 8,13 );
    private static final LocalDate END_DATE = LocalDate.of(2017, 5,11 );

    private static Fund newFund(String name, LocalDate date, Double close) {
        Fund f = new Fund();
        f.setName(name);
        f.setDate(date);
        f.setClose(close);
        return f;
    }

    private LocalExtremum localExtremum;

    @Before
    public void setUp() {
        localExtremum = new LocalExtremum();
    }

    @Test
    public void isFindMaxByDateAndFindMinByDateIsCorrect () {
        //given
        ArrayList<Fund> fundsList = new ArrayList<>();
        fundsList.add(FUND1);
        fundsList.add(FUND2);
        fundsList.add(FUND3);
        fundsList.add(FUND4);
        fundsList.add(FUND5);

        //when
        Fund max = localExtremum.findMaxByDate(fundsList, START_DATE, END_DATE);
        Fund min = localExtremum.findMinByDate(fundsList, START_DATE, END_DATE);
        //then
        assertThat(max.getClose()).isEqualTo(FUND5.getClose());
        assertThat(min.getClose()).isEqualTo(FUND4.getClose());
    }


}
