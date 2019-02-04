package com.company;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Enter in n
        int n = input.nextInt();
        int values[] = new int[n]; // Array to hold each value within the Fibonacci sequence.
        values[0] = 0; // First value in the Fibonacci sequence.
        values[1] = 1; // Second value in the Fibonacci sequence.

        System.out.println("Recursive: ");
        long recStart = System.nanoTime(); // Start time.
        fiboSeriesRec(n, values);// Recursively calculate Fibonacci up to nth term.
        long recFinish = System.nanoTime(); // Finish time.
        displayFiboSeries(values); // Display the Fibonacci sequence.
        displayTimeElapsed(recStart, recFinish);

        System.out.println("Iterative: "); // Note that the array doesn't technically need to be reset. We're essentially "overwriting" the data with the same data.
        long iteStart = System.nanoTime(); // Start time.
        fiboSeriesIte(n, values); // Iteratively calculate Fibonacci up to nth term
        long iteFinish = System.nanoTime(); // Finish time.
        displayFiboSeries(values); // Display the Fibonacci sequence.
        displayTimeElapsed(iteStart, iteFinish);
    }

    private static void displayTimeElapsed(long start, long finish) {
        long elapsed = finish - start; // Calculate the time elapsed.
        System.out.println("Time Elapsed: " + elapsed);
    }

    public static void fiboSeriesRec(int n, int[] values) {
        int count = 2; // Start at 2 to skip 0 and 1 as the first values which we assign manually rather than using if statements to check our count for the first 2 steps.

        fiboSeriesRec(n, count, values);
    }

    public static void fiboSeriesRec(int n, int count, int values[])
    {
        if (count < n) // Continue until we reach the nth term
        {
            values[count] = values[count - 1] + values[count - 2]; // Current value equals the previous two values within the sequence.
            fiboSeriesRec(n, count + 1, values);
        }
    }

    public static void fiboSeriesIte(int n, int[] values)
    {
        for (int i = 2; i < n; i++) // Start at step two, to avoid adding negative numbers.
        {
            values[i] = values[i-1] + values[i-2]; // Current value equals the previous two values within the sequence.
        }
    }

    public static void displayFiboSeries(int[] values)
    {
        if (values.length > 0) // Check to see if the array is empty.
        {
            for(int i = 0; i < values.length; i++)
            {
                System.out.print(values[i] + " "); // Print out all values within the sequence.
            }
        }
    }
}
