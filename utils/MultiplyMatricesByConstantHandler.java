package processor.utils;

import java.util.ArrayList;
import java.util.List;

public class MultiplyMatricesByConstantHandler {

    public static List<List<Double>> multiply(List<List<Double>> matrix, double constant) {
        List<List<Double>> result = new ArrayList<>();
        for (List<Double> row : matrix) {
            List<Double> resultRow = new ArrayList<>();
            for (Double e : row) {
                resultRow.add(e * constant);
            }
            result.add(resultRow);
        }
        return result;
    }
}
