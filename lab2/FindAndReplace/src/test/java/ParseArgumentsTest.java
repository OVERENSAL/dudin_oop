import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ParseArgumentsTest {
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
    public void getSearchingString_EmptyArgs_ShouldShowMistakeMessage() {
        String[] args = {};
        assertNull(parseArguments.getSearchingString(args));
        assertEquals(parseArguments.MISSING_SEARCHING_STRING + "\r\n", stream.toString());
    }

    @Test
    public void getSearchingString_FullArgs_ShouldReturnFirstElement() {
        String[] args = {"1", "2"};
        assertEquals("1", parseArguments.getSearchingString(args));
    }


    @Test
    public void getReplacementString_EmptyArgs_ShouldShowMistakeMessage() {
        String[] args = {};
        assertNull(parseArguments.getReplacementString(args));
        assertEquals(parseArguments.MISSING_REPLACEMENT_STRING + "\r\n", stream.toString());
    }

    @Test
    public void getReplacementString_FullArgs_ShouldReturnSecondElement() {
        String[] args = {"1", "2"};
        assertEquals("2", parseArguments.getReplacementString(args));
    }
}