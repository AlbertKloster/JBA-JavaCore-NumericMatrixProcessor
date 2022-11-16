package processor.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class HorizontalLineHandler {
    public static Function<List<List<Double>>, List<List<Double>>> transpose = (matrix) -> {
        List<List<Double>> result = new ArrayList<>();
        for (int i = matrix.size() - 1; i >= 0; i--) {
            List<Double> row = new ArrayList<>();
            for (int j = 0; j < matrix.get(i).size(); j++) {
                row.add(matrix.get(i).get(j));
            }
            result.add(row);
        }
        return result;
    };
}
