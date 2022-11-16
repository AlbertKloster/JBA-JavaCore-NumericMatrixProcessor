package processor.controller;

import processor.utils.InOut;
import processor.utils.MultiplyMatricesByConstantHandler;
import processor.utils.Size;

import java.util.List;

public class MultiplyMatrixByConstantController {
    public static void run() {
        Size size = InOut.getSize("Enter size of matrix: ");
        if (size == null) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        List<List<Double>> matrix = InOut.getMatrix("Enter matrix:", size);
        if (matrix == null) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        Double constant = InOut.getConstant();
        if (constant == null) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        List<List<Double>> result = MultiplyMatricesByConstantHandler.multiply(matrix, constant);
        if (result == null) {
            System.out.println("The operation cannot be performed.");
            return;
        }
        InOut.printResult(result);
    }
}
