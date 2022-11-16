package processor.controller;

import processor.utils.AddMatricesHandler;
import processor.utils.InOut;
import processor.utils.Size;

import java.util.List;

public class AddMatricesController {
    public static void run() {
        Size size1 = InOut.getSize("Enter size of first matrix: ");
        if (size1 == null) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        List<List<Double>> matrix1 = InOut.getMatrix("Enter first matrix:", size1);
        if (matrix1 == null) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        Size size2 = InOut.getSize("Enter size of first matrix: ");
        if (size2 == null) {
            System.out.println("The operation cannot be performed.");
            return;
        }
        List<List<Double>> matrix2 = InOut.getMatrix("Enter first matrix:", size2);
        if (matrix2 == null) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        List<List<Double>> result = AddMatricesHandler.add(matrix1, matrix2);
        if (result == null) {
            System.out.println("The operation cannot be performed.");
            return;
        }
        InOut.printResult(result);
    }
}
