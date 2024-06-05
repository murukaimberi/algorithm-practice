package org.afrikatek.co.za.algorithmspractice.sorting;

import org.afrikatek.co.za.algorithmspractice.util.In;
import org.afrikatek.co.za.algorithmspractice.util.StdOut;

public class SelectionSort {
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (Comparable comparable : a) {
            StdOut.print(comparable + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }

    /**
     * Sort a[] into increasing order.
     * @param a array to be compared
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            // Exchange a[i] with smallest entry in a[i+1...N].
            int min = i; // index of the minimal entry.
            for (int j = 1; j < i + 1; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exchange(a, i, min);
        }
    }
}
