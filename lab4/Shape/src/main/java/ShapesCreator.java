import java.awt.Color;

public class ShapesCreator {
    private final int HEX_BASE = 16;
    private final int BIN_BASE = 2;
    private final int COLOR_LENGTH = 7;
    private final int START_RED_COLOR_INDEX = 1;
    private final int START_GREEN_COLOR_INDEX = 3;
    private final int START_BLUE_COLOR_INDEX = 5;
    private final String IS_NOT_COLOR = "The passed parameter is not a color.";
    private final String NON_CORRECT_DATA_INPUT = "Invalid data entered.";

    public LineSegment createLineSegment(String[] info) {
        try {
            Point startPoint = new Point(Double.parseDouble(info[1]), Double.parseDouble(info[2]));
            Point endPoint = new Point(Double.parseDouble(info[3]), Double.parseDouble(info[4]));
            Color color = convertStringToColor(info[5]);
            if (color == null) {
                return null;
            }
            return new LineSegment(startPoint, endPoint, color);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException n) {
            System.out.println(NON_CORRECT_DATA_INPUT);
            return null;
        }
    }

    public Triangle createTriangle(String[] info) {
        try {
            Point vertex1 = new Point(Double.parseDouble(info[1]), Double.parseDouble(info[2]));
            Point vertex2 = new Point(Double.parseDouble(info[3]), Double.parseDouble(info[4]));
            Point vertex3 = new Point(Double.parseDouble(info[5]), Double.parseDouble(info[6]));
            Color outlineColor = convertStringToColor(info[7]);
            Color fillColor = convertStringToColor(info[8]);
            if (outlineColor == null || fillColor == null) {
                return null;
            }
            return new Triangle(vertex1, vertex2, vertex3, outlineColor, fillColor);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException n) {
            System.out.println(NON_CORRECT_DATA_INPUT);
            return null;
        }
    }

    public Rectangle createRectangle(String[] info) {
        try {
            Point leftTop = new Point(Double.parseDouble(info[1]), Double.parseDouble(info[2]));
            double width = Double.parseDouble(info[3]);
            double height = Double.parseDouble(info[4]);
            Color outlineColor = convertStringToColor(info[5]);
            Color fillColor = convertStringToColor(info[6]);
            if (outlineColor == null || fillColor == null) {
                return null;
            }
            return new Rectangle(leftTop, width, height, outlineColor, fillColor);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException n) {
            System.out.println(NON_CORRECT_DATA_INPUT);
            return null;
        }
    }

    public Circle createCircle(String[] info) {
        try {
            Point center = new Point(Double.parseDouble(info[1]), Double.parseDouble(info[2]));
            double radius = Double.parseDouble(info[3]);
            Color outlineColor = convertStringToColor(info[4]);
            Color fillColor = convertStringToColor(info[5]);
            if (outlineColor == null || fillColor == null) {
                return null;
            }
            return new Circle(center, radius, outlineColor, fillColor);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException n) {
            System.out.println(NON_CORRECT_DATA_INPUT);
            return null;
        }
    }

    private boolean isHexNumber(String str) {
        try {
            Integer.parseInt(str, HEX_BASE);
        } catch (NumberFormatException n) {
            return false;
        }
        return true;
    }

    public Color convertStringToColor(String color) {
        try {
            if (color.length() == COLOR_LENGTH && color.charAt(0) == '#' && isHexNumber(color.substring(START_RED_COLOR_INDEX, COLOR_LENGTH))) {
                int r = Integer.valueOf(color.substring(START_RED_COLOR_INDEX, START_GREEN_COLOR_INDEX), HEX_BASE);
                int g = Integer.valueOf(color.substring(START_GREEN_COLOR_INDEX, START_BLUE_COLOR_INDEX), HEX_BASE);
                int b = Integer.valueOf(color.substring(START_BLUE_COLOR_INDEX, COLOR_LENGTH), HEX_BASE);
                return new Color (r, g, b);
            }
        } catch (Exception e) {
            System.out.println(IS_NOT_COLOR);
        }
        return null;
    }

    public String convertColorToString(Color color) {
        String hex = Integer.toHexString(color.getRGB()).substring(BIN_BASE);
        if (hex.length() < 6) {
            hex = "0" + hex;
        }
        return "#" + hex;
    }

    public String roundDouble(double value) {
        return String.format("%.3f", value);
    }
}
