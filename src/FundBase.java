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

    //read only: nazwa, data, close


    public boolean readFoundIntoList(String pathToFile, ArrayList<Fund> myFundList) {//to call the readFoundIntoList method you should give the path do the file

        FileReader fr = null;//FileReader to read from the file
        BufferedReader br = null;//BufferedReader to buffer the values
        //ArrayList<Fund> myFundList = new ArrayList<Fund>();


        try {
            fr = new FileReader(pathToFile);//set the path to the FileReader
            br = new BufferedReader(fr);//set the FileReader to BufferedReader
            String sCurrentLine;//String variable that you use to take 1 line from the file
            sCurrentLine = br.readLine();//writing first line to the variable

            //checking if file structure is the same as the program expects
            if(!sCurrentLine.equals("Name,Date,Open,High,Low,Close,Volume")){
                System.out.println("different");
            } else {
                System.out.println("identical");
            }


            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");//DateTimeFormatter that will be used
            // inside the while loop

            while ((sCurrentLine = br.readLine()) != null) {//repeating the readind from file while BufferedReader contains any value
                // (if there is any value then sCurrentLine = br.readLine() method will return value that is different than null



                Fund temporaryFund = new Fund();//creating Fund object that is used to contain 1 line from the file,
                // then it will be added to the List

                temporaryFund.setName(sCurrentLine.split(",")[0]);//[0] entry is the Name value

                temporaryFund.setDate(LocalDate.parse(sCurrentLine.split(",")[1], dateTimeFormatter));//[1] entry is the Date value
                /*
                sCurrentLine.split(",")[x] returns String but Fund.setDate() expects LocalDate
                to change String to LocalDate you can use LocalDate.parse(String, formatter) method
                DateTimeFormatter is created befor entering the while loop
                below is 3 lines version of the above command
                String stringDate = sCurrentLine.split(",")[1];
                LocalDate dateDate = LocalDate.parse(stringDate, dateTimeFormatter);
                temporaryFund.setDate(dateDate);*/

                temporaryFund.setOpen(Double.parseDouble(sCurrentLine.split(",")[2]));//[2] entry is the Open value
                temporaryFund.setHigh(Double.parseDouble(sCurrentLine.split(",")[3]));//[3] entry is the High value
                temporaryFund.setLow(Double.parseDouble(sCurrentLine.split(",")[4]));//[4] entry is the Low value
                temporaryFund.setClose(Double.parseDouble(sCurrentLine.split(",")[5]));//[5] entry is the Close value
                temporaryFund.setVolume(Double.parseDouble(sCurrentLine.split(",")[6]));//[6] entry is the Volume value
                /*
                sCurrentLine.split(",")[x] returns String but Fund.setXXX() expects Double
                to change String do Double you can use Double.parseDouble(String) method
                */

                myFundList.add(temporaryFund);//add the temporaryFund object to the myFundList List



            }
            return true;

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
        return false;//this method should end after checking the corrent structure or after exiting the while loop,
        // if program gets here then probably something is wrong
    }


}
