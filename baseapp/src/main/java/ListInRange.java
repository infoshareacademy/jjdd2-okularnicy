import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ListInRange {

    private Program program;
    private LocalDate startDate = program.getStartDate();
    private LocalDate endDate = program.getEndDate();
    private Fund firstFund = program.getFundsList().get(0);
    private Fund lastFund = program.getFundsList().get(program.getFundsList().size()-1);

    public ListInRange(Program program) {
        this.program = program;
    }

    public void isDateIsInRange() {
        if (startDate.isBefore(firstFund.getDate()) || endDate.isAfter(lastFund.getDate())) {
            System.out.println("Warning! Podany zakres wykracza poza dostępne dane.");
        } else if (startDate.isBefore(firstFund.getDate()) && endDate.isBefore(firstFund.getDate()) ||
                startDate.isAfter(lastFund.getDate()) && endDate.isBefore(lastFund.getDate())) {
            System.out.println("Brak danych dla podanego przedziału czasu. Spróbuj ponownie");
        } else {
            System.out.println("Wczytano poprawnie dane z podanego zakresu");
        }
    }

    public List<Fund> setListInRange () {

        List<Fund> listInRange = program.getFundsList().stream()
                .filter(o -> o.getDate().isAfter(startDate) || o.getDate().isEqual(startDate))
                .filter(o -> o.getDate().isBefore(endDate) || o.getDate().isEqual(endDate))
                .collect(Collectors.toList());
        return listInRange;
    }
}