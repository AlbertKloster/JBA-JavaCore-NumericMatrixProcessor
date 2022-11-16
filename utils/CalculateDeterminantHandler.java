package processor.utils;

import java.util.ArrayList;
import java.util.List;

public class CalculateDeterminantHandler {
    public static Double findDeterminant(List<List<Double>> matrix) {
        if (matrix.size() == 1) return matrix.get(0).get(0);
        double determinant = 0;
        int sign = 1;
        for (int j = 0; j < matrix.get(0).size(); j++) {
            determinant += sign*matrix.get(0).get(j)*findDeterminant(getMinor(matrix, 0, j));
            sign = -sign;
        }
        return determinant;
    }

    public static List<List<Double>> getMinor(List<List<Double>> matrix, int iCofactor, int jCofactor) {
        List<List<Double>> minor = new ArrayList<>();
        for (int i = 0; i < matrix.size(); i++) {
            List<Double> row = new ArrayList<>();
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (j != jCofactor)
                    row.add(matrix.get(i).get(j));
            }
            if (i != iCofactor)
                minor.add(row);
        }
        return minor;
    }
}
