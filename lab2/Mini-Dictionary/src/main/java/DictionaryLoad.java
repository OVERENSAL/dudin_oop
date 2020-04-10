import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DictionaryLoad {
    public final String MISSING_DICTIONARY = "The file containing the dictionary is missing.";
    public final String USAGE_METHOD = "Usage: MiniDictionary.exe <dictionary.txt>.";

    public Map<String, String> dictionaryLoad(String[] args) {
        Map <String, String> dictionary = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            String line;
            String[] parseString;
            while ((line = reader.readLine()) != null) {
                parseString = line.split("\\s");
                if (parseString.length == 2) {
                    dictionary.put(parseString[0], parseString[1]);
                }
            }
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            System.out.println(MISSING_DICTIONARY);
            System.out.println(USAGE_METHOD);
        }
        return dictionary;
    }
}
