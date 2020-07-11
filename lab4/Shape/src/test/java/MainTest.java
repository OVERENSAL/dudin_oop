import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MainTest {
    public final String PATH = "D://OOP/dudin_oop/lab4/Shape/src/test/resources/";
    LoopRequests requests = new LoopRequests();
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(stream);
    PrintStream originalOutputStream = System.out;

    @Before
    public void changeOutputStream() {
        System.setOut(out);
    }

    @After
    public void returnStandardOutputStream() {
        System.setOut(originalOutputStream);
    }

    @Test
    public void main_withoutArguments() {
        String[] args = {};
        Main.main(args);
        assertEquals(requests.FILE_NOT_FOUND + "\n" + requests.USAGE_METHOD + "\r\n", stream.toString());
    }

    @Test
    public void main_notExistFile() {
        String[] args = {" "};
        Main.main(args);
        assertEquals(requests.FILE_NOT_FOUND + "\n" + requests.USAGE_METHOD + "\r\n", stream.toString());
    }

    @Test
    public void main() {
        String[] args = {PATH + "loadShapes.txt"};
        Main.main(args);
        ShapesCreator creator = new ShapesCreator();
        LineSegment line = new LineSegment(new Point(1, 2), new Point(3, 4), creator.convertStringToColor("#000000"));
        Circle circle = new Circle(new Point(1, 2), 3, creator.convertStringToColor("#000000"), creator.convertStringToColor("#000000"));
        assertEquals("The shape with the largest area:\r\n" + circle.toString() + "\r\n" +  "The shape with the smallest perimeter:\r\n" + line.toString() + "\r\n", stream.toString());
    }
}