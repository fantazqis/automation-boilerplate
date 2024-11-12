package com.automation.boilerplate.util_featurescript;


import java.util.Scanner;

public class ScenarioMapperToHooks {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder output = new StringBuilder();

        System.out.println("Enter feature steps (or 'exit' to quit):");

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            String convertedStep = convertFeature(input);
            if (!convertedStep.isEmpty()) {
                output.append(convertedStep + "\n");
            }
        }

        if (output.length() > 0) {
            System.out.println(output.toString());
        } else {
            System.out.println("No valid feature steps entered.");
        }

        scanner.close();
    }

    private static String convertFeature(String line) {
        StringBuilder output = new StringBuilder();

        int startIndex = line.indexOf('"');
        int endIndex = line.lastIndexOf('"');
        if (startIndex != -1 && endIndex != -1 && endIndex > startIndex) {
            String content = line.substring(startIndex + 1, endIndex);
            output.append("/*").append(content).append("*/ 1,");
        }

        return output.toString();
    }
}
