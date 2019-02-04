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

        fiboSeriesRec(n, values);// Recursively calculate Fibonacci up to nth term
        //fiboSeriesIte(n, values); // Iteratively calculate Fibonacci up to nth term
        displayFiboSeries(values); // Display the Fibonacci sequence.
    }

    public static void fiboSeriesRec(int n, int[] values) {
        int count = 2;

        fiboSeriesRec(n, count, values);
    }

    public static void fiboSeriesRec(int n, int count, int values[])
    {
        if (count < n) // Continue until n
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
                System.out.println(values[i]); // Print out all values within the sequence.
            }
        }
    }
}
