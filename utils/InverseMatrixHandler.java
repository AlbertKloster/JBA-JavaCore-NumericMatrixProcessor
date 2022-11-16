package processor.utils;

import java.util.ArrayList;
import java.util.List;

public class InverseMatrixHandler {
    public static List<List<Double>> getInverseMatrix(List<List<Double>> matrix) {
        List<List<Double>> inverseMatrix = new ArrayList<>();
        Double determinant = CalculateDeterminantHandler.findDeterminant(matrix);
        if (determinant == null) {
            System.out.println("The operation cannot be performed.");
            return null;
        }
        List<List<Double>> cofactorMatrix = CofactorMatrixHandler.getCofactorMatrix(matrix);
        List<List<Double>> transposeCofactorMatrix = MainDiagonalHandler.transpose.apply(cofactorMatrix);
        for (List<Double> rowTCM: transposeCofactorMatrix) {
            List<Double> row = new ArrayList<>();
            for (Double e: rowTCM) {
                row.add(e / determinant);
            }
            inverseMatrix.add(row);
        }
        return inverseMatrix;
    }
}
