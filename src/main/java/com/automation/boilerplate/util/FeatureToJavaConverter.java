package com.automation.boilerplate.util;
/*
IntelliJ IDEA 2023.3.6 (Community Edition)
Build #IC-233.15026.9, built on March 21, 2024
@Author kiyandark a.k.a. Muhammad Irfan Syaifur Rizal Wiratama
Java Developer
Created on 27/05/2024 2:58
@Last Modified 27/05/2024 2:58
Version 1.0
*/

import java.util.Scanner;

public class FeatureToJavaConverter {
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

    static int print = 0;
    private static String convertFeature(String input) {

        String[] words = input.split(" ");
        if (words.length < 3) {
            return ""; // Empty string for invalid format
        }

        String description = words[0].toLowerCase();
        String action = "";

        for (int i = 1; i < words.length; i++) {
            action += words[i] + " ";
        }

        action = action.trim();



        switch (description) {

            case "when":
                print++;
                return "@When(\"" + action + "\")\npublic void " + convertActionToMethodName(action) + "() {\nGlobalFunction.delay(Constants.TIMEOUT_DELAY);\nSystem.out.println(\"" + print + "\");\n\textentTest.log(LogStatus.PASS, \"" + action + "\");\n}\n";
            case "and":
                print++;
                return "@And(\"" + action + "\")\npublic void " + convertActionToMethodName(action) + "() {\nGlobalFunction.delay(Constants.TIMEOUT_DELAY);\nSystem.out.println(\"" + print + "\");\n\textentTest.log(LogStatus.PASS, \"" + action + "\");\n}\n";
            case "then":
                print++;
                return "@Then(\"" + action + "\")\npublic void " + convertActionToMethodName(action) + "() {\nGlobalFunction.delay(Constants.TIMEOUT_DELAY);\nSystem.out.println(\"" + print + "\");\n\textentTest.log(LogStatus.PASS, \"" + action + "\");\n}\n";
            default:
                return ""; // Empty string for invalid scenario type
        }
    }

    private static String convertActionToMethodName(String action) {
        return action.toLowerCase().replaceAll(" ", "_");
    }
}
