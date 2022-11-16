package processor.utils;

import java.util.ArrayList;
import java.util.List;

public class CofactorMatrixHandler {
    public static List<List<Double>> getCofactorMatrix(List<List<Double>> matrix) {
        List<List<Double>> cofactorMatrix = new ArrayList<>();

        int iSine = 1;
        for (int i = 0; i < matrix.size(); i++) {
            List<Double> row = new ArrayList<>();
            int jSine = 1;
            for (int j = 0; j < matrix.get(i).size(); j++) {
                row.add(iSine * jSine * CalculateDeterminantHandler.findDeterminant(
                        CalculateDeterminantHandler.getMinor(matrix, i, j)
                ));
                jSine = -jSine;
            }
            iSine = -iSine;
            cofactorMatrix.add(row);
        }
        return cofactorMatrix;
    }
}
