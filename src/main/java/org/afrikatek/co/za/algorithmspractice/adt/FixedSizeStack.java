package org.afrikatek.co.za.algorithmspractice.adt;

import java.util.Iterator;

/**
 * This is an implementation of a fixed size Stack that grows as
 * the elements are being added and shrinks when the elements go down.
 * @param <Item> type of the stack
 */
public class FixedSizeStack<Item> implements Iterable<Item> {
    private int N = 0;
    private Item[] a;

    public FixedSizeStack(int max) {
        a = (Item[]) new Object[max];
    }

    public void resize(int max) {
        // adjust here to make sure the capacity of the array is not fixed and grows with the
        // elements of the Stack.
        // Move stack of size N <= max to a new array of size max.
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        /**
         * We check whether the array has capacity to add new items by checking if the size of the stack
         * is equal to the array size a.
         */
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N++] = item;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null; // avoid loitering
        /**
         * We check whether the check whether the elements of the stack are a
         * quarter of the array and resize the array to a half of the original size.
         * This means that the array will approximately have a double the space at a given
         * time.
         */
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
