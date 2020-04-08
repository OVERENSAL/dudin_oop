import java.io.*;
import java.util.Vector;

public class CompletionVector {
    public final String STRING_IS_NOT_NUMBER = "The entered string is not a number. Check your input and try again.";
    public final String USAGE_METHOD = "Enter a sequence of numbers.";

    public Vector<Double> getCompletionVector() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Vector<Double> vector = new Vector<>();
            String line;
            if ((line = reader.readLine()) != null) {
                for (String part: line.split("\\s")) {
                    try {
                        vector.add(Double.parseDouble(part));
                    } catch (NumberFormatException n) {
                        System.out.println(STRING_IS_NOT_NUMBER);
                        throw new IOException();
                    }
                }
            }
            if (vector.isEmpty()) {
                throw new IOException();
            }
            return vector;
        } catch (IOException e) {
            System.out.println(USAGE_METHOD);
            return null;
        }
    }
}
