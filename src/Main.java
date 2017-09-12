import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> filesHashMap = new HashMap<String, String>();//HashMap to store: Key(name of fund) Value(name of file)

        StartingParameters startingParameters = new StartingParameters();//class to handle program arguments,
        //reads specified files, gets names of funds and files, stores it in map

        startingParameters.startingParametersIntoMap(args, filesHashMap);//this method gets names of funds and files and stores it in map
        startingParameters.printMap(filesHashMap);//this is only assistance method to print the content of entire map to check its correctness
    }
}
