import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Map;

import static org.junit.Assert.*;

public class MainTest {
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
    public void showSet_Empty_ShouldShowEmptyList() {
        HashSet<String> emptySet = new HashSet<>();
        Main.showSet(emptySet);
        assertEquals("", stream.toString());
    }

    @Test
    public void showSet_SomeItems_ShouldShowAllThisItems() {
        HashSet<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        Main.showSet(set);
        assertEquals("1\r\n2\r\n", stream.toString());
    }

    @Test
    public void main_EmptyArgs_ShouldShowMistakeMessage() {
        String[] args = {};
        Main.main(args);
        assertEquals(load.MISSING_FILES + "\r\n" + load.USAGE_METHOD + "\r\n", stream.toString());
    }

    @Test
    public void main_1Args_ShouldShowList() {
        String[] args = {PATH + "1.txt"};
        Main.main(args);
        assertEquals("Валера\r\nVasya Pukin\r\nDima Bukin\r\nPetya Kukin\r\n", stream.toString());
    }

    @Test
    public void main_someArgs_ShouldShowList() {
        String[] args = {PATH + "1.txt", PATH + "2.txt"};
        Main.main(args);
        assertEquals("Валера\r\nTem Bulatov\r\nVasya Pukin\r\nDima Bukin\r\nLina Dueren\r\n" +
                "Petya Kukin\r\nValya Biber\r\nGenry Shifter\r\n", stream.toString());
    }

    @Test
    public void main_someArgsWithRepeat_ShouldShowListWithoutRepeat() {
        String[] args = {PATH + "1.txt", PATH + "1(1).txt"};
        Main.main(args);
        assertEquals("Валера\r\nVasya Pukin\r\nDima Bukin\r\nPetya Kukin\r\n", stream.toString());
    }
}