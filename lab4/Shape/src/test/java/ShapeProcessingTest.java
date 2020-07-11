import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ShapeProcessingTest {
    ShapesCreator creator = new ShapesCreator();
    ShapeProcessing process = new ShapeProcessing();

    @Test
    public void getMaxAreaFromLine() {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new LineSegment(new Point(1, 2), new Point(3, 4), creator.convertStringToColor("#000000")));
        assertEquals(shapes.get(0).toString(), process.getMaxAreaFromShapes(shapes));
    }

    @Test
    public void getMaxAreaFromTriangle() {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Triangle(new Point(1, 2), new Point(3, 4), new Point(5, 6), creator.convertStringToColor("#000000"), creator.convertStringToColor("#000000")));
        shapes.add(new Triangle(new Point(1, 2), new Point(3, 4), new Point(100, 800), creator.convertStringToColor("#000000"), creator.convertStringToColor("#000000")));
        assertEquals(shapes.get(1).toString(), process.getMaxAreaFromShapes(shapes));
    }

    @Test
    public void getMaxAreaFromShapes() {
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
        assertEquals(expected.get(17).toString(), process.getMaxAreaFromShapes(expected));
    }

    @Test
    public void getMinPerimeterFromLine() {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new LineSegment(new Point(1, 2), new Point(3, 4), creator.convertStringToColor("#000000")));
        assertEquals(shapes.get(0).toString(), process.getMinPerimeterFromShapes(shapes));
    }

    @Test
    public void getMinPerimeterFromTriangle() {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Triangle(new Point(1, 2), new Point(3, 4), new Point(5, 6), creator.convertStringToColor("#000000"), creator.convertStringToColor("#000000")));
        shapes.add(new Triangle(new Point(1, 2), new Point(3, 4), new Point(100, 800), creator.convertStringToColor("#000000"), creator.convertStringToColor("#000000")));
        assertEquals(shapes.get(0).toString(), process.getMinPerimeterFromShapes(shapes));
    }

    @Test
    public void getMinPerimeterFromShapes() {
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
        assertEquals(expected.get(0).toString(), process.getMinPerimeterFromShapes(expected));
    }

}