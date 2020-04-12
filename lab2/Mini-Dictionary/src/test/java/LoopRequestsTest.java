import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class LoopRequestsTest {
    Dictionary dictionaryObject = new Dictionary();
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(stream);
    PrintStream originalOutputStream = System.out;
    LoopRequests loop = new LoopRequests();

    @Before
    public void setCustomOutputStream() {
        System.setOut(out);
    }

    @After
    public void setOriginalOutputStream() {
        System.setOut(originalOutputStream);
    }

    @Test
    public void loopRequest_ExitAndSave_ShouldReturnTrue() {
        ByteArrayInputStream in = new ByteArrayInputStream("...\nY".getBytes());
        System.setIn(in);
        Map<String, String> dictionary = new HashMap<>();
        boolean result = loop.loopRequest(dictionary);
        assertEquals(loop.MANUAL + "\r\n" + loop.CONSERVATION + "\r\n", stream.toString());
        assertTrue(result);
    }

    @Test
    public void loopRequest_DialogWithoutSave_ShouldReturnFalse() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\n2\n...\nN".getBytes());
        System.setIn(in);
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("1", "2");
        dictionary.put("2", "3");
        boolean result = loop.loopRequest(dictionary);
        assertEquals(loop.MANUAL + "\r\n" + "2\r\n" + "3" + "\r\n" + loop.CONSERVATION + "\r\n", stream.toString());
        assertFalse(result);
    }

    @Test
    public void loopRequest_DialogWithUnknownWordWithSave_ShouldReturnTrue() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\n2\n...\nN".getBytes());
        System.setIn(in);
        Map<String, String> dictionary = new HashMap<>();
        boolean result = loop.loopRequest(dictionary);
        assertEquals(loop.MANUAL + "\r\n" + "Unknown word '1'. " + dictionaryObject.ENTER_MANUAL + "\r\n" + "Word '1' is saved as '2'." + "\r\n" + loop.CONSERVATION + "\r\n", stream.toString());
        assertFalse(result);
    }

    @Test
    public void loopRequest_DialogWithUnknownWordWithoutAddWithSave_ShouldReturnTrue() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\n\n...\nN".getBytes());
        System.setIn(in);
        Map<String, String> dictionary = new HashMap<>();
        boolean result = loop.loopRequest(dictionary);
        assertEquals(loop.MANUAL + "\r\n" + "Unknown word '1'. " + dictionaryObject.ENTER_MANUAL + "\r\n" + "Word '1' ignored." + "\r\n" + loop.CONSERVATION + "\r\n", stream.toString());
        assertFalse(result);
    }
}