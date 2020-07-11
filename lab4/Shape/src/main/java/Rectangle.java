import java.awt.*;

public class Rectangle implements SolidShape {
    public Color outlineColor;
    public Color fillColor;
    public Point leftTop;
    public double width;
    public double height;
    ShapesCreator creator = new ShapesCreator();

    public Rectangle(Point leftTop, double width, double height, Color outlineColor, Color fillColor) {
        this.leftTop = leftTop;
        this.width = width;
        this.height = height;
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
        return getHeight() * getWidth();
    }

    @Override
    public double getPerimeter() {
        return getWidth() * 2 + getHeight() * 2;
    }

    public Point getLeftTop() {
        return leftTop;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public String toString() {
        return "Rectangle:\n" +
                "Area: " + creator.roundDouble(getArea()) + "\n" +
                "Perimeter: " + creator.roundDouble(getArea()) + "\n" +
                "Outline Color: " + creator.convertColorToString(getOutlineColor()) + "\n" +
                "Fill Color: " + creator.convertColorToString(getFillColor()) + "\n" +
                "Left Top: " + getLeftTop().toString() + "\n" +
                "Width: " + getWidth() + "\n" +
                "Height: " + getHeight() + "\n";
    }
}
