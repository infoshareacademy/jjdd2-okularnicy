import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class UserConsole {

    private Scanner input;
    private LocalDate startingDate;
    private LocalDate endingDate;

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public UserConsole() {
        input = new Scanner(System.in);
    }

    public void menu() {
        Menu menu = null;
        while (menu != Menu.EXIT) {
            try {
                printOptions();
                menu = Menu.createFromInt(Integer.parseInt(input.nextLine()));
                switch (menu) {

                    case SERACH_IN_BASE:
                        clearScreen();
                        System.out.println("Wyszukaj plik z danymi");
                    case FIND_GLOBAL_EXTREMES:
                        clearScreen();
                        //tu wstawimy poprzez metody get wartości max i min
                        System.out.println("Oto najlepszy:  i  najsłabszy fundusz: ");
                        break;
                    case FIND_LOCALE_EXTREMES:
                        clearScreen();
                        System.out.println("Oto najlepszy: i najsłabszy fundusz: ");
                        break;
                    case FIND_EXCHANGE_RATE:
                        clearScreen();
                        System.out.println("Oto kursy walut o które prosiłeś: ");
                        break;
                    case OPTIMIZE_DATA_FOR_IMPORT:
                        clearScreen();
                        System.out.println("Dane zostały przygotowane do eksportu.");
                        break;

                }
            } catch (NumberFormatException e) {
                System.out.println("O_O Wybrana opcja nie istnieje, wybierz ponownie !");
                System.out.println();
            }
        }
        input.close();
    }

    private void printOptions() {
        System.out.println("Wybierz jedną z opcji: ");
        System.out.println();
        for (Menu m : Menu.values()) {
            System.out.println(m);
        }
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void inputDataRange() {

        setStartingDate(null);
        setEndingDate(null);

        System.out.println("Podaj przedział czasowy");
        do {
            System.out.println("Podaj pierwszą datę (yyyy-mm-dd)");
            try {
                setStartingDate(LocalDate.parse(input.nextLine()));
            } catch (DateTimeException de) {
                System.out.println("Niepoprawny format daty. Spróbuj ponownie");
            }
        } while (getStartingDate() == null);

        do {
            System.out.println("Podaj drugą datę (yyyy-mm-dd)");
            try {
                setEndingDate(LocalDate.parse(input.nextLine()));
            } catch (DateTimeException de) {
                System.out.println("Niepoprawny format daty. Spróbuj ponownie");
            }
        } while (getEndingDate() == null);
    }
}

