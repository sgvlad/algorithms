package com.vladgstoian.math;

/**
 * Calculate n!
 *
 * @author Vlad Stoian (msg DAVID GmbH)
 * @since 07/10/2021 15:43
 */
public class Factorial
{
    public static void main(String[] args)
    {
        double number = 15;
        System.out.println(factorial(number));
    }

    public static double factorial(double number)
    {
        if (number == 1)
        {
            return number;
        }
        return number * factorial(number - 1);
    }
}
