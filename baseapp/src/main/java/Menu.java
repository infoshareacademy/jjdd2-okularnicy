import java.util.NoSuchElementException;

public enum Menu {
    EXIT(0, "Wyjście z programu"),
    SERACH_IN_BASE(1, "Wyszukaj plik z danymi"),
    FIND_GLOBAL_EXTREMES(2, "Wyszukaj ekstrema globalne"),
    FIND_LOCALE_EXTREMES(3, "Wyszukaj ekstrema lokalne");

    private int value;
    private String discription;

    Menu(int value, String discription) {
        this.value = value;
        this.discription = discription;
    }

    public int getValue() {
        return value;
    }

    public String getDiscription() {
        return discription;
    }

    @Override
    public String toString() {
        return getValue() + " - " + getDiscription();
    }

    public static Menu createFromInt(int option) throws NoSuchElementException {
        Menu result = null;
        try {
            result = Menu.values()[option];
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new NoSuchElementException();

        }
        return result;
    }
}