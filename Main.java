package converter;

import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean exit = false;

        while (!exit) {
            String command = getCommand();
            if (command.equals("/exit")) {
                exit = true;
            } else if (command.matches("\\d+\\s+\\d+")) {
                startConversion(command);
            }
        }
    }

    private static void startConversion(String command) {
        String[] inputs = command.split("\\s+");
        String sourceBase = inputs[0];
        String targetBase = inputs[1];
        while (true) {
            System.out.printf("Enter number in base %s to convert to base %s (To go back type /back) ", sourceBase, targetBase);
            String input = scanner.nextLine();
            if (input.equals("/back")) {
                break;
            } else {
                String[] number = input.split("\\.");
                ConverterToDecInt converterToDecInt = new ConverterToDecInt(number[0], sourceBase);
                ConverterFromDecInt converterFromDecInt = new ConverterFromDecInt(converterToDecInt.convert(), targetBase);
                System.out.print("Conversion result: ");
                System.out.print(converterFromDecInt.convert());
                if (number.length > 1) {
                    ConverterToDecFraction converterToDecFraction = new ConverterToDecFraction(number[1], sourceBase);
                    ConverterFromDecFraction converterFromDecFraction = new ConverterFromDecFraction(converterToDecFraction.convert(), targetBase);
                    System.out.println("." + converterFromDecFraction.convert());
                } else {
                    System.out.println();
                }
            }
        }
    }

    private static String getCommand() {
        System.out.print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ");
        return scanner.nextLine();
    }
}
