import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.*;

public class ProcessedVectorTest {
    ProcessedVector processedVector = new ProcessedVector();

    @Test
    public void getProcessedVector() {
        Vector<Double> vector = new Vector<>();
        vector.add(1.0);
        vector.add(1.12);
        vector.add(2.2323);
        vector.add(3.231);
        vector.add(4.231);
        vector.add(2.233);
        Vector<Double> resultVector = processedVector.getProcessedVector(vector);
        Vector<Double> expected = new Vector<>();
        expected.add(0.473);
        expected.add(0.529);
        expected.add(1.055);
        expected.add(1.527);
        expected.add(2.0);
        expected.add(1.056);
        assertEquals(expected, resultVector);
    }
}