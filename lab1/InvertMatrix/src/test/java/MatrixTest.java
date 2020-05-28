import org.junit.Test;
import java.io.*;
import static org.junit.Assert.*;

public class MatrixTest {
    private Matrix matrix = new Matrix();

    @Test
    public void getDeterminant3() {
        double[][] array = {{2, 3, 7},
                {1, -5, 2},
                {3, -1, 9}};
        assertEquals(3, matrix.getDeterminant(array), 1);
    }

    @Test
    public void getDeterminant0() {
        double[][] array = {{0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};
        assertEquals(0, matrix.getDeterminant(array), 1);
    }

    @Test
    public void getDeterminant5() {
        double[][] array = {{1, -1},
                {2, 3}};
        assertEquals(5, (int)matrix.getDeterminant(array), 1);
    }

    @Test
    public void getSubMatrix1() {
        double[][] array = {{0, 1, -1},
                {0, 0, 0},
                {0, 2, 3}};
        double[][] expected = {{1, -1},
                {2, 3}};
        assertArrayEquals(expected, matrix.getSubMatrix(array, 1, 0));
    }

    @Test
    public void getSubMatrix2() {
        double[][] array = {{0, 1, -1},
                {0, 0, 0},
                {0, 2, 3}};
        double[][] expected = {{0, 0},
                {2, 3}};
        assertArrayEquals(expected, matrix.getSubMatrix(array, 0, 0));
    }

    @Test
    public void getSubMatrix3() {
        double[][] array = {{0, 1, -1},
                {0, 0, 0},
                {0, 2, 3}};
        double[][] expected = {{0, -1},
                {0, 3}};
        assertArrayEquals(expected, matrix.getSubMatrix(array, 1, 1));
    }

    @Test
    public void getSubMatrix4() {
        double[][] array = {{0, 1, -1},
                {0, 0, 0},
                {0, 2, 3}};
        double[][] expected = {{0, -1},
                {0, 0}};
        assertArrayEquals(expected, matrix.getSubMatrix(array, 2, 1));
    }

    @Test
    public void getSubMatrix5() {
        double[][] array = {{0, 1, -1},
                {0, 0, 0},
                {0, 2, 3}};
        double[][] expected = {{0, 1},
                {0, 0}};
        assertArrayEquals(expected, matrix.getSubMatrix(array, 2, 2));
    }

    @Test
    public void transposeMatrix() {
        double[][] array = {{0, 1, -1},
                {0, 0, 0},
                {0, 2, 3}};
        double[][] expected = {{0, 0, 0},
                {1, 0, 2},
                {-1, 0, 3}};
        assertArrayEquals(expected, matrix.transposeMatrix(array));
    }

    @Test
    public void transposeEMatrix() {
        double[][] array = {{1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}};
        double[][] expected = {{1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}};
        assertArrayEquals(expected, matrix.transposeMatrix(array));
    }

    @Test
    public void getMatrixFromSubMatrix() {
        double[][] array = {{2, 3, 7},
                {1, -5, 2},
                {3, -1, 9}};
        double[][] expected = {{-43, -3, 14},
                {-34,-3, 11},
                {41, 3, -13}};
        assertArrayEquals(expected, matrix.getMatrixFromSubMatrix(array));
    }

    @Test
    public void getInvertMatrix() {
        double[][] array = {
                {2, 3, 7},
                {1, -5, 2},
                {3, -1, 9}
        };
        double[][] expected = {
                {-14.333, -11.333, 13.667},
                {-1, -1, 1},
                {4.667, 3.667, -4.333},
        };
        assertArrayEquals(expected, matrix.getInvertMatrix(array));
    }

    @Test
    public void showMatrix() {
        double[][] array = {
                {2, 3, 7},
                {1, -5, 2},
                {3, -1, 9}};
        double[][] expected = {
                {2, 3, 7},
                {1, -5, 2},
                {3, -1, 9}};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(stream);
        PrintStream originalOutputStream = System.out;
        System.setOut(out);
        matrix.showMatrix(array);
        System.setOut(originalOutputStream);
        assertEquals(Matrix.toString(expected)/*использую для тестировки метод, который нужно тестировать//умно*/, stream.toString());
    }
}