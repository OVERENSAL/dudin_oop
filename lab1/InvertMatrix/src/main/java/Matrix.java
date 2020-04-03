import java.util.Arrays;

public class Matrix {

    public double getDeterminant(final double[][] matrix) {
        if (matrix.length == 2) {
            return (matrix[0][0] * matrix[1][1] -
                    matrix[0][1] * matrix[1][0]);
        }
        else if (matrix.length == 3) {
            return (matrix[0][0] * matrix[1][1] * matrix[2][2] +
                    matrix[0][1] * matrix[1][2] * matrix[2][0] +
                    matrix[0][2] * matrix[1][0] * matrix[2][1] -
                    matrix[0][2] * matrix[1][1] * matrix[2][0] -
                    matrix[0][1] * matrix[1][0] * matrix[2][2] -
                    matrix[0][0] * matrix[1][2] * matrix[2][1]);
        }
        return 0;
    }

    public double[][] getSubMatrix(final double[][] matrix, int ignoreRow, int ignoreColumn) {
        double[][] subMatrix = new double[matrix.length - 1][matrix.length - 1];
        int currentRow = 0;
        int currentColumn = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (i == ignoreRow) {
                continue;
            }
            for (int j = 0; j < matrix.length; j++) {
                if (j == ignoreColumn) {
                    continue;
                }
                subMatrix[currentRow][currentColumn] = matrix[i][j];
                currentColumn++;
            }
            currentColumn = 0;
            currentRow++;
        }

        return subMatrix;
    }

    public double[][] transposeMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j =  i + 1; j < matrix.length; j++) {
                double temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        return matrix;
    }

    public double[][] getMatrixFromSubMatrix(double[][] matrix) {
        double[][] algebraicExtensionsMatrix = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                algebraicExtensionsMatrix[i][j] = Math.pow(-1, i + j) * getDeterminant(getSubMatrix(matrix, i, j));
            }
        }

        return algebraicExtensionsMatrix;
    }

    public double[][] getInvertMatrix(double[][] matrix) {
        double[][] algebraicExtensionsMatrix = getMatrixFromSubMatrix(matrix);
        double determinant = getDeterminant(matrix);
        for (int i = 0; i < algebraicExtensionsMatrix.length; i++) {
            for (int j = 0; j < algebraicExtensionsMatrix.length; j++) {
                algebraicExtensionsMatrix[i][j] = Math.round(1/determinant * algebraicExtensionsMatrix[i][j] * 1000) /1000.0 ;
            }
        }
        return transposeMatrix(algebraicExtensionsMatrix);
    }

    public void showMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static String toString(double[][] a) {
        if (a == null)
            return "null";
        int iMax = a.length - 1;
        if (iMax == -1)
            return "[]";
        StringBuilder b = new StringBuilder();
        for (double[] doubles : a) {
            b.append('[');
            for (int j = 0; j < a.length; j++) {
                b.append(doubles[j]);
                if (j == a.length - 1)
                    b.append("]\r\n");
                else
                    b.append(", ");
            }
        }
        return b.toString();
    }
}
