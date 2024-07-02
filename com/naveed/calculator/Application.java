package com.naveed.calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // Parse CLI arguments or wait for user input
        if (args.length > 0) {
            // Process CLI Arguments
            System.out.println("Processing CLI Arguments...");

            String operation = args[0];
            if (operation.equalsIgnoreCase("factorial")) {
                if (args.length == 2) {
                    int number = Integer.parseInt(args[1]);
                    System.out.println("Result: " + factorial(number));
                } else {
                    System.out.println("Factorial operation requires exactly one argument");
                }
            } else {
                if (args.length == 3) {
                    double num1 = Double.parseDouble(args[1]);
                    double num2 = Double.parseDouble(args[2]);
                    processOperation(operation, num1, num2);
                } else {
                    System.out.println("Operation requires exactly 2 arguments");
                }
            }
        } else {
            // No CLI arguments, asks for user input
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter operation (e.g. add, subtract, multiply, divide, factorial):");
            String operation = scanner.next();

            if (operation.equalsIgnoreCase("factorial")) {
                System.out.println("Enter a number:");
                int number = scanner.nextInt();
                System.out.println("Result: " + factorial(number));
            } else {
                System.out.println("Enter first number:");
                double num1 = scanner.nextDouble();
                System.out.println("Enter second number:");
                double num2 = scanner.nextDouble();
                processOperation(operation, num1, num2);
            }
        }
    }

    // Define methods for calculations
    public static void processOperation(String operation, double num1, double num2) {
        switch (operation.toLowerCase()) {
            case "add":
                System.out.println("Result: " + add(num1, num2));
                break;
            case "subtract":
                System.out.println("Result: " + subtract(num1, num2));
                break;
            case "multiply":
                System.out.println("Result: " + multiply(num1, num2));
                break;
            case "divide":
                System.out.println("Result: " + divide(num1, num2));
                break;
            default:
                System.out.println("Invalid operation.");
                break;
        }
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double factorial(int n) {
        if (n < 0) {
            System.out.println("Factorial of a negative number is undefined.");
            return Double.NaN;
        }
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: a number is not divisible by 0");
            return Double.NaN;
        }
        return a / b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }
}
