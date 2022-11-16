package processor;

import processor.controller.*;
import processor.utils.InOut;

public class Main {
    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            Integer choice = InOut.getChoiceMain();
            if (choice == null) {
                System.out.println("The operation cannot be performed.");
                continue;
            }
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> AddMatricesController.run();
                case 2 -> MultiplyMatrixByConstantController.run();
                case 3 -> MultiplyMatricesController.run();
                case 4 -> TransposeMatrixController.run();
                case 5 -> CalculateDeterminantController.run();
                case 6 -> InverseMatrixController.run();
            }
        }

    }
}
