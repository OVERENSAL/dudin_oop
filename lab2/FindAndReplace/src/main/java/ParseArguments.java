public class ParseArguments {
    public final String MISSING_SEARCHING_STRING = "Missing searching string";
    public final String MISSING_REPLACEMENT_STRING = "Missing replacement string";

    public String getSearchingString(String[] args) {
        if (args.length == 2) {
            return args[0];
        }
        System.out.println(MISSING_SEARCHING_STRING);
        return null;
    }

    public String getReplacementString(String[] args) {
        if (args.length == 2) {
            return args[1];
        }
        System.out.println(MISSING_REPLACEMENT_STRING);
        return null;
    }
}
