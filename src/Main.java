import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //System.out.println("hello");


        //pair programing Milena Daniel poczatek JD2O-10
        //System.out.println("wypisywanie argumentow z jakimi jest uruchomiona aplikacja");

        for (String pathToFile : args) {
            //System.out.println(s);
            FileReader fr = null;//FileReader to read from the file
            BufferedReader br = null;//BufferedReader to buffer the values

            try {
                fr = new FileReader(pathToFile);//set the path to the FileReader
                br = new BufferedReader(fr);//set the FileReader to BufferedReader
                String sCurrentLine;//String variable that you use to take 1 line from the file
                sCurrentLine = br.readLine();
                sCurrentLine = br.readLine();
                System.out.println(sCurrentLine);
            } catch(FileNotFoundException ex) {
                ex.printStackTrace();
            } catch(IOException ex2){
                ex2.printStackTrace();
            }



        }










        //System.out.println();
        //System.out.println("pierwszy argument to:");
        //System.out.println(args[0]);
        //System.out.println();

        //WczytajPlik wczytywaniePliku = new WczytajPlik();
        //wczytywaniePliku.setSciezka(args[0]);
        //System.out.println("sciezka to: " + wczytywaniePliku.sciezka);
        //pair programing Milena Daniel koniec JD2O-10
    }
}
