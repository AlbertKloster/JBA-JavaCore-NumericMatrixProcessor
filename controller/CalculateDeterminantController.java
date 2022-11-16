package processor.controller;

import processor.utils.CalculateDeterminantHandler;
import processor.utils.InOut;
import processor.utils.Size;

import java.util.List;

public class CalculateDeterminantController {
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

        Double result = CalculateDeterminantHandler.findDeterminant(matrix);
        if (result == null) {
            System.out.println("The operation cannot be performed.");
            return;
        }
        InOut.printResult(result);
    }
}
