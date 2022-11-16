package processor.controller;

import processor.utils.InOut;
import processor.utils.InverseMatrixHandler;
import processor.utils.MultiplyMatricesByConstantHandler;
import processor.utils.Size;

import java.util.List;

public class InverseMatrixController {
    public static void run() {
        Size size = InOut.getSize("Enter matrix size: ");
        if (size == null) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        List<List<Double>> matrix = InOut.getMatrix("Enter matrix:", size);
        if (matrix == null) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        List<List<Double>> result = InverseMatrixHandler.getInverseMatrix(matrix);
        if (result == null) {
            System.out.println("The operation cannot be performed.");
            return;
        }
        InOut.printResult(result);

    }
}
