import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LocalExtremum {

    public Fund findMinByDate(List<Fund> operatingList) {

        UserConsole userConsole = new UserConsole();
        ArrayList<Fund> listInRange = null;
        Extremum extremum = null;
        boolean done = false;

        while (!done) {
            userConsole.inputDataRange();
            listInRange = new ArrayList<>();
            extremum = new Extremum();
            for (Fund iter : operatingList) {
                if (userConsole.getStartingDate().isBefore(operatingList.get(0).getDate()) ||
                        userConsole.getEndingDate().isAfter(operatingList.get(operatingList.size() - 1).getDate()) ||
                        userConsole.getStartingDate().isAfter(operatingList.get(operatingList.size() - 1).getDate()) ||
                        userConsole.getEndingDate().isBefore(operatingList.get(0).getDate())) {
                    System.out.println("Brak danych dla podanego przedziału czasu. Spróbuj ponownie");
                    break;
                } else if ((iter.getDate().isAfter(userConsole.getStartingDate())) && (iter.getDate().isBefore(userConsole.getEndingDate())) ||
                        (iter.getDate().isEqual(userConsole.getStartingDate())) || (iter.getDate().isEqual(userConsole.getEndingDate()))) {
                    listInRange.add(iter);
                    done = true;
                }
            }
        }
        return extremum.findMin(listInRange);
    }

    public Fund findMaxByDate(List<Fund> operatingList) {
        UserConsole userConsole = new UserConsole();
        ArrayList<Fund> listInRange = new ArrayList<>();
        Extremum extremum = new Extremum();
        for (Fund iter : operatingList) {
            if ((iter.getDate().isAfter(userConsole.getStartingDate())) && (iter.getDate().isBefore(userConsole.getEndingDate())) ||
                    (iter.getDate().isEqual(userConsole.getStartingDate())) || (iter.getDate().isEqual(userConsole.getEndingDate()))) {
                listInRange.add(iter);
            }
        }
        return extremum.findMax(listInRange);
    }
}