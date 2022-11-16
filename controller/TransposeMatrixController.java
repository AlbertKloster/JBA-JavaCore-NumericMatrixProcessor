package processor.controller;

import processor.utils.*;

import java.util.List;
import java.util.function.Function;

public class TransposeMatrixController {
    public static void run() {
        Integer choice = InOut.getChoiceTranspose();
        if (choice == null) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        switch (choice) {
            case 1 -> print(MainDiagonalHandler.transpose);
            case 2 -> print(SideDiagonalHandler.transpose);
            case 3 -> print(VerticalLineHandler.transpose);
            case 4 -> print(HorizontalLineHandler.transpose);
        }
    }

    private static List<List<Double>> getMatrix() {
        Size size = InOut.getSize("Enter matrix size: ");
        if (size == null) return null;

        return InOut.getMatrix("Enter matrix:", size);
    }

    private static void print(Function<List<List<Double>>, List<List<Double>>> handler) {
        List<List<Double>> matrix = getMatrix();
        if (matrix == null) {
            System.out.println("The operation cannot be performed.");
        } else {
            InOut.printResult(handler.apply(matrix));
        }
    }

}
