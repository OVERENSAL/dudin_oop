import java.io.*;
import java.util.HashSet;

public class PersonLoad {
    public final String MISSING_FILES = "Files are missing";
    public final String USAGE_METHOD = "Using: Main.exe <file.txt>";

    public HashSet<String> personLoad(String[] args) {
        if (args.length == 0) {
            System.out.println(MISSING_FILES);
            System.out.println(USAGE_METHOD);
        }
        HashSet<String> sportSchool = new HashSet<>();
        String line;
        for (String arg : args) {
            File file = new File(arg);
            if (file.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    while ((line = reader.readLine()) != null) {
                        sportSchool.add(line);
                    }
                } catch (IOException e) {
                    System.out.println("File '" + arg + "' is missing.");
                }
            } else {
                System.out.println("File '" + arg + "' is missing.");
            }
        }

        return sportSchool;
    }
}
