import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StartingParameters {
    private final Logger logger = LogManager.getLogger("log4j-burst-filter");

    public void printMap(Map<String, String> map){
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for(Map.Entry<String, String> entry : entries){
            System.out.println("Key:[" + entry.getKey() + "] Value:[" + entry.getValue() + "]");
        }
    }

    public Map<String, String> startingParametersIntoMap(String[] args){

        Map<String, String> resultMap = new HashMap<String, String>();

        for (String pathToFile : args) {
            FileReader fr = null;//FileReader to read from the file
            BufferedReader br = null;//BufferedReader to buffer the values

            try {
                fr = new FileReader(pathToFile);//set the path to the FileReader
                br = new BufferedReader(fr);//set the FileReader to BufferedReader
                String sCurrentLine;//String variable that you use to take 1 line from the file
                sCurrentLine = br.readLine();//firts 3 lines are ignored
                sCurrentLine = br.readLine();
                sCurrentLine = br.readLine();

                while ((sCurrentLine = br.readLine()) != null){
                    String separatorName1 = "(.txt)( )+";
                    String name=sCurrentLine.split(separatorName1)[1].trim();

                    String separatorFile1 = "(kB)( )+";
                    String separatorFile2 = " ";
                    String file = sCurrentLine.split(separatorFile1)[1].split(separatorFile2)[0];

                    resultMap.put(name,file);
                }

            } catch(FileNotFoundException ex) {
                ex.printStackTrace();
                logger.log(Level.ERROR, "Wyjątek: FileNotFoundException");
            } catch(IOException ex2){
                ex2.printStackTrace();
                logger.log(Level.ERROR, "Wyjątek: FileNotFoundException");
            }
        }
        return resultMap;
    }
}
