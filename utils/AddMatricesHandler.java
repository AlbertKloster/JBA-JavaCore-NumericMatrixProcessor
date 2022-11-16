package processor.utils;

import java.util.ArrayList;
import java.util.List;

public class AddMatricesHandler {
    public static List<List<Double>> add(List<List<Double>> matrix1, List<List<Double>> matrix2) {

        if (matrix1.size() != matrix2.size() || matrix1.get(0).size() != matrix2.get(0).size()) {
            return null;
        }

        List<List<Double>> result = new ArrayList<>();
        for (int i = 0; i < matrix2.size(); i++) {
            List<Double> row = new ArrayList<>();
            for (int j = 0; j < matrix2.get(i).size(); j++) {
                row.add(matrix1.get(i).get(j) + matrix2.get(i).get(j));
            }
            result.add(row);
        }
        return result;

    }
}
