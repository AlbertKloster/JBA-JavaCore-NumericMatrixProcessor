package processor.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InOut {
    static final Scanner SC = new Scanner(System.in);

    public static Integer getChoiceMain() {
        System.out.print("""
                1. Add matrices
                2. Multiply matrix by a constant
                3. Multiply matrices
                4. Transpose matrix
                5. Calculate a determinant
                6. Inverse matrix
                0. Exit
                Your choice:\s
                """);
        String input = SC.nextLine();
        if (!input.matches("[0-6]"))
            return null;
        return Integer.parseInt(input);
    }

    public static Integer getChoiceTranspose() {
        System.out.print("""
                1. Main diagonal
                2. Side diagonal
                3. Vertical line
                4. Horizontal line
                Your choice:\s
                """);
        String input = SC.nextLine();
        if (!input.matches("[1-4]"))
            return null;
        return Integer.parseInt(input);
    }

    public static Size getSize(String text) {
        System.out.print(text);
        String input = SC.nextLine();
        if (!input.matches("[0-9]+\s+[0-9]+"))
            return null;
        String[] data = input.split("\s+");
        return new Size(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
    }

    public static Double getConstant() {
        System.out.print("Enter constant: ");
        String input = SC.nextLine();

        if (isNotDouble(input))
            return null;

        return Double.parseDouble(input);
    }

    public static List<List<Double>> getMatrix(String text, Size size) {
        int m = size.getM();
        int n = size.getN();
        System.out.println(text);
        List<List<Double>> matrix = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Double> row = new ArrayList<>();
            String[] input = SC.nextLine().split("\s+");
            if (input.length < n)
                return null;
            for (int j = 0; j < n; j++) {
                if (isNotDouble(input[j]))
                    return null;
                row.add(Double.parseDouble(input[j]));
            }
            matrix.add(row);
        }
        return matrix;
    }

    public static void printResult(List<List<Double>> result) {
        System.out.println("The result is:");
        result.forEach(row -> {
            row.forEach(e -> {
                System.out.printf("%s ", getStringFromDouble(e));
            });
            System.out.println();
        });
        System.out.println();
    }

    public static void printResult(Double result) {
        System.out.println("The result is:");
        System.out.println(getStringFromDouble(result));
        System.out.println();
    }

    private static boolean isNotDouble(String input) {
        return !input.matches("-?[0-9]+([.][0-9]+)*");
    }

    private static String getStringFromDouble(double number) {
        NumberFormat numberFormat = new DecimalFormat("##.####");
        return numberFormat.format(number);
    }

}
