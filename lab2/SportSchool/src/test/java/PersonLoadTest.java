import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;

import static org.junit.Assert.*;

public class PersonLoadTest {
    public final String PATH = "D://OOP/dudin_oop/lab2/SportSchool/src/test/resources/";
    PersonLoad load = new PersonLoad();
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
    public void personLoad_LoadOneFileWithoutRepeat_ShouldReturnRightHashSet() {
        String[] args = {PATH + "1.txt"};
        HashSet <String> result = load.personLoad(args);
        HashSet <String> expected = new HashSet<>();
        expected.add("Vasya Pukin");
        expected.add("Dima Bukin");
        expected.add("Petya Kukin");
        expected.add("Valera Reper");
        assertEquals(expected, result);
    }

    @Test
    public void personLoad_LoadSomeFileWithoutRepeat_ShouldReturnRightHashSet() {
        String[] args = {PATH + "1.txt", PATH + "2.txt"};
        HashSet <String> result = load.personLoad(args);
        HashSet <String> expected = new HashSet<>();
        expected.add("Vasya Pukin");
        expected.add("Dima Bukin");
        expected.add("Petya Kukin");
        expected.add("Valera Reper");
        expected.add("Valya Biber");
        expected.add("Genry Shifter");
        expected.add("Lina Dueren");
        expected.add("Tem Bulatov");
        assertEquals(expected, result);
    }

    @Test
    public void personLoad_LoadSomeFileWithRepeat_ShouldReturnRightHashSet() {
        String[] args = {PATH + "1.txt", PATH + "1(1).txt"};
        HashSet <String> result = load.personLoad(args);
        HashSet <String> expected = new HashSet<>();
        expected.add("Vasya Pukin");
        expected.add("Dima Bukin");
        expected.add("Petya Kukin");
        expected.add("Valera Reper");
        assertEquals(expected, result);
    }

    @Test
    public void personLoad_EmptyArgs_ShouldShowMistakeMessage() {
        String[] args = {};
        load.personLoad(args);
        assertEquals(load.MISSING_FILES + "\r\n" + load.USAGE_METHOD + "\r\n", stream.toString());
    }

    @Test
    public void personLoad_LoadNonExistFile_ShouldShowMistakeMessage() {
        String[] args = {PATH + "3.txt"};
        load.personLoad(args);
        assertEquals("File 'D://OOP/dudin_oop/lab2/SportSchool/src/test/resources/3.txt' is missing.\r\n", stream.toString());
    }
}