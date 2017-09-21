import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> filesHashMap = new HashMap<String, String>();//HashMap to store: Key(name of fund) Value(name of file)

        StartingParameters startingParameters = new StartingParameters();//class to handle program arguments,
        //reads specified files, gets names of funds and files, stores it in map

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
