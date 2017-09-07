import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FundBase {


    public void readFoundIntoList(){

        BufferedReader br = null;
        FileReader fr = null;
        ArrayList<Fund> myFundList = new ArrayList<Fund>();


        try {
            fr = new FileReader("AIG002.txt");
            br = new BufferedReader(fr);
            String sCurrentLine;
            sCurrentLine = br.readLine();


            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println("----");
                System.out.println(sCurrentLine);
                System.out.println("Name: " + sCurrentLine.split(",")[0] + " Date: " + sCurrentLine.split(",")[1]);
                Fund temporaryFund = new Fund();
                temporaryFund.setName(sCurrentLine.split(",")[0]);
                temporaryFund.setDate(sCurrentLine.split(",")[1]);//zmiana typów
                temporaryFund.setOpen(sCurrentLine.split(",")[2]);
                temporaryFund.getHigh(sCurrentLine.split(",")[3]);
                temporaryFund.setLow(sCurrentLine.split(",")[4]);
                temporaryFund.getClose(sCurrentLine.split(",")[5]);
                Double transformStringDouble = new Double(sCurrentLine.split(",")[6]);
                temporaryFund.setVolume(transformStringDouble);

                myFundList.add(temporaryFund);


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex){
                ex.printStackTrace();
            }
        }




        Fund myFund = new Fund();


    }


}
