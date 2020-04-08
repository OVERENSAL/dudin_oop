public class Main {
    public static void main(String[] args) {

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
