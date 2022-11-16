package processor.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class SideDiagonalHandler {
    public static Function<List<List<Double>>, List<List<Double>>> transpose = (matrix) -> {
        List<List<Double>> result = new ArrayList<>();
        for (int i = matrix.size() - 1; i >= 0; i--) {
            List<Double> row = new ArrayList<>();
            for (int j = matrix.get(i).size() - 1; j >= 0; j--) {
                row.add(matrix.get(j).get(i));
            }
            result.add(row);
        }
        return result;
    };
}
