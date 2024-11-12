package com.automation.boilerplate.util_featurescript;
/*
IntelliJ IDEA 2023.3.6 (Community Edition)
Build #IC-233.15026.9, built on March 21, 2024
@Author kiyandark a.k.a. Muhammad Irfan Syaifur Rizal Wiratama
Java Developer
Created on 27/05/2024 20:05
@Last Modified 27/05/2024 20:05
Version 1.0
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Unused_DataOutlineGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOnes;
        do {
            System.out.print("Enter how many number 1: ");
            numOnes = scanner.nextInt();
        } while (numOnes <= 0);

        ArrayList<int[]> exceptions = new ArrayList<>();
        while (true) { // Loop until user exits
            System.out.print("Is there exception: (yes/no) ");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("no")) {
                break;
            }

            // Get exception details
            System.out.print("Where: ");
            int exceptionIndex = scanner.nextInt();
            System.out.print("How many data: ");
            int exceptionValue = scanner.nextInt();

            exceptions.add(new int[]{exceptionIndex, exceptionValue});
        }

        // Print the sequence with exceptions
        printSequence(numOnes, exceptions);

        scanner.close();
    }

    public static void printSequence(int numOnes, ArrayList<int[]> exceptions) {
        for (int i = 1; i <= numOnes; i++) {
            boolean isException = false;
            for (int[] exception : exceptions) {
                if (i == exception[0]) {
                    System.out.print(exception[1] + ", ");
                    isException = true;
                    break;
                }
            }
            if (!isException) {
                System.out.print("1, ");
            }
        }
        System.out.println();
    }
}
