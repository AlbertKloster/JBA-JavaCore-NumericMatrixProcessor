package processor.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class VerticalLineHandler {
    public static Function<List<List<Double>>, List<List<Double>>> transpose = (matrix) -> {
        List<List<Double>> result = new ArrayList<>();
        for (int i = 0; i < matrix.size(); i++) {
            List<Double> row = new ArrayList<>();
            for (int j = matrix.get(i).size() - 1; j >= 0; j--) {
                row.add(matrix.get(i).get(j));
            }
            result.add(row);
        }
        return result;
    };
}
