import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExtremumTest {

    private static final Fund FUND1 = newFund("SEB001", LocalDate.of(1998, 6,1), 100.00);
    private static final Fund FUND2= newFund("SEB001", LocalDate.of(2011, 1,7), 212.27);
    private static final Fund FUND3= newFund("SEB001", LocalDate.of(2015, 8,13), 179.02);

    private static Fund newFund(String name, LocalDate date, Double close) {
        Fund f = new Fund();
        f.setName(name);
        return f;
    }

    @Mock
    private Program program;
    private Extremum extremum;

    @Before
    public void setUp() {
        program = mock(Program.class);
        extremum = new Extremum();
    }

    @Test
    public void isFindMaxCorrect () {
        //given
        ArrayList<Fund> fundsList = new ArrayList<>();
        fundsList.add(FUND1);
        fundsList.add(FUND2);
        fundsList.add(FUND3);
        when(program.getFundsList()).thenReturn(fundsList);
        //when
        Fund max = extremum.findMax(fundsList);
        //then
        assertThat(max).isEqualTo(FUND2.getClose());
    }






}

