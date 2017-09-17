import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LocalExtremum {

    Scanner scanner = new Scanner(System.in);
    private LocalDate startingDate;
    private LocalDate endingDate;

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public Fund findMinByDate(List<Fund> operatingList) {

        ArrayList<Fund> listInRange = null;
        Extremum extremum = null;
        boolean done = false;

        while (!done) {
            setStartingDate(null);
            setEndingDate(null);
            System.out.println("Podaj przedział czasowy");

            do {
                System.out.println("Podaj pierwszą datę (yyyy-mm-dd)");
                try {
                    setStartingDate(LocalDate.parse(scanner.nextLine()));
                } catch (DateTimeException de) {
                    System.out.println("Niepoprawny format daty. Spróbuj ponownie");
                }
            } while (getStartingDate() == null);

            do {
                System.out.println("Podaj drugą datę (yyyy-mm-dd)");
                try {
                    setEndingDate(LocalDate.parse(scanner.nextLine()));
                } catch (DateTimeException de) {
                    System.out.println("Niepoprawny format daty. Spróbuj ponownie");
                }
            } while (getEndingDate() == null);

            listInRange = new ArrayList<>();
            extremum = new Extremum();
            for (Fund iter : operatingList) {
                if (startingDate.isBefore(operatingList.get(0).getDate()) ||
                        endingDate.isAfter(operatingList.get(operatingList.size() - 1).getDate()) ||
                        startingDate.isAfter(operatingList.get(operatingList.size() - 1).getDate()) ||
                        endingDate.isBefore(operatingList.get(0).getDate())) {
                    System.out.println("Brak danych dla podanego przedziału czasu. Spróbuj ponownie");
                    break;
                } else {
                    listInRange.add(iter);
                    done = true;
                    break;
                }
            }
        }
        scanner.close();
        return extremum.findMin(listInRange);
    }

    public Fund findMaxByDate(List<Fund> operatingList) {
        ArrayList<Fund> listInRange = new ArrayList<>();
        Extremum extremum = new Extremum();
        for (Fund iter : operatingList) {
            if ((iter.getDate().isAfter(startingDate)) && (iter.getDate().isBefore(endingDate)) ||
                    (iter.getDate().isEqual(startingDate)) || (iter.getDate().isEqual(endingDate))) {
                listInRange.add(iter);
            }
        }
        return extremum.findMax(listInRange);
    }
}