package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Recursive fashion.");

        long number = 10;
        long startTime = System.nanoTime();

        System.out.println("Number ["+number+"] Fibonacci: " + fibIter(number));
        System.out.println("Finish Time: " + (System.nanoTime() - startTime) + " nanoseconds.");

        number = 20;
        startTime = System.nanoTime();
        System.out.println("Number ["+number+"] Fibonacci: " + fibIter(number));
        System.out.println("Finish Time: " + (System.nanoTime() - startTime) + " nanoseconds.");

        number = 30;
        startTime = System.nanoTime();
        System.out.println("Number ["+number+"] Fibonacci: " + fibIter(number));
        System.out.println("Finish Time: " + (System.nanoTime() - startTime) + " nanoseconds.");

        number = 40;
        startTime = System.nanoTime();
        System.out.println("Number ["+number+"] Fibonacci: " + fibIter(number));
        System.out.println("Finish Time: " + (System.nanoTime() - startTime) + " nanoseconds.");

        number = 50;
        startTime = System.nanoTime();
        System.out.println("Number ["+number+"] Fibonacci: " + fibIter(number));
        System.out.println("Finish Time: " + (System.nanoTime() - startTime) + " nanoseconds.");


        System.out.println();
        System.out.println("Iterative fashion.");
        number = 10;
        startTime = System.nanoTime();
        System.out.println("Number ["+number+"] Fibonacci: " + fibRec(number));
        System.out.println("Finish Time: " + (System.nanoTime() - startTime) + " nanoseconds.");

        number = 20;
        startTime = System.nanoTime();
        System.out.println("Number ["+number+"] Fibonacci: " + fibRec(number));
        System.out.println("Finish Time: " + (System.nanoTime() - startTime) + " nanoseconds.");

        number = 30;
        startTime = System.nanoTime();
        System.out.println("Number ["+number+"] Fibonacci: " + fibRec(number));
        System.out.println("Finish Time: " + (System.nanoTime() - startTime) + " nanoseconds.");

        number = 40;
        startTime = System.nanoTime();
        System.out.println("Number ["+number+"] Fibonacci: " + fibRec(number));
        System.out.println("Finish Time: " + (System.nanoTime() - startTime) + " nanoseconds.");

        number = 50;
        startTime = System.nanoTime();
        System.out.println("Number ["+number+"] Fibonacci: " + fibRec(number));
        System.out.println("Finish Time: " + (System.nanoTime() - startTime) + " nanoseconds.");


    }

    private static long fibIter(long number) {
        if (number <= 2) {
            return number;
        }
        long result = 0;
        long one = 1;
        long two = 1;
        for (int i = 2; i < number; i++) {
            result = one + two;
            one = two;
            two = result;
        }
        return result;
    }

    public static long fibRec(long n) {
        return n <= 1 ? n : fibRec(n - 1) + fibRec(n - 2);
    }

}