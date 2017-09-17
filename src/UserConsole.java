import java.util.Scanner;
import java.time.DateTimeException;
import java.time.LocalDate;

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

    public void menu(Program program) {
        Menu menu = null;
        while (menu != Menu.EXIT) {
            try {
                printOptions();
                menu = Menu.createFromInt(Integer.parseInt(input.nextLine()));
                switch (menu) {

                    case SERACH_IN_BASE:
                        clearScreen();
                        System.out.println("Wyszukaj plik z danymi");
                        SerachFundFile serachFundFile = new SerachFundFile();
                        program.setPathToFile(serachFundFile.searchEngine(program.getFundsMap()));
                    case FIND_GLOBAL_EXTREMES:
                        clearScreen();
                        Extremum extremum = new Extremum();
                        extremum.findMin(program.fundsList);
                        extremum.findMax(program.fundsList);
                        break;
                    case FIND_LOCALE_EXTREMES:
                        clearScreen();
                        inputDataRange();
                        LocalExtremum localExtremum = new LocalExtremum();
                        localExtremum.findMinByDate(program.fundsList,startDate, endDate);
                        System.out.println("Oto najlepszy: i najsłabszy fundusz: ");
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