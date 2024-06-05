package org.afrikatek.co.za.algorithmspractice.sorting;

import org.afrikatek.co.za.algorithmspractice.util.StdOut;
import org.afrikatek.co.za.algorithmspractice.util.StdRandom;
import org.afrikatek.co.za.algorithmspractice.util.Stopwatch;

import java.util.Arrays;

public class SortCompare {
    public static double time(String algorithm, Comparable[] a) {
        Stopwatch timer = new Stopwatch();
        if (algorithm.equalsIgnoreCase("Insertion")) {
            InsertionSort.sort(a);
        }
        if (algorithm.equalsIgnoreCase("Selection")) {
            SelectionSort.sort(a);
        }
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String algorithm, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N; j++) {
                a[j] = StdRandom.uniform();
            }
            total += time(algorithm, a);
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        String algorithm1 = args[0];
        String algorithm2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(algorithm1, N, T);
        double t2 = timeRandomInput(algorithm2, N, T);
        StdOut.printf("For %d random Doubles\n %s is ", N, algorithm1);
        StdOut.printf("%.1f times faster than %s\n", t2/t1, algorithm2);
    }
}
