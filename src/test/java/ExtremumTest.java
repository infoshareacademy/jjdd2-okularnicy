import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ExtremumTest {

    private static final Fund FUND1 = newFund("SEB001", LocalDate.of(1998, 6,1), 100.00);
    private static final Fund FUND2= newFund("SEB001", LocalDate.of(2011, 1,7), 212.27);
    private static final Fund FUND3= newFund("SEB001", LocalDate.of(2015, 8,13), 179.02);

    private static Fund newFund(String name, LocalDate date, Double close) {
        Fund f = new Fund();
        f.setName(name);
        f.setDate(date);
        f.setClose(close);
        return f;
    }

    private Extremum extremum;

    @Before
    public void setUp() {
        extremum = new Extremum();
    }

    @Test
    public void isFindMaxAndFindMinIsCorrect () {
        //given
        ArrayList<Fund> fundsList = new ArrayList<>();
        fundsList.add(FUND1);
        fundsList.add(FUND2);
        fundsList.add(FUND3);
        //when
        Fund max = extremum.findMax(fundsList);
        Fund min = extremum.findMin(fundsList);
        //then
        assertThat(max.getClose(), is(FUND2.getClose()));
        assertThat(min.getClose(), is(FUND1.getClose()));
    }
}

