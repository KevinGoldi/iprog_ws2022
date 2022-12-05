package first;

import java.util.Iterator;

/**
 * MySortedList provides a list of sorted elements.
 * An Iterator can be used to visit all elements in increasing order
 */
public class MySortedList<T extends Object &
        Comparable<? super T>> implements Iterable<T> { // wild cards
    private T[] data; // array containing the actual data
    private int size; // also position of next element

    /**
     * Creates and returns new empty MySortedList with capacity 1
     */
    @SuppressWarnings("unchecked")
    public MySortedList() { // Constructor
        this.size = 0;
        this.data = (T[]) new Object[1];
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
