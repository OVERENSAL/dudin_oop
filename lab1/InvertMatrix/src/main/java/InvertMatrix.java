import java.io.*;

public class InvertMatrix {
    public static final String MISSING_INPUT_FILE = "Unable to find the input file.";
    public static final String USAGE_METHOD = "Usage: InvertMatrix.exe <input.txt>";
    public static final String FILE_READING_ERROR = "Cannot create a matrix from the provided data. " +
            "Check whether the data in the file is correct. The file must contain 9 numbers in the form of a matrix.";
    public static final String MATRIX_HAS_NOT_INVERSE = "The matrix has a determinant equal to 0. Therefore, it does not have an inverse matrix.";
    public static final int MATRIX_SIZE = 3;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println(MISSING_INPUT_FILE);
            System.out.println(USAGE_METHOD);
        } else {
            double[][] matrix = readMatrix(args);
            if (matrix != null) {
                Matrix matrixObject = new Matrix();
                if (matrixObject.getDeterminant(matrix) != 0) {
                    matrix = matrixObject.getInvertMatrix(matrix);
                    matrixObject.showMatrix(matrix);
                } else {
                    System.out.println(MATRIX_HAS_NOT_INVERSE);
                }
            }
        }
    }

    public static double[][] readMatrix(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
            double[][] matrix = new double[MATRIX_SIZE][MATRIX_SIZE];
            String str = "";
            int row = 0;
            int column = 0;
            while((str = reader.readLine()) != null) {
                for(String part : str.split("\\s")) {
                    try {
                        matrix[row][column] = Double.parseDouble(part);//проверять на 9 чисел
                    } catch (NumberFormatException n) {
                        System.out.println(FILE_READING_ERROR);
                        return null;
                    }
                    column++;
                }
                if (column != MATRIX_SIZE) {
                    throw new NumberFormatException();
                }
                column = 0;
                row++;
            }
            if (row != MATRIX_SIZE) {
                throw new NumberFormatException();
            }
            return matrix;
        } catch (NumberFormatException n) {
            System.out.println(FILE_READING_ERROR);
        } catch (IOException e) {
            System.out.println(MISSING_INPUT_FILE);
            System.out.println(USAGE_METHOD);
        }
        return null;
    }
}
