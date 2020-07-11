import java.awt.Color;

public class LineSegment implements Shape {
    public Color outlineColor;
    public Point startPoint;
    public Point endPoint;
    ShapesCreator creator = new ShapesCreator();

    public LineSegment(Point startPoint, Point endPoint, Color outlineColor) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.outlineColor = outlineColor;
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getPerimeter() {
        return Math.sqrt(Math.pow(endPoint.getX() - startPoint.getX(), 2) + Math.pow(endPoint.getY() - startPoint.getY(), 2)) * 1000.0 / 1000;
    }

    @Override
    public Color getOutlineColor() {
        return outlineColor;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public String toString() {
        return "Line Segment:\n" +
                "Area: " + creator.roundDouble(getArea()) + "\n" +
                "Perimeter: " + creator.roundDouble(getPerimeter()) + "\n" +
                "Outline Color: " + creator.convertColorToString(getOutlineColor()) + "\n" +
                "Start Point: " + getStartPoint().toString() + "\n" +
                "End Point: " + getEndPoint().toString() + "\n";
    }
}
