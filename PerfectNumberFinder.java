/**
 * PerfectNumberFinder.java
 * Description: This program identifies and prints all perfect numbers within a specified range.
 * A perfect number is a number that is equal to the sum of its proper positive divisors.
 * The program has two modes: a fixed search from 1-200 and a user-defined search with a scalable data type.
 */

import java.util.Scanner;

public class PerfectNumberFinder {

    public static void main(String[] args) {
        // Part 1: Fixed range search (1 to 200)
        System.out.println("Perfect numbers between 1 and 200:");
        
        // Outer loop to iterate through each number from 1 to 200
        for (int number = 1; number <= 200; number++) {
            int sumOfDivisors = 0;
            
            // Inner loop to find all proper divisors and calculate their sum
            // We only need to check up to number/2 since no proper divisor can be greater than number/2
            for (int divisor = 1; divisor < number; divisor++) {
                // Check if divisor is a proper divisor of the current number
                if (number % divisor == 0) {
                    sumOfDivisors += divisor;
                }
            }
            
            // Check if the sum of proper divisors equals the original number
            if (sumOfDivisors == number) {
                System.out.println(number + " is a perfect number");
            }
        }
        
        System.out.println(); // Add a blank line for better output formatting
        
        // Part 2: Call method for user-driven search
        findPerfectNumbersUpToLimit();
    }

    /**
     * This method takes a user-specified upper limit and finds all perfect numbers up to that limit.
     * It uses the 'long' data type to handle larger numbers and prevent overflow.
     * This is important because perfect numbers can be very large (e.g., 8128, 33550336)
     * and using 'int' might cause overflow issues when dealing with large search ranges.
     */
    public static void findPerfectNumbersUpToLimit() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the upper limit for perfect number search: ");
        long upperLimit = scanner.nextLong();
        
        System.out.println("Perfect numbers up to " + upperLimit + ":");
        
        // Outer loop using long data type to handle large numbers
        for (long number = 1; number <= upperLimit; number++) {
            long sumOfDivisors = 0;
            
            // Inner loop to find all proper divisors and calculate their sum
            // Using long data type prevents integer overflow for large numbers
            for (long divisor = 1; divisor < number; divisor++) {
                // Check if divisor is a proper divisor of the current number
                if (number % divisor == 0) {
                    sumOfDivisors += divisor;
                }
            }
            
            // Check if the sum of proper divisors equals the original number
            if (sumOfDivisors == number) {
                System.out.println(number + " is a perfect number");
            }
        }
        
        scanner.close();
    }
}
