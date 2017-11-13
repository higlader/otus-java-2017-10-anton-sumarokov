package MyAList;

import java.util.*;
import java.util.function.UnaryOperator;

/**
 * Created by anton on 02.11.17.
 */
public class MyArrayList<T> implements List<T> {
    private static final int CAPACITY = 10;
    private   T[] data = (T[])new Object[CAPACITY];
    private int size;

    public static int getCAPACITY() {
        return CAPACITY;
    }

    public T[] getData() {
        return data;
    }

    public int getSize() {
        return size;
    }

    public  MyArrayList() {
    }

    public MyArrayList(int size) {
        this.size = size;
    }

    private void ensureCapacity() {
        if (size >= data.length) {
            T[] newData = (T[])(new Object[size * 2 + 1]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }


    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public void sort(Comparator<? super T> c) {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public Spliterator<T> spliterator() {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public boolean add(T t) {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public T get(int index) {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public void add(int index, T element) {
        ensureCapacity();

        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];

        data[index] = element;
        size++;
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Invalid operation.");
    }

}

