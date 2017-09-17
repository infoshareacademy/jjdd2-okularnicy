import java.util.List;
import java.util.Collections;

public class Extremum {

    private Fund max;
    private Fund min;

    public Fund getMax() {
        return max;
    }

    public void setMax(Fund max) {
        this.max = max;
    }

    public Fund getMin() {
        return min;
    }

    public void setMin(Fund min) {
        this.min = min;
    }

    public Fund findMin(List<Fund> listToSortAsc) {
        Collections.sort(listToSortAsc, new MyAscComparator());
        setMin(listToSortAsc.get(0));
        return min;
    }

    public Fund findMax(List<Fund> listToSortDesc) {
        Collections.sort(listToSortDesc, new MyDescComparator());
        setMax(listToSortDesc.get(0));
        return max;
    }
}