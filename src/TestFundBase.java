import java.util.ArrayList;

public class TestFundBase {

    public static void main(String[] args) {

        ArrayList<Fund> myFundList = new ArrayList<Fund>();//create ArrayList<Fund> list to contain the content of the file

        FundBase test = new FundBase();//create FundBase object

        if(test.readFoundIntoList("AIG002.txt",myFundList)==true){
            System.out.println("reading the file into the ArrayList<Fund> completed correctly");
        } else {
            System.out.println("an error occurred during reading the file");
        }
        ///call the readFoundIntoList(arg1, arg2) method
        // arg1 is a path to the file that you want to read from
        // arg2 is a ArrayList<Fund> list that the content of the file will be write into
        //readFoundIntoList(arg1, arg2) returns true if reading passed correctly





    }

}
