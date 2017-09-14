import java.util.ArrayList;

public class TestFundBase {

    public static void main(String[] args) {

        ArrayList<Fund> myFundList = new ArrayList<Fund>();//create ArrayList<Fund> list to contain the content of the file

        FundBase test = new FundBase();//create FundBase object

        myFundList.addAll(test.readFoundIntoList("testdata/AIG002_short.txt"));

        System.out.println();
        System.out.println("lista zawiera: " + myFundList.size() + " elementow");//printing the amount of rows that is inside the list

        //printing the content from the list
        System.out.println();
        System.out.println("wypisanie wszystkich elementow z wczytanej listy");
        for(Fund fundPrint: myFundList){
            System.out.print("getName:" + fundPrint.getName() + " ");
            System.out.print("getDate:" + fundPrint.getDate() + " ");
            //System.out.print("getOpen:" + fundPrint.getOpen() + " ");
            //System.out.print("getHigh:" + fundPrint.getHigh() + " ");
            //System.out.print("getLow:" + fundPrint.getLow() + " ");
            System.out.print("getClose:" + fundPrint.getClose() + " ");
            //System.out.print("getVolume:" + fundPrint.getVolume() + " ");
            System.out.println();//'new line' is in separated command because amount of data obtained from the file probably will change
        }
    }
}
