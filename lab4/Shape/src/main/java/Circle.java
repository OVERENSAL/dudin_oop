import java.awt.*;

public class Circle implements SolidShape{
    public Color outlineColor;
    public Color fillColor;
    public Point center;
    public double radius;
    ShapesCreator creator = new ShapesCreator();

    public Circle(Point center, double radius, Color outlineColor, Color fillColor) {
        this.center = center;
        this.radius = radius;
        this.outlineColor = outlineColor;
        this.fillColor = fillColor;
    }

    @Override
    public Color getFillColor() { return fillColor; }
    
    @Override
    public Color getOutlineColor() {
        return outlineColor;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle:\n" +
                "Area: " + creator.roundDouble(getArea()) + "\n" +
                "Perimeter: " + creator.roundDouble(getPerimeter()) + "\n" +
                "Outline Color: " + creator.convertColorToString(getOutlineColor()) + "\n" +
                "Fill Color: " + creator.convertColorToString(getFillColor()) + "\n" +
                "Center: " + getCenter().toString() + "\n" +
                "Radius: " + getRadius() + "\n";
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }
}
