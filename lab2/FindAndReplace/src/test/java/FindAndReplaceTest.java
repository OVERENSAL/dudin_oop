import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class FindAndReplaceTest {
    ParseArguments parseArguments = new ParseArguments();
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(stream);
    PrintStream originalOutputStream = System.out;

    @Before
    public void setCustomOutputStream() {
        System.setOut(out);
    }

    @After
    public void setOriginalOutputStream() {
        System.setOut(originalOutputStream);
    }

    @Test
    public void main_EmptyString_ShouldShowMistakeMessageAndReturnNull() {
        ByteArrayInputStream in = new ByteArrayInputStream("".getBytes());
        System.setIn(in);
        String[] args = {"1", "2"};
        FindAndReplace.main(args);
        assertEquals(FindAndReplace.USAGE_METHOD + "\r\n" + FindAndReplace.INPUT_ERROR + "\r\n", stream.toString());
    }

    @Test
    public void main_EmptyArgs_ShouldShowMistakeMessage() {
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        String[] args = {};
        FindAndReplace.main(args);
        assertEquals(parseArguments.MISSING_SEARCHING_STRING + "\r\n" + parseArguments.MISSING_REPLACEMENT_STRING + "\r\n", stream.toString());
    }

    @Test
    public void main_StringWithoutSearchStringInside_ShouldShowOriginalString() {
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        String[] args = {"2", "3"};
        FindAndReplace.main(args);
        assertEquals("1\r\n", stream.toString());
    }
}