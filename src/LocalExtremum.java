import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LocalExtremum {

    public Fund findMinByDate(List<Fund> operatingList, LocalDate startingDate, LocalDate endingDate) {

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