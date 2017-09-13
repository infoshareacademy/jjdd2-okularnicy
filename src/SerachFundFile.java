import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SerachFundFile {

    private String fileName;
    Map<String, String> funds = new HashMap<>();
    ArrayList<String> hintsMap = new ArrayList<>();

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private void printHintsMap() {
        for (String s : hintsMap) {
            System.out.println(s);
        }
    }

    public String searchEngin() {

        funds.put("UNIKorona Pieniezny", "UI_001.txt");
        funds.put("UNIKorona Obligacje", "UI_002.txt");
        funds.put("UNIKorona Akcje", "UI_003.txt");
        funds.put("UNIWIBID Plus", "UI_008.txt");

        String userInput = "UNIKorona Akcje";

        //jeżeli trafia z nazwą idealnie wykonuje instrukcje z if
        if (null != funds.get(userInput)) {
            hintsMap.add(funds.get(userInput));
            setFileName(hintsMap.get(0));
            //jeżeli wyników jest więcej:
        } else {
            for (Map.Entry<String, String> entry : funds.entrySet()) {
                if (entry.getKey().startsWith(userInput)) {
                    hintsMap.add(entry.getKey());
                    System.out.println("Twoje zpytanie pasuje do: ");
                    printHintsMap();
                    System.out.println("Doprecyzuj zapytanie.");
                }
            }
        }
        return fileName;
    }
}
