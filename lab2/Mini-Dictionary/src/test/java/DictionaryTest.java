import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class DictionaryTest {
    public final String PATH = "D://OOP/dudin_oop/lab2/Mini-Dictionary/src/test/resources/";
    Dictionary dictionaryObject = new Dictionary();
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
        dictionaryObject.dictionaryLoad(args);
        assertEquals(dictionaryObject.MISSING_DICTIONARY + "\r\n" + dictionaryObject.USAGE_METHOD + "\r\n", stream.toString());
    }

    @Test
    public void dictionaryLoad_NonExistFile_ShouldShowMistakeMessageAndReturnNull() {
        String[] args = {PATH};
        dictionaryObject.dictionaryLoad(args);
        assertEquals(dictionaryObject.MISSING_DICTIONARY + "\r\n" + dictionaryObject.USAGE_METHOD + "\r\n", stream.toString());
    }

    @Test
    public void dictionaryLoad_SomeStrings_ShouldReturnMapWithTheseStrings() {
        String[] args = {PATH + "dictionarySomeString.txt"};
        Map<String, String> expected = new HashMap<>();
        expected.put("12", "sdf");
        expected.put("sdf", "sdf");
        expected.put("sef", "fds");
        Map<String, String> result = dictionaryObject.dictionaryLoad(args);
        assertEquals(expected, result);
    }

    @Test
    public void dictionaryLoad_SomeStringsWithoutCouple_ShouldReturnMapWithTheseStrings() {
        String[] args = {PATH + "dictionarySomeStringWithoutCouple.txt"};
        Map<String, String> expected = new HashMap<>();
        expected.put("sdf", "sdf");
        expected.put("sef", "fds");
        Map<String, String> result = dictionaryObject.dictionaryLoad(args);
        assertEquals(expected, result);
    }

    Map<String, String> expected = new HashMap<>();

    @Test
    public void addWord_AddWordInDictionary_ShouldAddWord() {
        ByteArrayInputStream in = new ByteArrayInputStream("4".getBytes());
        System.setIn(in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> result = new HashMap<>();
        result.put("1", "2");
        dictionaryObject.addWord(result, "3", reader);
        expected.put("1", "2");
        expected.put("3", "4");
        assertEquals(expected, result);
    }

    @Test
    public void addWord_Exit_ShouldShowMessage() {
        ByteArrayInputStream in = new ByteArrayInputStream("".getBytes());
        System.setIn(in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> result = new HashMap<>();
        result.put("1", "2");
        dictionaryObject.addWord(result, "3", reader);
        expected.put("1", "2");
        assertEquals(expected, result);
        assertEquals("Unknown word '3'. " + dictionaryObject.ENTER_MANUAL + "\r\n" + "Word '3' ignored." + "\r\n", stream.toString());
    }

    @Test
    public void saveWords_SaveSomeString_ShouldSaveCorrectly() {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("1", "2");
        dictionary.put("2", "3");
        String[] args = {PATH + "saveDictionary.txt"};
        dictionaryObject.saveWords(dictionary, args);
        Map<String, String> result = dictionaryObject.dictionaryLoad(args); //already tested
        Map<String, String> expected = new HashMap<>();
        expected.put("1", "2");
        expected.put("2", "3");
        assertEquals(expected, result);
    }
}