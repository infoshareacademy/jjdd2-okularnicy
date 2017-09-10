import java.io.IOException;
import java.util.Scanner;

public class InputOutput {
    int userChoice;
    Scanner input;
    boolean exitCondition;

    public InputOutput() {

        input = new Scanner(System.in);
        exitCondition = true;
    }

    public void menu() {
        Menu menu;
        printOptions();
        while ((menu = Menu.createFromInt(userChoice = input.nextInt())) != Menu.EXIT) {
            switch (menu) {
                case EXIT:

                case FIND_GLOBAL_EXTREMES:
                    try {
                        Runtime.getRuntime().exec("clear");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //tu wstawimy poprzez metody get wartości max i min
                    System.out.println("Oto najlepszy:  i  najsłabszy fundusz: ");
                    break;
                case FND_LOCALE_EXTREMES:
                    ;
                    break;
                case FIND_EXCHANGE_RATE:
                    ;
                    break;
                case OPTIMIZE_DATA_FOR_IMPORT:
                    ;
                    break;
                default:
                    System.out.println("Wybrałeś błędny numer, wybierz ponownie.");
                    System.out.println();
                    break;
            }
        }
    }

    private void printOptions() {
        System.out.println("Wybierz jedną z opcji: ");
        for(Menu m: Menu.values()) {
            System.out.println(m);
        }
    }
}