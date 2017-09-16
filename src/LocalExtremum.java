import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LocalExtremum {

    Scanner scanner = new Scanner (System.in);

    public Fund findMinByDate(List<Fund> operatingList) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Podaj pierwszą datę (yyyy-mm-dd)");
        String textStartingDate = scanner.nextLine();
        LocalDate startingDate = LocalDate.parse(textStartingDate, dateTimeFormatter);
        System.out.println("Podaj drugą datę (yyyy-mm-dd)");
        String textEndingDate = scanner.nextLine();
        LocalDate endingDate = LocalDate.parse(textEndingDate, dateTimeFormatter);

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
                    (iter.getDate().isEqual(startingDate)) || (iter.getDate().isEqual(endingDate))){
                listInRange.add(iter);
            }
        }
        return extremum.findMax(listInRange);
    }
}