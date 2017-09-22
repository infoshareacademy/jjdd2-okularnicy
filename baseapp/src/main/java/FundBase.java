import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class FundBase {

    /**
     * Reads from specified file and adds it to the List
     * @param pathToFile    path to file which contain the historical data about fund
     * @return              List<Fund> where every Fund item is another line from file
     */
    public ArrayList<Fund> readFoundIntoList(String pathToFile) {

        ArrayList<Fund> myFundList = new ArrayList<Fund>();

        FileReader fr = null;//FileReader to read from the file
        BufferedReader br = null;//BufferedReader to buffer the values

        try {
            fr = new FileReader(pathToFile);//set the path to the FileReader
            br = new BufferedReader(fr);//set the FileReader to BufferedReader
            String sCurrentLine;//String variable that you use to take 1 line from the file
            sCurrentLine = br.readLine();//reading first line which is not used because it contain the header

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");//DateTimeFormatter that will be used
            // inside the while loop

            while ((sCurrentLine = br.readLine()) != null) {//repeating the reading from file while BufferedReader contains any value
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

                temporaryFund.setClose(Double.parseDouble(sCurrentLine.split(",")[5]));//[5] entry is the Close value

                myFundList.add(temporaryFund);//add the temporaryFund object to the myFundList List
            }
            return myFundList;

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
        return myFundList;//you should write return statement in this method
        //this method should end after after exiting the while loop,
        // if program gets here then probably something went wrong
    }
}