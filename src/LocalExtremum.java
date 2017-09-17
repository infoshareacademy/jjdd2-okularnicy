import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LocalExtremum {

    public Fund findMinByDate(List<Fund> operatingList, LocalDate startDate, LocalDate endDate) {

        ArrayList<Fund> listInRange = null;
        Extremum extremum = null;
        boolean done = false;

        while (!done) {
            listInRange = new ArrayList<>();
            extremum = new Extremum();
            for (Fund iter : operatingList) {
                if (startDate.isBefore(operatingList.get(0).getDate()) ||
                        endDate.isAfter(operatingList.get(operatingList.size() - 1).getDate()) ||
                        startDate.isAfter(operatingList.get(operatingList.size() - 1).getDate()) ||
                        endDate.isBefore(operatingList.get(0).getDate())) {
                    System.out.println("Brak danych dla podanego przedziału czasu. Spróbuj ponownie");
                    break;
                } else if ((iter.getDate().isAfter(startDate)) && (iter.getDate().isBefore(endDate)) ||
                        (iter.getDate().isEqual(startDate)) || (iter.getDate().isEqual(endDate))) {
                    listInRange.add(iter);
                    done = true;
                }
            }
        }
        return extremum.findMin(listInRange);
    }

    public Fund findMaxByDate(List<Fund> operatingList, LocalDate startDate, LocalDate endDate) {
        UserConsole userConsole = new UserConsole();
        ArrayList<Fund> listInRange = new ArrayList<>();
        Extremum extremum = new Extremum();
        for (Fund iter : operatingList) {
            if ((iter.getDate().isAfter(startDate)) && (iter.getDate().isBefore(endDate)) ||
                    (iter.getDate().isEqual(startDate)) || (iter.getDate().isEqual(endDate))) {
                listInRange.add(iter);
            }
        }
        return extremum.findMax(listInRange);
    }
}