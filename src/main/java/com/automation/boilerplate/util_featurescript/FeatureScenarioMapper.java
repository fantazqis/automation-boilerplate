package com.automation.boilerplate.util_featurescript;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FeatureScenarioMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startNumber = getStartNumber(scanner);

        System.out.println("Enter Scenario (or 'exit' to quit):");
        StringBuilder scenarios = new StringBuilder(); // Store scenarios

        String scenario;
        do {
            scenario = scanner.nextLine();
            if (!scenario.isEmpty()) { // Only append non-empty scenarios
                // **Place the new code here**
                if (scenario.startsWith("Scenario: ")) {
                    scenario = scenario.substring(10).trim();
                }
                scenarios.append(scenario).append("\n");
            }
        } while (!scenario.equalsIgnoreCase("exit"));

        String allScenarios = scenarios.toString().trim(); // Remove trailing newline

        for (int i = startNumber; !allScenarios.isEmpty(); i++) {
            int indexOfNewLine = allScenarios.indexOf("\n");
            if (indexOfNewLine == -1) { // Check for empty scenario at the end
                break;
            }
            String currentScenario = allScenarios.substring(0, indexOfNewLine);
            System.out.println(String.format("T%d(\"%s\"),", i, currentScenario));
            allScenarios = allScenarios.substring(indexOfNewLine + 1).trim(); // Remove processed scenario
        }

        scanner.close();
    }

    private static int getStartNumber(Scanner scanner) {
        System.out.println("Start number:");
        int startNumber;
        try {
            startNumber = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Clear the scanner buffer
            return getStartNumber(scanner);
        }
        return startNumber;
    }
}
