package processor.utils;

import java.util.ArrayList;
import java.util.List;

public class MultiplyMatricesHandler {

    public static List<List<Double>> multiply(List<List<Double>> matrix1, List<List<Double>> matrix2) {
        List<List<Double>> result = new ArrayList<>();
            for (int i = 0; i < matrix1.size(); i++) {
                List<Double> resultRow = new ArrayList<>();
                for (int k = 0; k < matrix2.get(0).size(); k++) {
                    double sum = 0;
                    for (int j = 0; j < matrix1.get(i).size(); j++) {
                        sum += matrix1.get(i).get(j) * matrix2.get(j).get(k);
                    }
                    resultRow.add(sum);
                }
                result.add(resultRow);
            }
        return result;
    }
}
