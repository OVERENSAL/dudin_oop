import java.io.*;

public class FindAndReplace {
    public static final String INPUT_ERROR = "Enter a string.";
    public static final String USAGE_METHOD = "Using: FindAndReplace.exe <searching string> <replacement string>";

    public static void main(String[] args) {
        String line = readLine();
        ParseArguments parse = new ParseArguments();
        String searchingString = parse.getSearchingString(args);
        String replacementString = parse.getReplacementString(args);

        if (line != null && searchingString != null && replacementString != null) {
            System.out.println(findAndReplace(line, searchingString, replacementString));
        }
    }
    public static String readLine() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            if ((line = reader.readLine()) != null) {
                return line;
            }
            throw new IOException();
        } catch (IOException e) {
            System.out.println(USAGE_METHOD);
            System.out.println(INPUT_ERROR);
            return null;
        }
    }

    public static String findAndReplace(String subject, String search, String replace) {
        StringBuilder builder = new StringBuilder(subject);
        while (subject.contains(search)) {
            int coincidenceIndex = subject.indexOf(search);
            builder.replace(coincidenceIndex, coincidenceIndex + search.length(), replace);
            subject = subject.substring(coincidenceIndex + search.length());
        }

        return builder.toString();
    }
}
