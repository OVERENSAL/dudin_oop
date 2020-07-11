import java.util.ArrayList;

public class ShapeProcessing {

    public String getMaxAreaFromShapes(ArrayList<Shape> shapes) {
        int targetIndex = 0;
        double maxArea = 0;
        double currArea = 0;
        for (int i = 0; i < shapes.size(); i++) {
            currArea = shapes.get(i).getArea();
            if (currArea > maxArea) {
                maxArea = currArea;
                targetIndex = i;
            }
        }
        return shapes.get(targetIndex).toString();
    }

    public String getMinPerimeterFromShapes(ArrayList<Shape> shapes) {
        int targetIndex = 0;
        double maxPerimeter = 0;
        double currPerimeter = 0;
        for (int i = 0; i < shapes.size(); i++) {
            currPerimeter = shapes.get(i).getPerimeter();
            if (currPerimeter < maxPerimeter) {
                maxPerimeter = currPerimeter;
                targetIndex = i;
            }
        }
        return shapes.get(targetIndex).toString();
    }
}
