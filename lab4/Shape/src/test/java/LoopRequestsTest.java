import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class LoopRequestsTest {
    public final String PATH = "D://OOP/dudin_oop/lab4/Shape/src/test/resources/";
    LoopRequests requests = new LoopRequests();
    ShapesCreator creator = new ShapesCreator();
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
    public void loopRequests_fileNotFound() {
        String[] args = {"loadLine"};
        requests.loopRequests(args);
        assertEquals(requests.FILE_NOT_FOUND + "\n" + requests.USAGE_METHOD + "\r\n", stream.toString());
    }

    @Test
    public void loopRequests_loadLine_ShouldGiveArrayListWithLine() {
        String[] args = {PATH + "loadLine"};
        requests.loopRequests(args);
        ArrayList<Shape> expected = new ArrayList<>();
        expected.add(new LineSegment(new Point(1, 2), new Point(3, 4), creator.convertStringToColor("#000000")));
        expected.add(new LineSegment(new Point(1, 2), new Point(3, 4), creator.convertStringToColor("#000020")));
        assertEquals(expected.toString(), requests.Shapes.toString());
    }

    @Test
    public void loopRequests_loadTriangle_ShouldGiveArrayListWithTriangle() {
        String[] args = {PATH + "loadTriangle"};
        requests.loopRequests(args);
        ArrayList<Shape> expected = new ArrayList<>();
        expected.add(new Triangle(new Point(1, 2), new Point(3, 4), new Point(5, 6), creator.convertStringToColor("#000000"), creator.convertStringToColor("#000000")));
        assertEquals(expected.toString(), requests.Shapes.toString());
    }

    @Test
    public void loopRequests_loadRectangle_ShouldGiveArrayListWithRectangle() {
        String[] args = {PATH + "loadRectangle"};
        requests.loopRequests(args);
        ArrayList<Shape> expected = new ArrayList<>();
        expected.add(new Rectangle(new Point(1, 2), 3, 4, creator.convertStringToColor("#000000"), creator.convertStringToColor("#000000")));
        expected.add(new Rectangle(new Point(1, 2), 3, 4, creator.convertStringToColor("#00A000"), creator.convertStringToColor("#000000")));
        expected.add(new Rectangle(new Point(1, 2), 3, 4, creator.convertStringToColor("#000000"), creator.convertStringToColor("#000000")));
        assertEquals(expected.toString(), requests.Shapes.toString());
    }

    @Test
    public void loopRequests_loadCircle_ShouldGiveArrayListWithCircle() {
        String[] args = {PATH + "loadCircle"};
        requests.loopRequests(args);
        ArrayList<Shape> expected = new ArrayList<>();
        expected.add(new Circle(new Point(1, 2), 3,  creator.convertStringToColor("#000000"), creator.convertStringToColor("#000000")));
        assertEquals(expected.toString(), requests.Shapes.toString());
    }

    @Test
    public void loopRequests_loadShapes_ShouldGiveArrayListWithShapes() {
        String[] args = {PATH + "loadShapes"};
        requests.loopRequests(args);
        ArrayList<Shape> expected = new ArrayList<>();
        LineSegment lineSegment = new LineSegment(new Point(1, 2), new Point(3, 4), creator.convertStringToColor("#000000"));
        Triangle triangle = new Triangle(new Point(1, 2), new Point(3, 4), new Point(5,  6), creator.convertStringToColor("#000000"), creator.convertStringToColor("#000000"));
        Rectangle rectangle = new Rectangle(new Point(1, 2), 3, 4, creator.convertStringToColor("#000000"), creator.convertStringToColor("#000000"));
        Circle circle = new Circle(new Point(1, 2), 3, creator.convertStringToColor("#000000"), creator.convertStringToColor("#000000"));
        expected.add(lineSegment);
        expected.add(lineSegment);
        expected.add(triangle);
        expected.add(lineSegment);
        expected.add(triangle);
        expected.add(lineSegment);
        expected.add(triangle);
        expected.add(lineSegment);
        expected.add(rectangle);
        expected.add(lineSegment);
        expected.add(lineSegment);
        expected.add(lineSegment);
        expected.add(rectangle);
        expected.add(rectangle);
        expected.add(lineSegment);
        expected.add(rectangle);
        expected.add(lineSegment);
        expected.add(circle);
        expected.add(lineSegment);
        expected.add(lineSegment);
        expected.add(lineSegment);
        assertEquals(expected.toString(), requests.Shapes.toString());
    }
}