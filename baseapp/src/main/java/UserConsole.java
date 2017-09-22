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
                        FundBase fundBase = new FundBase();
                        program.setFundsList(fundBase.readFoundIntoList(program.getPathToFile()));
                        break;
                    case FIND_GLOBAL_EXTREMES:
                        clearScreen();
                        Extremum extremum = new Extremum();
                        System.out.println("Wartość minimalna: " + extremum.findMin(program.getFundsList()));
                        System.out.println("Wartość maksymalna: " + extremum.findMax(program.getFundsList()));
                        break;
                    case FIND_LOCALE_EXTREMES:
                        clearScreen();
                        inputDataRange(program);
                        LocalExtremum localExtremum = new LocalExtremum();
                        System.out.println("Wartość minimalna: " + localExtremum.findMinByDate
                                (program.getFundsList(), program.getStartDate(), program.getEndDate()));
                        System.out.println("Wartość maksymalna: " + localExtremum.findMaxByDate
                                (program.getFundsList(), program.getStartDate(), program.getEndDate()));
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

    public void inputDataRange(Program program) {

        setStartingDate(null);
        setEndingDate(null);

        System.out.println("Podaj przedział czasowy");
        do {
            System.out.println("Podaj pierwszą datę (yyyy-mm-dd)");
            try {
                program.setStartDate(LocalDate.parse(input.nextLine()));
            } catch (DateTimeException de) {
                System.out.println("Niepoprawny format daty. Spróbuj ponownie");
            }
        } while (program.getStartDate() == null);

        do {
            System.out.println("Podaj drugą datę (yyyy-mm-dd)");
            try {
                program.setEndDate(LocalDate.parse(input.nextLine()));
            } catch (DateTimeException de) {
                System.out.println("Niepoprawny format daty. Spróbuj ponownie");
            }
        } while (program.getEndDate() == null);
    }
}