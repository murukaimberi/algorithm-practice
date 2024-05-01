package org.afrikatek.co.za.algorithmspractice.adt;

import org.afrikatek.co.za.algorithmspractice.util.StdIn;
import org.afrikatek.co.za.algorithmspractice.util.StdOut;

public class Stats {
    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<>();
        while (!StdIn.isEmpty()) {
            numbers.addItem(StdIn.readDouble());
        }
        int N = numbers.size();

        double sum = 0.0;
        for (double x : numbers) {
            sum += x;
        }

        double mean = sum / N;

        sum = 0.0;
        for (double x : numbers) {
            sum += (x - mean) * (x - mean);
        }
        double std = Math.sqrt(sum / (N - 1));
        StdOut.printf("Mean: %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);
    }
}
