import com.infoshareacademy.baseapp.Fund;
import com.infoshareacademy.baseapp.ListInRange;
import com.infoshareacademy.baseapp.Program;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ListInRangeTest {

    private static final Fund FUND1 = new Fund("SEB001", LocalDate.of(1998, 6, 1), 100.00);
    private static final Fund FUND2 = new Fund("SEB001", LocalDate.of(1999, 5, 29), 103.00);
    private static final Fund FUND3 = new Fund("SEB001", LocalDate.of(2004, 6, 27), 125.00);
    private static final Fund FUND4 = new Fund("SEB001", LocalDate.of(2011, 1, 7), 212.27);
    private static final Fund FUND5 = new Fund("SEB001", LocalDate.of(2015, 8, 13), 179.02);
    private static final LocalDate START_DATE = LocalDate.of(1999, 3, 12);
    private static final LocalDate END_DATE = LocalDate.of(2014, 5, 12);

    @Mock
    private Program program;
    private ListInRange listInRange;

    @Before
    public void init() {
        listInRange = new ListInRange(program);
    }

    @Test
    public void isSetListInRangeIsCorrect() {
        //given
        ArrayList<Fund> fundsList = new ArrayList<>();
        fundsList.add(FUND1);
        fundsList.add(FUND2);
        fundsList.add(FUND3);
        fundsList.add(FUND4);
        fundsList.add(FUND5);
        when(program.getFundsList()).thenReturn(fundsList);
        when(program.getStartDate()).thenReturn(START_DATE);
        when(program.getEndDate()).thenReturn(END_DATE);
        //when
        List<Fund> out = listInRange.setListInRange();
        //then
        assertThat(out.get(0), is(FUND2));
        assertThat(out.get(2), is(FUND4));
    }
}