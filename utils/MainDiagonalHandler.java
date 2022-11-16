package processor.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MainDiagonalHandler {
    public static Function<List<List<Double>>, List<List<Double>>> transpose = (matrix) -> {
        List<List<Double>> result = new ArrayList<>();
        for (int i = 0; i < matrix.size(); i++) {
            List<Double> row = new ArrayList<>();
            for (int j = 0; j < matrix.get(i).size(); j++) {
                row.add(matrix.get(j).get(i));
            }
            result.add(row);
        }
        return result;
    };
}
