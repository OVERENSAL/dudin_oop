import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MainTest {
    public final String PATH = "D://OOP/dudin_oop/lab2/Mini-Dictionary/src/test/resources/";
    Dictionary dictionaryObject = new Dictionary();
    LoopRequests loop = new LoopRequests();
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
    public void main_EmptyArgs_ShouldShowMistakeMessage() {
        String[] args = {};
        Main.main(args);
        assertEquals(dictionaryObject.MISSING_DICTIONARY + "\r\n" + dictionaryObject.USAGE_METHOD + "\r\n", stream.toString());
    }

    @Test
    public void main_NonExistFile_ShouldCreateFile() {
        ByteArrayInputStream in = new ByteArrayInputStream("...\nY".getBytes());
        System.setIn(in);
        String[] args = {PATH + "input.txt"};
        Main.main(args);
        assertEquals(dictionaryObject.LOADING_DICTIONARY + "\r\n"
                + loop.MANUAL + "\r\n" + loop.CONSERVATION + "\r\n"
                + dictionaryObject.SAVE_MSG + "\r\n", stream.toString());
    }

    @Test
    public void main_ExistFile_ShouldCorrectlyWork() {
        ByteArrayInputStream in = new ByteArrayInputStream("...\nY".getBytes());
        System.setIn(in);
        String[] args = {PATH + "saveDictionary.txt"};
        Main.main(args);
        assertEquals(dictionaryObject.LOADING_DICTIONARY + "\r\n"
                + loop.MANUAL + "\r\n" + loop.CONSERVATION + "\r\n"
                + dictionaryObject.SAVE_MSG + "\r\n", stream.toString());
    }

    @Test
    public void main_Dialog_ShouldCorrectlyWork() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\n3\n4\n...\nY".getBytes());
        System.setIn(in);
        String[] args = {PATH + "saveDictionary.txt"};
        Main.main(args);
        assertEquals(dictionaryObject.LOADING_DICTIONARY + "\r\n"
                + loop.MANUAL + "\r\n" + "2\r\n" + "Unknown word '3'. " + dictionaryObject.ENTER_MANUAL + "\r\n"
                + "Word '3' is saved as '4'.\r\n" + loop.CONSERVATION + "\r\n"
                + dictionaryObject.SAVE_MSG + "\r\n", stream.toString());
    }

    @Test
    public void main_DialogWithoutChanges_ShouldCorrectlyWork() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\n4\n\n...\nY".getBytes());
        System.setIn(in);
        String[] args = {PATH + "saveDictionary.txt"};
        Main.main(args);
        assertEquals(dictionaryObject.LOADING_DICTIONARY + "\r\n"
                + loop.MANUAL + "\r\n" + "2\r\n" + "Unknown word '4'. " + dictionaryObject.ENTER_MANUAL + "\r\n"
                + "Word '4' ignored.\r\n" + loop.CONSERVATION + "\r\n"
                + dictionaryObject.SAVE_MSG + "\r\n", stream.toString());
    }
}