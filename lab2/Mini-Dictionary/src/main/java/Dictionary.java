import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    public final String MISSING_DICTIONARY = "The file containing the dictionary is not found.";
    public final String USAGE_METHOD = "Usage: Mini-Dictionary.jar <dictionary.txt>.";
    public final String LOADING_DICTIONARY = "The dictionary is loading...";
    public final String ENTER_MANUAL = "Enter a translation or an empty line to exit.";
    public final String SAVE_MSG = "All changes were saved. Good day!";
    public final String TROUBLE_CREATE = "Can not create file.";
    private final int NUMBER_OF_WORDS = 2;

    public Map<String, String> dictionaryLoad(String[] args) {
        Map <String, String> dictionary = new HashMap<>();
        if (args.length == 1) {
            File file = new File(args[0]);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    System.out.println(TROUBLE_CREATE);
                }
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            System.out.println(LOADING_DICTIONARY);
            String line;
            String[] parseString;
            while ((line = reader.readLine()) != null) {
                parseString = line.split("\\s");
                if (parseString.length == NUMBER_OF_WORDS) {
                    dictionary.put(parseString[0], parseString[1]);
                }
            }
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            System.out.println(MISSING_DICTIONARY);
            System.out.println(USAGE_METHOD);
        }
        return dictionary;
    }

    public void addWord(Map<String, String> dictionary, String word, BufferedReader reader) { //called only when key without value
        System.out.println("Unknown word '" + word + "'. " + ENTER_MANUAL);
        try {
            String translate = reader.readLine();
            if (translate.isEmpty()) {
                throw new NullPointerException();
            }
            dictionary.put(word, translate);
            System.out.println("Word '" + word + "' is saved as '" + translate + "'.");
        } catch (IOException | NullPointerException e) {
            System.out.println("Word '" + word + "' ignored.");
        }
    }

    public void saveWords(Map<String, String> dictionary, String[] args) {
        try(FileWriter writer = new FileWriter(args[0], false)) {
            for (String key: dictionary.keySet()) {
                String value = dictionary.get(key);
                writer.write(key.trim() + " " + value.trim() + "\n");
            }
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            System.out.println(MISSING_DICTIONARY);
        }
        System.out.println(SAVE_MSG);
    }
}
