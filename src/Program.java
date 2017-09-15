import java.util.HashMap;
import java.util.Map;

public class Program {

    private Map<String, String> fundsMap;
    private String pathToFile;

    public Program() {

        fundsMap = new HashMap<>();
    }

    public Map<String, String> getFundsMap() {
        return fundsMap;
    }

    public void setFundsMap(Map<String, String> fundsMap) {
        this.fundsMap = fundsMap;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

}
