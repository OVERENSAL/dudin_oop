import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;

import static org.junit.Assert.*;

public class MainTest {
    CompletionVector vector = new CompletionVector();
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(stream);
    PrintStream originalOutputStream = System.out;
    String[] args = {};

    @Before
    public void changeOutputStream() {
        System.setOut(out);
    }

    @After
    public void returnStandardOutputStream() {
        System.setOut(originalOutputStream);
    }

    @Test
    public void main_GiveEmptyString_ShouldShowMistakeMessage() {
        ByteArrayInputStream in = new ByteArrayInputStream("".getBytes());
        System.setIn(in);
        Main.main(args);
        assertEquals( vector.USAGE_METHOD + "\r\n", stream.toString());
    }

    @Test
    public void main_GiveNonDigitString_ShouldShowMistakeMessage() {
        ByteArrayInputStream in = new ByteArrayInputStream("d".getBytes());
        System.setIn(in);
        Main.main(args);
        assertEquals( vector.STRING_IS_NOT_NUMBER + "\r\n" + vector.USAGE_METHOD + "\r\n", stream.toString());
    }

    @Test
    public void main_GiveDigitString_ShouldReturnSequenceNumber() {
        ByteArrayInputStream in = new ByteArrayInputStream("1 2 3 4".getBytes());
        System.setIn(in);
        Main.main(args);
        Vector<Double> expected = new Vector<>();
        expected.add(0.5);
        expected.add(1.0);
        expected.add(1.5);
        expected.add(2.0);
        assertEquals(expected.toString() + "\r\n", stream.toString());
    }

    @Test
    public void main_GiveDoubleDigitString_ShouldReturnSequenceNumberRoundedTo3Character() {
        ByteArrayInputStream in = new ByteArrayInputStream("1.35521 2.658322 3.32463 4.5844 ".getBytes());
        System.setIn(in);
        Main.main(args);
        Vector<Double> expected = new Vector<>();
        expected.add(0.591);
        expected.add(1.16);
        expected.add(1.45);
        expected.add(2.0);
        assertEquals(expected.toString() + "\r\n", stream.toString());
    }
}