import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class FundBase {


    public void readFoundIntoList() {

        BufferedReader br = null;
        FileReader fr = null;
        ArrayList<Fund> myFundList = new ArrayList<Fund>();


        try {
            fr = new FileReader("AIG002.txt");
            br = new BufferedReader(fr);
            String sCurrentLine;
            sCurrentLine = br.readLine();

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

            while ((sCurrentLine = br.readLine()) != null) {

                //read only: nazwa, data, close

                System.out.println("----");
                System.out.println(sCurrentLine);
                System.out.println("Name: " + sCurrentLine.split(",")[0] + " Date: " + sCurrentLine.split(",")[1]);
                Fund temporaryFund = new Fund();
                temporaryFund.setName(sCurrentLine.split(",")[0]);

                String stringDate = sCurrentLine.split(",")[1];
                LocalDate date = LocalDate.parse(stringDate, dateTimeFormatter);
                temporaryFund.setDate(date);

                //temporaryFund.setOpen(sCurrentLine.split(",")[2]);

                //double liczbaDouble = Integer.parseInt(sCurrentLine.split(",")[2]);
                //temporaryFund.setOpen(liczbaDouble);
                temporaryFund.setOpen(Double.parseDouble(sCurrentLine.split(",")[2]));


                //temporaryFund.getHigh(sCurrentLine.split(",")[3]);
                temporaryFund.setHigh(Double.parseDouble(sCurrentLine.split(",")[3]));

                //temporaryFund.setLow(sCurrentLine.split(",")[4]);
                temporaryFund.setLow(Double.parseDouble(sCurrentLine.split(",")[4]));
                temporaryFund.setClose(Double.parseDouble(sCurrentLine.split(",")[5]));

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
    }
}
