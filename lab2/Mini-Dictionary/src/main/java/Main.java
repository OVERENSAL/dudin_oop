import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionaryObject = new Dictionary();
        Map<String, String> dictionary = dictionaryObject.dictionaryLoad(args);
        LoopRequests loop = new LoopRequests();
        if (args.length == 1 && loop.loopRequest(dictionary)) {
            dictionaryObject.saveWords(dictionary, args);
        }
    }
}