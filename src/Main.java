public class Main {
    public static void main(String[] args) {
        final String appName = "WITAJ W PROGRAMIE ANALIZATOR FINANSOWY";
        System.out.println(appName);
        System.out.println();
        UserConsole start = new UserConsole();
        start.menu();
    }
}
