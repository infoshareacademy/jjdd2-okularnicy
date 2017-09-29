import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        final Logger logger = LogManager.getLogger("log4j-burst-filter");
        HashMap<String, String> filesHashMap = new HashMap<String, String>();//HashMap to store: Key(name of fund) Value(name of file)
        StartingParameters startingParameters = new StartingParameters();//class to handle program arguments,
        //reads specified files, gets names of funds and files, stores it in map
        logger.log(Level.INFO, "Program został wczytany z następującym parametrem: " + args[0]);


        filesHashMap.putAll(startingParameters.startingParametersIntoMap(args));//this method gets names of funds and files, stores it in map and return this map

        final String appName = "WITAJ W PROGRAMIE ANALIZATOR FINANSOWY";
        System.out.println(appName);
        System.out.println();
        Program program = new Program();
        program.setFundsMap(filesHashMap);
        UserConsole start = new UserConsole();
        start.menu(program);
    }
}
