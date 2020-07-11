import java.io.*;
import java.util.ArrayList;

public class LoopRequests {
    public final String USAGE_METHOD = "Usage: Main.jar <input file>.";
    public final String FILE_NOT_FOUND = "File not found.";
    ShapesCreator creator = new ShapesCreator();
    ArrayList<Shape> Shapes = new ArrayList<>();

    public void loopRequests(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(args[0])))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                analysisShapeInfo(line);
            }
        } catch (Exception e) {
            System.out.println(FILE_NOT_FOUND + "\n" + USAGE_METHOD);
        }
    }

    private void analysisShapeInfo(String line) {
        String[] info = line.split("\\s");
        if (info.length > 1) {
            createShape(info);
        }
    }

    private void createShape(String[] info) {
        switch (info[0]) {
            case "line":
                Shape lineSegment = creator.createLineSegment(info);
                if (lineSegment != null) {
                    Shapes.add(lineSegment);
                }
                break;
            case "triangle":
                Shape triangle = creator.createTriangle(info);
                if (triangle != null) {
                    Shapes.add(triangle);
                }
                break;
            case "rectangle":
                Shape rectangle = creator.createRectangle(info);
                if (rectangle != null) {
                    Shapes.add(rectangle);
                }
                break;
            case "circle":
                Shape circle = creator.createCircle(info);
                if (circle != null) {
                    Shapes.add(circle);
                }
                break;
        }
    }
}
