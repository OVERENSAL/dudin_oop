import org.junit.Test;
import java.awt.Color;

import static org.junit.Assert.*;

public class ShapesCreatorTest {
    ShapesCreator creator = new ShapesCreator();

    @Test
    public void createLineSegment_WithNonCorrectColorInfo() {
        String[] info = {"line", "1", "2", "3", "4", "0000000"};
        assertNull(creator.createLineSegment(info));
    }

    @Test
    public void createLineSegment_WithEmptyInfo_ShouldReturnNull() {
        String[] info = {};
        assertNull(creator.createLineSegment(info));
    }

    @Test
    public void createLineSegment_WithNonCorrectInfo_ShouldReturnNull() {
        String[] info = {"line", "1", "2", "3", "4"};
        assertNull(creator.createLineSegment(info));
    }

    @Test
    public void createLineSegment_WithNonCorrectPointInfo_ShouldReturnNull() {
        String[] info = {"line", "", "2", "3", "4", "#000000"};
        assertNull(creator.createLineSegment(info));
    }

    @Test
    public void createLineSegment_WithNonCorrectColorInfo_ShouldReturnNull() {
        String[] info = {"line", "1", "2", "3", "4", "#00000"};
        assertNull(creator.createLineSegment(info));
    }

    @Test
    public void createLineSegment_ShouldReturnLineObj() {
        String[] info = {"line", "1", "2", "3", "4", "#000000"};
        Point x = new Point(1, 2);
        Point y = new Point(3, 4);
        Color color = creator.convertStringToColor("#000000");
        LineSegment lineSegment = new LineSegment(x, y, color);
        assertEquals(lineSegment.toString(), creator.createLineSegment(info).toString());
    }

    @Test
    public void createTriangle_WithEmptyInfo_ShouldReturnNull() {
        String[] info = {};
        assertNull(creator.createTriangle(info));
    }

    @Test
    public void createTriangle_WithNonCorrectInfo_ShouldReturnNull() {
        String[] info = {"triangle", "1", "2", "3", "4", "5", "6"};
        assertNull(creator.createTriangle(info));
    }

    @Test
    public void createTriangle_WithNonCorrectPointInfo_ShouldReturnNull() {
        String[] info = {"Triangle", "", "2", "3", "4", "5", "6", "#000A00", "#000000"};
        assertNull(creator.createTriangle(info));
    }

    @Test
    public void createTriangle_ShouldReturnTriangleObj() {
        String[] info = {"Triangle", "1", "2", "3", "4", "5", "6", "#000A00", "#000000"};
        Point x = new Point(1, 2);
        Point y = new Point(3, 4);
        Point z = new Point(5, 6);
        Color outlineColor = creator.convertStringToColor("#000A00");
        Color fillColor = creator.convertStringToColor("#000000");
        Triangle triangle = new Triangle(x, y, z, outlineColor, fillColor);
        assertEquals(triangle.toString(), creator.createTriangle(info).toString());
    }

    @Test
    public void createRectangle_WithEmptyInfo_ShouldReturnNull() {
        String[] info = {};
        assertNull(creator.createRectangle(info));
    }

    @Test
    public void createRectangle_WithNonCorrectInfo_ShouldReturnNull() {
        String[] info = {"rectangle", "1", "2", "3", "4"};
        assertNull(creator.createRectangle(info));
    }

    @Test
    public void createRectangle_WithNonCorrectPointInfo_ShouldReturnNull() {
        String[] info = {"Triangle", "", "2", "3", "4", "#000A00", "#000000"};
        assertNull(creator.createRectangle(info));
    }

    @Test
    public void createRectangle_ShouldReturnRectangleObj() {
        String[] info = {"rectangle", "1", "2", "3", "4", "#000A00", "#000000"};
        Point x = new Point(1, 2);
        double width = 3;
        double height = 4;
        Color outlineColor = creator.convertStringToColor("#000A00");
        Color fillColor = creator.convertStringToColor("#000000");
        Rectangle rectangle = new Rectangle(x, width, height, outlineColor, fillColor);
        assertEquals(rectangle.toString(), creator.createRectangle(info).toString());
    }

    @Test
    public void createCircle_WithEmptyInfo_ShouldReturnNull() {
        String[] info = {};
        assertNull(creator.createCircle(info));
    }

    @Test
    public void createCircle_WithNonCorrectInfo_ShouldReturnNull() {
        String[] info = {"circle", "1", "2", "3", "4"};
        assertNull(creator.createCircle(info));
    }

    @Test
    public void createCircle_WithNonCorrectPointInfo_ShouldReturnNull() {
        String[] info = {"Circle", "", "2", "#000A00", "#000000"};
        assertNull(creator.createCircle(info));
    }

    @Test
    public void createCircle_ShouldReturnCircleObj() {
        String[] info = {"circle", "1", "2", "3", "#000A00", "#000000"};
        Point x = new Point(1, 2);
        double radius = 3;
        Color outlineColor = creator.convertStringToColor("#000A00");
        Color fillColor = creator.convertStringToColor("#000000");
        Circle circle = new Circle(x, radius, outlineColor, fillColor);
        assertEquals(circle.toString(), creator.createCircle(info).toString());
    }
}