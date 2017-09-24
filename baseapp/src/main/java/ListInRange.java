import java.util.List;
import java.util.stream.Collectors;

public class ListInRange {

    private final Program program;

    public ListInRange(Program program) {
        this.program = program;
    }

    public void isDateIsInRange() {
        if (program.getStartDate().isBefore(program.getFundsList().get(0).getDate()) ||
                program.getEndDate().isAfter(program.getFundsList().get(program.getFundsList().size() - 1).getDate())) {
            System.out.println("Warning! Podany zakres wykracza poza dostępne dane.");
        } else if (program.getStartDate().isBefore(program.getFundsList().get(0).getDate()) &&
                program.getEndDate().isBefore(program.getFundsList().get(0).getDate()) ||
                program.getStartDate().isAfter(program.getFundsList().get(program.getFundsList().size() - 1).getDate()) &&
                        program.getEndDate().isBefore(program.getFundsList().get(program.getFundsList().size() - 1).getDate())) {
            System.out.println("Brak danych dla podanego przedziału czasu. Spróbuj ponownie");
        } else {
            System.out.println("Wczytano poprawnie dane z podanego zakresu");
        }
    }

    public List<Fund> setListInRange () {

        List<Fund> listInRange = program.getFundsList().stream()
                .filter(o -> o.getDate().isAfter(program.getStartDate()) || o.getDate().isEqual(program.getStartDate()))
                .filter(o -> o.getDate().isBefore(program.getEndDate()) || o.getDate().isEqual(program.getEndDate()))
                .collect(Collectors.toList());
        return listInRange;
    }
}