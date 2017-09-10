import java.util.NoSuchElementException;

public enum Menu {
    EXIT(0, "Wyjście z programu"),
    FIND_GLOBAL_EXTREMES(1, "Wyszukaj ekstrema globalne"),
    FND_LOCALE_EXTREMES(2, "Wyszukaj ekstrema lokalne"),
    FIND_EXCHANGE_RATE(3, "Wczytaj kursy walut danych z plków"),
    OPTIMIZE_DATA_FOR_IMPORT(4, "Zoptymalizuj dane w celu eksportu");

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