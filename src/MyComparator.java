import java.util.Comparator;

public class MyComparator implements Comparator<Fund>{

    private boolean desc;

    public MyComparator(boolean desc) {
        this.desc = desc;
    }

    @Override
    public int compare(Fund o1, Fund o2) {
        if (desc) {
            if (o1.getClose() < o2.getClose()) {
                return 1;
            } else if (o1.getClose() > o2.getClose()) {
                return -1;
            }
            return 0;
        } else {
            if (o1.getClose() > o2.getClose()) {
                return 1;
            } else if (o1.getClose() < o2.getClose()) {
                return -1;
            }
            return 0;

        }
    }


}
