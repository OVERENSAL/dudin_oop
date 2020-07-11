import java.awt.*;

public class Triangle implements SolidShape {
    public Color outlineColor;
    public Color fillColor;
    public Point vertex1;
    public Point vertex2;
    public Point vertex3;
    ShapesCreator creator = new ShapesCreator();

    public Triangle(Point vertex1, Point vertex2, Point vertex3, Color outlineColor, Color fillColor) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
        this.outlineColor = outlineColor;
        this.fillColor = fillColor;
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public Color getOutlineColor() {
        return outlineColor;
    }

    @Override
    public double getArea() {
        double halfPerimeter = getPerimeter() / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - getSide1()) * (halfPerimeter - getSide2()) * (halfPerimeter - getSide3()));
    }

    @Override
    public double getPerimeter() {
        return getSide1() + getSide2() + getSide3();
    }


    private double getSide1() {
        return Math.sqrt(Math.pow(vertex2.getX() - vertex1.getX(), 2) + Math.pow(vertex2.getY() - vertex1.getY(), 2));
    }

    private double getSide2() {
        return Math.sqrt(Math.pow(vertex3.getX() - vertex2.getX(), 2) + Math.pow(vertex3.getY() - vertex2.getY(), 2));
    }

    private double getSide3() {
        return Math.sqrt(Math.pow(vertex1.getX() - vertex3.getX(), 2) + Math.pow(vertex1.getY() - vertex3.getY(), 2));
    }

    public Point getVertex1() {
        return vertex1;
    }

    public Point getVertex2() {
        return vertex2;
    }

    public Point getVertex3() {
        return vertex3;
    }

    public String toString() {
        return "Triangle:\n" +
                "Area: " + creator.roundDouble(getArea()) + "\n" +
                "Perimeter: " + creator.roundDouble(getPerimeter()) + "\n" +
                "Outline Color: " + creator.convertColorToString(getOutlineColor()) + "\n" +
                "Fill Color: " + creator.convertColorToString(getFillColor()) + "\n" +
                "Vertex1: " + getVertex1().toString() + "\n" +
                "Vertex2: " + getVertex2().toString() + "\n" +
                "Vertex3: " + getVertex3().toString() + "\n";
    }
}
