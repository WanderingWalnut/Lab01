package com.naveed.calculator;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

	    while (true) {
	        System.out.println("\nEnter operation (add, subtract, multiply, divide, pow, sqrt, log, log10, sin, cos, tan, factorial, permutation) or 'exit' to quit:");
	        String operation = scanner.next();

	        if (operation.equalsIgnoreCase("exit")) {
	            System.out.println("Exiting calculator...");
	            break;
	        }

	        // For operations requiring two inputs
	        if (!operation.equalsIgnoreCase("sqrt") &&
	            !operation.equalsIgnoreCase("log") &&
	            !operation.equalsIgnoreCase("log10") &&
	            !operation.equalsIgnoreCase("sin") &&
	            !operation.equalsIgnoreCase("cos") &&
	            !operation.equalsIgnoreCase("tan") &&
	            !operation.equalsIgnoreCase("factorial")) {
	            
	            System.out.print("Enter first number: ");
	            double num1 = scanner.nextDouble();
	            System.out.print("Enter second number: ");
	            double num2 = scanner.nextDouble();

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
	                case "pow":
	                    System.out.println("Result: " + power(num1, num2));
	                    break;
	                case "permutation":
	                	System.out.println("Result: " + permutation(num1, num2));
	                	break;
	                default:
	                    System.out.println("Invalid operation.");
	                    break;
	            }
	        } else {
	            // For operations requiring one input
	            System.out.print("Enter number: ");
	            double num = scanner.nextDouble();

	            switch (operation.toLowerCase()) {
	                case "sqrt":
	                    System.out.println("Result: " + sqrt(num));
	                    break;
	                case "log":
	                    System.out.println("Result: " + log(num));
	                    break;
	                case "log10":
	                    System.out.println("Result: " + log10(num));
	                    break;
	                case "sin":
	                    System.out.println("Result: " + sin(num));
	                    break;
	                case "cos":
	                    System.out.println("Result: " + cos(num));
	                    break;
	                case "tan":
	                    System.out.println("Result: " + tan(num));
	                    break;
	                case "factorial":
	                    // Factorial is a special case requiring an integer
	                    System.out.println("Result: " + factorial((int) num));
	                    break;
	                default:
	                    System.out.println("Invalid operation.");
	                    break;
	            }
	        }
	    }

	    scanner.close();
	}

    public static double add(double a, double b) {
        return a + b;
    }
    
    // Factorial calculation with progress display
    public static long factorial(int n) {
        if (n < 0) {
            System.out.println("Factorial of a negative number is undefined.");
            return 0;        
            }
        
        System.out.print("\rCalculating factorial: 0%"); // Shows progress bar for 1
        long result = factorialHelper(n, n);
        System.out.print("\rCalculating factorial: 100%fact\n");
        return result;
    }
    
    private static long factorialHelper(int originalNum, int num) {
    	if (num <=1) {
    		return 1; 
    	}
    	// Calculates progress and updates progress bar
    	int progress = (int) (((originalNum - num)/(double) originalNum) * 100);
    	System.out.print("\rCalculating factorial: " + progress + "%");
    	return num * factorialHelper(originalNum, num - 1);
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
    
 // Exponentiation
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    // Square root
    public static double sqrt(double number) {
        return Math.sqrt(number);
    }

    // Natural logarithm
    public static double log(double number) {
        return Math.log(number);
    }

    // Base-10 logarithm
    public static double log10(double number) {
        return Math.log10(number);
    }
    
 // Convert degrees to radians
    public static double toRadians(double angleDegrees) {
        return Math.toRadians(angleDegrees);
    }

    // Sine function
    public static double sin(double angleRadians) {
        if (angleRadians >= -Math.PI && angleRadians <= Math.PI) {
            System.out.println("The input is in radians: " + angleRadians);
        } else {
            double radians = toRadians(angleRadians);
            System.out.println("The input is in degrees, converted to radians: " + radians);
        }
        return Math.sin(angleRadians);
    }

    // Cosine function
    public static double cos(double angleRadians) {
        if (angleRadians >= -Math.PI && angleRadians <= Math.PI) {
            System.out.println("The input is in radians: " + angleRadians);
        } else {
            double radians = toRadians(angleRadians);
            System.out.println("The input is in degrees, converted to radians: " + radians);
        }
        return Math.cos(angleRadians);
    }

    // Tangent function
    public static double tan(double angleRadians) {
        if (angleRadians >= -Math.PI && angleRadians <= Math.PI) {
            System.out.println("The input is in radians: " + angleRadians);
        } else {
            double radians = toRadians(angleRadians);
            System.out.println("The input is in degrees, converted to radians: " + radians);
        }
        return Math.tan(angleRadians);
    }
    
    // Permutations function
    public static double permutation(double total, double select) {
    	double result = 1;
    	//Checks if selected items is less than total
    	if (select > total) {
    		System.out.println("Error: Selected items exceeds total items");
    		return -1;
    	}
    	//Checks if selected items is a non-negative number and array is not greater than 100
    	if (select < 0 || total > 100) {
    		System.out.println("Error: You cannot select a negative amount of items or total items cannot exceed 100");
    		return -1;
    	}
    	
    	// Base case
    	if (select == 0) {
    		return result;
    	}
    	
    	// Recursive case
    	
    	result = total * permutation(total-1, select - 1);
    	
    	return result;
    	
    }
    
    // Permutations Function without Recursion
    
    public static double perms(double total, double select) {
        double result = 1;
        // Checks if selected items is less than total
        if (select > total) {
            System.out.println("Error: Selected items exceeds total items");
            return -1;
        }
        // Checks if selected items is a non-negative number and total is not greater than 100
        if (select < 0 || total > 100) {
            System.out.println("Error: You cannot select a negative amount of items or total items cannot exceed 100");
            return -1;
        }
        
        // Base case
        if (select == 0) {
            return result;
        }
        
        // Iterative case
        for (int i = 0; i < select; i++) {
            result *= total - i;
        }
        
        return result;
    }

}