import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class InvertMatrixTest {
    String PATH = "D:/OOP/dudin_oop/InvertMatrix/src/test/resources/";
    Matrix matrix = new Matrix();

    @Test
    public void main() {
    }

    @Test
    public void readMatrix() {
        String[] args = {PATH + "input.txt"};
        double[][] matrix = InvertMatrix.readMatrix(args);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(stream);
        PrintStream originalOutputStream = System.out;
        System.setOut(out);
        this.matrix.showMatrix(matrix);
        System.setOut(originalOutputStream);
        assertEquals(Matrix.toString(matrix), stream.toString());
    }

    @Test
    public void readNullMatrix() {
        String[] args = {PATH + "input.txt"};
        double[][] matrix = InvertMatrix.readMatrix(args);
        assertNull(null, matrix);
    }
}