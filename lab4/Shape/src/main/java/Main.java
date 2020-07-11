public class Main {
    private static final String MAX_AREA = "The shape with the largest area:";
    private static final String MIN_PERIMETER = "The shape with the smallest perimeter:";
    public static void main(String[] args) {
        ShapeProcessing process = new ShapeProcessing();
        LoopRequests requests = new LoopRequests();
        requests.loopRequests(args);
        if (!requests.Shapes.isEmpty()) {
            System.out.println(MAX_AREA);
            System.out.println(process.getMaxAreaFromShapes(requests.Shapes));
            System.out.println(MIN_PERIMETER);
            System.out.println(process.getMinPerimeterFromShapes(requests.Shapes));
        }
    }
}
