import java.io.*;
import java.util.Map;

public class LoopRequests {
    Dictionary dictionaryObject = new Dictionary();
    public final String MANUAL = "Enter the word you want to translate.";
    public final String EXIT_CONDITION = "...";
    public final String CONSERVATION = "Are you want to save all changes? To respond, enter Y or N.";

    public boolean loopRequest(Map<String, String> dictionary) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line, value;
            System.out.println(MANUAL);
            while (!(line = reader.readLine()).equals(EXIT_CONDITION)) {
                if (line.isEmpty()) {
                    continue;
                }
                line = line.split("\\s")[0];//if you enter multiply word
                value = dictionary.get(line);
                if (value == null) {
                    dictionaryObject.addWord(dictionary, line, reader);
                } else {
                    System.out.println(value);
                }
            }
            System.out.println(CONSERVATION);
            return reader.readLine().equals("Y");
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            System.out.println(MANUAL);
        }
        return false;
    }
}
