import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class DictionaryLoadTest {
    public final String PATH = "D://OOP/dudin_oop/lab2/Mini-Dictionary/src/test/resources/";
    DictionaryLoad load = new DictionaryLoad();
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
    public void dictionaryLoad_EmptyArgs_ShouldShowMistakeMessageAndReturnNull() {
        String[] args = {};
        load.dictionaryLoad(args);
        assertEquals(load.MISSING_DICTIONARY + "\r\n" + load.USAGE_METHOD + "\r\n", stream.toString());
    }

    @Test
    public void dictionaryLoad_SomeStrings_ShouldReturnMapWithTheseStrings() {
        String[] args = {PATH + "dictionarySomeString.txt"};
        Map<String, String> expected = new HashMap<>();
        expected.put("12", "sdf");
        expected.put("sdf", "sdf");
        expected.put("sef", "fds");
        Map<String, String> result = load.dictionaryLoad(args);
        assertEquals(expected, result);
    }

    @Test
    public void dictionaryLoad_SomeStringsWithoutCouple_ShouldReturnMapWithTheseStrings() {
        String[] args = {PATH + "dictionarySomeStringWithoutCouple.txt"};
        Map<String, String> expected = new HashMap<>();
        expected.put("sdf", "sdf");
        expected.put("sef", "fds");
        Map<String, String> result = load.dictionaryLoad(args);
        assertEquals(expected, result);
    }
}