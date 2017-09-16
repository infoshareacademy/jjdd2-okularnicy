import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Podaj przedział czasowy");

        do {
            System.out.println("Podaj pierwszą datę (yyyy-mm-dd)");
            try {
                setStartingDate(LocalDate.parse(scanner.nextLine()));
            } catch (DateTimeException pe) {
                System.out.println("Niepoprawny format daty. Spróbuj ponownie");
            } catch (IndexOutOfBoundsException ie) {
                if (startingDate.isBefore())
            }
        } while (getStartingDate() == null);

        do {
            System.out.println("Podaj drugą datę (yyyy-mm-dd)");
            try {
                setEndingDate(LocalDate.parse(scanner.nextLine()));
            } catch (DateTimeException pe) {
                System.out.println("Niepoprawny format daty. Spróbuj ponownie");
            }
        } while (getEndingDate() == null);
        scanner.close();

        ArrayList<Fund> listInRange = new ArrayList<>();
        Extremum extremum = new Extremum();
        for (Fund iter : operatingList) {
            if ((iter.getDate().isAfter(startingDate)) && (iter.getDate().isBefore(endingDate)) ||
                    (iter.getDate().isEqual(startingDate)) || (iter.getDate().isEqual(endingDate))) {
                listInRange.add(iter);
            }
        }
                          return extremum.findMin(listInRange);
    }

    public Fund findMaxByDate(List<Fund> operatingList, LocalDate startingDate, LocalDate endingDate) {
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