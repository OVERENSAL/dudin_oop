import java.io.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class FlipbyteTest {
    private static final String INCORRECT_INPUT = "Incorrect input. Enter a number from 0 to 255.";

    @Test
    public void incorrectMain() {
        String[] args = {};
        ByteArrayInputStream in = new ByteArrayInputStream("".getBytes());
        System.setIn(in);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(stream);
        PrintStream originalOutputStream = System.out;
        System.setOut(out);
        Flipbyte.main(args);
        System.setOut(originalOutputStream);
        assertEquals(INCORRECT_INPUT, stream.toString().trim());
    }

    @Test
    public void negativeMain() {
        String[] args = {};
        ByteArrayInputStream in = new ByteArrayInputStream("-1".getBytes());
        System.setIn(in);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(stream);
        PrintStream originalOutputStream = System.out;
        System.setOut(out);
        Flipbyte.main(args);
        System.setOut(originalOutputStream);
        assertEquals(INCORRECT_INPUT, stream.toString().trim());
    }

    @Test
    public void main0() {
        String[] args = {};
        ByteArrayInputStream in = new ByteArrayInputStream("0".getBytes());
        System.setIn(in);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(stream);
        PrintStream originalOutputStream = System.out;
        System.setOut(out);
        Flipbyte.main(args);
        System.setOut(originalOutputStream);
        assertEquals("0", stream.toString().trim());
    }

    @Test
    public void main1() {
        String[] args = {};
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(stream);
        PrintStream originalOutputStream = System.out;
        System.setOut(out);
        Flipbyte.main(args);
        System.setOut(originalOutputStream);
        assertEquals("128", stream.toString().trim());
    }

    @Test
    public void main6() {
        String[] args = {};
        ByteArrayInputStream in = new ByteArrayInputStream("6".getBytes());
        System.setIn(in);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(stream);
        PrintStream originalOutputStream = System.out;
        System.setOut(out);
        Flipbyte.main(args);
        System.setOut(originalOutputStream);
        assertEquals("96", stream.toString().trim());
    }

    @Test
    public void main255() {
        String[] args = {};
        ByteArrayInputStream in = new ByteArrayInputStream("255".getBytes());
        System.setIn(in);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(stream);
        PrintStream originalOutputStream = System.out;
        System.setOut(out);
        Flipbyte.main(args);
        System.setOut(originalOutputStream);
        assertEquals("255", stream.toString().trim());
    }

    @Test
    public void upperMaxMain() {
        String[] args = {};
        ByteArrayInputStream in = new ByteArrayInputStream("256".getBytes());
        System.setIn(in);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(stream);
        PrintStream originalOutputStream = System.out;
        System.setOut(out);
        Flipbyte.main(args);
        System.setOut(originalOutputStream);
        assertEquals(INCORRECT_INPUT, stream.toString().trim());
    }

    @Test
    public void incorrectNumber() {
        ByteArrayInputStream in = new ByteArrayInputStream("".getBytes());
        System.setIn(in);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(stream);
        PrintStream originalPrintStream = System.out;//сохранять текущий поток вывода до его изменения
        System.setOut(out);
        Flipbyte.checkNumber();
        System.setOut(originalPrintStream);
        assertEquals(INCORRECT_INPUT, stream.toString().trim());
    }

    @Test
    public void negativeNumber() {
        ByteArrayInputStream in = new ByteArrayInputStream("-1".getBytes());
        System.setIn(in);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(stream);
        PrintStream originalPrintStream = System.out;//сохранять текущий поток вывода до его изменения
        System.setOut(out);
        Flipbyte.checkNumber();
        System.setOut(originalPrintStream);
        assertEquals(INCORRECT_INPUT, stream.toString().trim());
    }

    @Test
    public void underMaxNumber() {
        ByteArrayInputStream in = new ByteArrayInputStream("256".getBytes());
        System.setIn(in);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(stream);
        PrintStream originalPrintStream = System.out;//сохранять текущий поток вывода до его изменения
        System.setOut(out);
        Flipbyte.checkNumber();
        System.setOut(originalPrintStream);
        assertEquals(INCORRECT_INPUT, stream.toString().trim());
    }

    @Test
    public void minNumber() {
        ByteArrayInputStream in = new ByteArrayInputStream("0".getBytes());
        System.setIn(in);
        assertEquals(0, Flipbyte.checkNumber());
    }

    @Test
    public void rightNumber() {
        ByteArrayInputStream in = new ByteArrayInputStream("6".getBytes());
        System.setIn(in);
        assertEquals(6, Flipbyte.checkNumber());
    }

    @Test
    public void maxNumber() {
        ByteArrayInputStream in = new ByteArrayInputStream("255".getBytes());
        System.setIn(in);
        assertEquals(255, Flipbyte.checkNumber());
    }

    @Test
    public void flip0() {
        assertEquals("00000000", Flipbyte.flip("00000000"));
    }

    @Test
    public void flip1() {
        assertEquals("00000001", Flipbyte.flip("10000000"));
    }

    @Test
    public void flip3() {
        assertEquals("00000011", Flipbyte.flip("11000000"));
    }

    @Test
    public void flip6() {
        assertEquals("00000110", Flipbyte.flip("01100000"));
    }

    @Test
    public void flip255() {
        assertEquals("11111111", Flipbyte.flip("11111111"));
    }
}