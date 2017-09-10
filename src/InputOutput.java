import java.io.IOException;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class InputOutput {
    int userChoice;
    Scanner input;
    boolean exitCondition;

    public InputOutput() {

        input = new Scanner(System.in);
        exitCondition = true;
    }

    public void menu() {
        Menu menu = null;
        while (menu != Menu.EXIT) {
            try {
                printOptions();
                menu = Menu.createFromInt(userChoice = input.nextInt());
                switch (menu) {

                    case FIND_GLOBAL_EXTREMES:
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        //tu wstawimy poprzez metody get wartości max i min
                        System.out.println("Oto najlepszy:  i  najsłabszy fundusz: ");
                        break;
                    case FND_LOCALE_EXTREMES:
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Oto najlepszy: i najsłabszy fundusz: ");
                        ;
                        break;
                    case FIND_EXCHANGE_RATE:
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Oto kursy walut o które prosiłeś: ");
                        break;
                    case OPTIMIZE_DATA_FOR_IMPORT:
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Dane zostały przygotowane do eksportu.");
                        break;

                }
            } catch (NoSuchElementException e) {
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
}