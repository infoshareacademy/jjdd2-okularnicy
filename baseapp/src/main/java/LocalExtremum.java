import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LocalExtremum {

    public Fund findMinByDate(List<Fund> operatingList, LocalDate startDate, LocalDate endDate) {
        ArrayList<Fund> listInRange = new ArrayList<>();
        Extremum extremum = null;
        boolean anything = false;
        if(startDate.isBefore(operatingList.get(0).getDate()) ||
                endDate.isAfter(operatingList.get(operatingList.size() - 1).getDate())){
            System.out.println("Warning! Podany zakres wykracza poza dostępne dane.");
        }
        for (Fund iter : operatingList) {
            if ((iter.getDate().isAfter(startDate)) && (iter.getDate().isBefore(endDate)) ||
                    (iter.getDate().isEqual(startDate)) || (iter.getDate().isEqual(endDate))) {
                listInRange.add(iter);
                anything = true;
            }
        }
        if(anything){
            extremum = new Extremum();
            return extremum.findMin(listInRange);
        } else {
            System.out.println("Brak danych dla podanego przedziału czasu. Spróbuj ponownie");
            Fund failureFund = new Fund();
            failureFund.setName("blad");
            failureFund.setDate(LocalDate.of(9999,12,31));
            failureFund.setClose(0.0);
            return failureFund;
        }



    }

    public Fund findMaxByDate(List<Fund> operatingList, LocalDate startDate, LocalDate endDate) {
        ArrayList<Fund> listInRange = new ArrayList<>();
        Extremum extremum = null;
        boolean anything = false;
        for (Fund iter : operatingList) {
            if ((iter.getDate().isAfter(startDate)) && (iter.getDate().isBefore(endDate)) ||
                    (iter.getDate().isEqual(startDate)) || (iter.getDate().isEqual(endDate))) {
                listInRange.add(iter);
                anything = true;
            }
        }
        if(anything){
            extremum = new Extremum();
            return extremum.findMax(listInRange);
        } else {
            System.out.println("Brak danych dla podanego przedziału czasu. Spróbuj ponownie");
            Fund failureFund = new Fund();
            failureFund.setName("blad");
            failureFund.setDate(LocalDate.of(9999,12,31));
            failureFund.setClose(0.0);
            return failureFund;
        }

    }
}