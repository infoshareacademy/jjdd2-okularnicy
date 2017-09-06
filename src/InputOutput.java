import java.util.Scanner;

public class InputOutput {
    int userChoice;
    Scanner input;
    boolean exitCondition = true;

    public InputOutput() {
        input = new Scanner(System.in);
    }

    public void menu() {
        while (exitCondition) {

            System.out.println("WITAJ W PROGRAMIE ANALIZATOR FINANSOWY");
            System.out.println();
            System.out.println("Wybierz jedną z opcji: ");
            System.out.println();
            //wczytywanie plików bedzie jako parametr programu (nazwa programu + sciezka jako parametr)
            System.out.println("1. Wczytaj dane funduszy z plików");
            System.out.println("1. Wyszukaj ekstrema globalne z wczytanych danych");
            System.out.println("2. Wyszukaj ekstrema lokalne z wczytanych danych");
            // tak jak numer 1 będzie jako parametr programu z konsoli
            System.out.println("3. Wczytaj kursy walut danych z plków");
            System.out.println("4. Zoptymalizuj dane w celu eksportu");
            System.out.println("5. Wyjdź z programu");
            userChoice = input.nextInt();

            switch (userChoice) {
                case 1:
                    ;
                    break;
                case 2:
                    ;
                    break;
                case 3:
                    ;
                    break;
                case 4:
                    ;
                    break;
                case 5:
                    ;
                    break;
                case 6:
                    exitCondition = false;
                    break;
                default:
                    System.out.println("Wybrałeś błędny numer, wybierz ponownie.");
                    System.out.println();
                    break;
            }


        }


    }
}