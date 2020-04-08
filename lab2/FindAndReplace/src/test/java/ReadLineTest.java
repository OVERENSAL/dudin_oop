import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.applet.Main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import static org.junit.Assert.*;

public class ReadLineTest {
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
    public void readLine_SimpleLine_ShouldReturnThisLine() {
        ByteArrayInputStream in = new ByteArrayInputStream("ds".getBytes());
        System.setIn(in);
        String result = FindAndReplace.readLine();
        assertEquals("ds", result);
    }

    @Test
    public void readLine_EmptyLine_ShouldReturnNull() {
        ByteArrayInputStream in = new ByteArrayInputStream("".getBytes());
        System.setIn(in);
        String result = FindAndReplace.readLine();
        assertNull(result);
        assertEquals(FindAndReplace.USAGE_METHOD + "\r\n" + FindAndReplace.INPUT_ERROR + "\r\n", stream.toString());
    }
}