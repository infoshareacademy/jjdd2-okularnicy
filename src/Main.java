import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello");


        //pair programing Milena Daniel poczatek JD2O-10
        //System.out.println("wypisywanie argumentow z jakimi jest uruchomiona aplikacja");
        //for (String s : args) {
        //    System.out.println(s);
        //}
        //System.out.println();
        //System.out.println("pierwszy argument to:");
        //System.out.println(args[0]);
        //System.out.println();

        WczytajPlik wczytywaniePliku = new WczytajPlik();
        wczytywaniePliku.setSciezka(args[0]);
        //System.out.println("sciezka to: " + wczytywaniePliku.sciezka);
        //pair programing Milena Daniel koniec JD2O-10
    }
}
