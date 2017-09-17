import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LocalExtremum {

    public Fund findMinByDate(List<Fund> operatingList, LocalDate startDate, LocalDate endDate) {
        ArrayList<Fund> listInRange = null;
        Extremum extremum = null;
        if (endDate.isBefore(operatingList.get(0).getDate()) ||
                startDate.isAfter(operatingList.get(operatingList.size() - 1).getDate())) {
            System.out.println("Brak danych dla podanego przedziału czasu. Spróbuj ponownie");
            Fund failureFund = new Fund();
            failureFund.setName("blad");
            failureFund.setDate(LocalDate.of(9999,12,31));
            failureFund.setClose(0.0);
            return failureFund;
        } else {
            listInRange = new ArrayList<>();
            for (Fund iter : operatingList) {
                if ((iter.getDate().isAfter(startDate)) && (iter.getDate().isBefore(endDate)) ||
                        (iter.getDate().isEqual(startDate)) || (iter.getDate().isEqual(endDate))) {
                    listInRange.add(iter);
                }
            }
        }
        extremum = new Extremum();
        return extremum.findMin(listInRange);
    }

    public Fund findMaxByDate(List<Fund> operatingList, LocalDate startDate, LocalDate endDate) {
        ArrayList<Fund> listInRange = null;
        Extremum extremum = null;
        if(endDate.isBefore(operatingList.get(0).getDate()) ||
                startDate.isAfter(operatingList.get(operatingList.size() - 1).getDate())) {
            System.out.println("Brak danych dla podanego przedziału czasu. Spróbuj ponownie");
            Fund failureFund = new Fund();
            failureFund.setName("blad");
            failureFund.setDate(LocalDate.of(9999,12,31));
            failureFund.setClose(0.0);
            return failureFund;
        } else {
            listInRange = new ArrayList<>();
            for (Fund iter : operatingList) {
                if ((iter.getDate().isAfter(startDate)) && (iter.getDate().isBefore(endDate)) ||
                        (iter.getDate().isEqual(startDate)) || (iter.getDate().isEqual(endDate))) {
                    listInRange.add(iter);
                }
            }
        }
        extremum = new Extremum();
        return extremum.findMax(listInRange);
    }
}