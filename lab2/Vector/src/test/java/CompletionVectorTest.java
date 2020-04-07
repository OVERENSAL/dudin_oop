import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Vector;

import static org.junit.Assert.*;

public class CompletionVectorTest {
    CompletionVector vector = new CompletionVector();
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(stream);
    PrintStream originalOutputStream = System.out;

    @Before
    public void changeOutputStream() {
        System.setOut(out);
    }

    @After
    public void returnStandardOutputStream() {
        System.setOut(originalOutputStream);
    }

    @Test
    public void getCompletionVector_EnterEmptyString_ShouldShowMistakeMessage() {
        ByteArrayInputStream in = new ByteArrayInputStream("".getBytes());
        System.setIn(in);
        vector.getCompletionVector();
        assertEquals(vector.USAGE_METHOD + "\r\n", stream.toString());
    }

    @Test
    public void getCompletionVector_NonDigitString_ShouldShowMistakeMessage() {
        ByteArrayInputStream in = new ByteArrayInputStream("d".getBytes());
        System.setIn(in);
        vector.getCompletionVector();
        assertEquals(vector.STRING_IS_NOT_NUMBER + "\r\n" + vector.USAGE_METHOD + "\r\n", stream.toString());
    }

    @Test
    public void getCompletionVector_RightCompletion_ShouldReturnCompletionVector() {
        ByteArrayInputStream in = new ByteArrayInputStream("1 2 3 4.23421 ".getBytes());
        System.setIn(in);
        Vector<Double> expected = new Vector<>();
        expected.add(1.0);
        expected.add(2.0);
        expected.add(3.0);
        expected.add(4.23421);
        assertEquals(expected, vector.getCompletionVector());
    }
}