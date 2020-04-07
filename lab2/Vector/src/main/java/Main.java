import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Vector<Double> vector = new CompletionVector().getCompletionVector();
        if (!(vector == null)) {
            ProcessedVector processed = new ProcessedVector();
            vector = processed.getProcessedVector(vector);
            System.out.println(vector.toString());
        }
    }
}
