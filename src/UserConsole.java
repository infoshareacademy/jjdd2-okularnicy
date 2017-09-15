import java.util.Scanner;

public class UserConsole {

    private Scanner input;

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
                        //tu wstawimy poprzez metody get wartości max i min

                        break;
                    case FIND_LOCALE_EXTREMES:
                        clearScreen();

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

}