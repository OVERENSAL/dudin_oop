import java.util.Collections;
import java.util.Vector;

public class ProcessedVector {
    public Vector<Double> getProcessedVector(Vector<Double> vector) {
        double maxElement = Collections.max(vector);
        for (int i = 0; i < vector.size(); i++) {
            try {
                double number = vector.get(i) / (maxElement / 2);
                double roundedNumber = Math.round(number * 1000) / 1000.0;
                vector.set(i, roundedNumber);
            } catch (NullPointerException e) {
                System.out.println(e.getLocalizedMessage());
            }
        }

        return vector;
    }
}
