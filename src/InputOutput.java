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
        //Menu menu;
        printOptions();
        while ((Menu.createFromInt(userChoice = input.nextInt())) != Menu.EXIT) {
            switch (userChoice) {
                case 1:
                    try {
                        Runtime.getRuntime().exec("clear");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //tu wstawimy poprzez metody get wartości max i min
                    System.out.println("Oto najlepszy:  i  najsłabszy fundusz: ");
                    break;
                case 2:
                    System.out.println("cos tam ");
                    System.out.println();
                    ;
                    break;
                case 3:
                    ;
                    break;
                case 4:
                    ;
                    break;
                case 5:
                    exitCondition = false;
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