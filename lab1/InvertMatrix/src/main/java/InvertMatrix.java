import java.io.*;

public class InvertMatrix {
    public static final String MISSING_INPUT_FILE = "Unable to find the input file.";
    public static final String USAGE_METHOD = "Usage: InvertMatrix.exe <input.txt>";
    public static final String FILE_READING_ERROR = "Cannot create a matrix from the provided data. " +
            "Check whether the data in the file is correct. The file must contain 9 numbers in the form of a matrix.";
    public static final int MATRIX_SIZE = 3;

    public static void main(String[] args) {

    }

    public static double[][] readMatrix(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
            double[][] matrix = new double[MATRIX_SIZE][MATRIX_SIZE];
            String str = "";
            int row = 0;
            int column = 0;
//            while((str = reader.readLine()) != null) {
//                for(String part : str.split("\\s")) {
//                    try {
//                        matrix[row][column] = Double.parseDouble(part);//проверять на 9 чисел
//                    } catch (NumberFormatException n) {
//                        System.out.println(FILE_READING_ERROR);
//                        return null;
//                    }
//                    column++;
//                }
//                column = 0;
//            }
            return matrix;
        } catch (IOException e) {
            System.out.println(MISSING_INPUT_FILE);
            System.out.println(USAGE_METHOD);
        }
        return null;
    }
}
