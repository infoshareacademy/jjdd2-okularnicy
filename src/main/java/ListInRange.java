import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListInRange {

    private final Program program;

    public ListInRange(Program program) {
        this.program = program;
    }

        public List<Fund> setListInRange () {

        List<Fund> listInRange = program.getFundsList().stream()
                .filter(o -> o.getDate().isAfter(program.getStartDate()) || o.getDate().isEqual(program.getStartDate()))
                .filter(o -> o.getDate().isBefore(program.getEndDate()) || o.getDate().isEqual(program.getEndDate()))
                .collect(Collectors.toList());

        return listInRange;
    }


}
