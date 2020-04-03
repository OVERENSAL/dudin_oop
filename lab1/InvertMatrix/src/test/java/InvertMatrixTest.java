import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class InvertMatrixTest {
    String PATH = "D:/OOP/dudin_oop/lab1/InvertMatrix/src/test/resources/";
    Matrix matrix = new Matrix();

    @Test
    public void main_GiveEmptyArguments_ShouldShowMistakeMessage() {
        String[] args = {};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(stream);
        PrintStream originalOutputStream = System.out;
        System.setOut(out);
        InvertMatrix.main(args);
        System.setOut(originalOutputStream);
        assertEquals(InvertMatrix.MISSING_INPUT_FILE + "\r\n" + InvertMatrix.USAGE_METHOD + "\r\n", stream.toString());
    }

    @Test
    public void main_GiveIncorrectNumberOfArguments_ShouldShowMistakeMessage() {
        String[] args = {"1", "2"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(stream);
        PrintStream originalOutputStream = System.out;
        System.setOut(out);
        InvertMatrix.main(args);
        System.setOut(originalOutputStream);
        assertEquals(InvertMatrix.MISSING_INPUT_FILE + "\r\n" + InvertMatrix.USAGE_METHOD + "\r\n", stream.toString());
    }

    @Test
    public void main_GiveNonFile_ShouldShowMistakeMessage() {
        String[] args = {"1"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(stream);
        PrintStream originalOutputStream = System.out;
        System.setOut(out);
        InvertMatrix.main(args);
        System.setOut(originalOutputStream);
        assertEquals(InvertMatrix.MISSING_INPUT_FILE + "\r\n" + InvertMatrix.USAGE_METHOD + "\r\n", stream.toString());
    }

    @Test
    public void main_GiveEmptyInput_ShouldShowMistakeMessage() {
        String[] args = {PATH + "emptyInput.txt"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(stream);
        PrintStream originalOutputStream = System.out;
        System.setOut(out);
        InvertMatrix.main(args);
        System.setOut(originalOutputStream);
        assertEquals(InvertMatrix.FILE_READING_ERROR + "\r\n", stream.toString());
    }

    @Test
    public void main_GiveIncorrectInput_ShouldShowMistakeMessage() {
        String[] args = {PATH + "incorrectMatrix.txt"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(stream);
        PrintStream originalOutputStream = System.out;
        System.setOut(out);
        InvertMatrix.main(args);
        System.setOut(originalOutputStream);
        assertEquals(InvertMatrix.FILE_READING_ERROR + "\r\n", stream.toString());
    }

    @Test
    public void main_GiveMatrixHasNotInvertMatrix_ShouldShowWarnMessage() {
        String[] args = {PATH + "notInvertMatrix.txt"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(stream);
        PrintStream originalOutputStream = System.out;
        System.setOut(out);
        InvertMatrix.main(args);
        System.setOut(originalOutputStream);
        assertEquals(InvertMatrix.MATRIX_HAS_NOT_INVERSE + "\r\n", stream.toString());
    }

    @Test
    public void main_GiveCorrectMatrix() {
        String[] args = {PATH + "correctMatrix.txt"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(stream);
        PrintStream originalOutputStream = System.out;
        System.setOut(out);
        InvertMatrix.main(args);
        System.setOut(originalOutputStream);
        double[][] expected = {
                {0.143, -0.429, 0.857},
                {-0.143, 0.429, 0.143},
                {0.286, 0.143, -0.286}};
        assertEquals(matrix.toString(expected), stream.toString());
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
        double[][] expected = {
                {1, 2, 3},
                {14, 24, 2},
                {23, 2, 2}};
        assertEquals(this.matrix.toString(expected), stream.toString());
    }

    @Test
    public void readMatrix_incorrectMatrix_shouldShowMistakeMessage() {
        String[] args = {PATH + "incorrectMatrix.txt"};
        double[][] expected = null;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(stream);
        PrintStream originalOutputStream = System.out;
        System.setOut(out);
        double[][] matrix = InvertMatrix.readMatrix(args);
        System.setOut(originalOutputStream);
        assertArrayEquals(expected, matrix);
        assertEquals(InvertMatrix.FILE_READING_ERROR + "\r\n", stream.toString());
    }

    @Test
    public void readMatrix_emptyInput_shouldShowMistakeMessage() {
        String[] args = {PATH + "emptyInput.txt"};
        double[][] expected = null;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(stream);
        PrintStream originalOutputStream = System.out;
        System.setOut(out);
        double[][] matrix = InvertMatrix.readMatrix(args);
        System.setOut(originalOutputStream);
        assertArrayEquals(expected, matrix);
        assertEquals(InvertMatrix.FILE_READING_ERROR + "\r\n", stream.toString());
    }
}