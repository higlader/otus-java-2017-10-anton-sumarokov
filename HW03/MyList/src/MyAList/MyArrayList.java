package MyAList;

import java.util.*;
import java.util.function.UnaryOperator;

/**
 * Created by anton on 02.11.17.
 */
public class MyArrayList<T> implements List<T> {

    private static  int SIZE = 10;

    int size;
    private Object[] array;

    public MyArrayList() {
        this.size = SIZE;
    }

    public MyArrayList(int capacity) {
        array = new Object[capacity];
        size = 0;
    }


    public MyArrayList(Collection<? extends T> c) {
        array = c.toArray();
        size = array.length;
    }



    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public void sort(Comparator<? super T> c) {
        ListIterator<T> i = this.listIterator();
        Object[] a = this.toArray();
        Arrays.sort(a, (Comparator) c);
        for (Object ignored : a) {
            i.next();
        }
        array = a;
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
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public boolean add(T t) {
        int source = array.length - size;
        if(source < 1) {
            array = Arrays.copyOf(array, size + 1);
        }

        array[size++] = t;

        return true;
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
        Object[] collectionArray = c.toArray();
        int length = collectionArray.length;
        int index = size;
        int source = array.length - size;

        if(length > source) {
            size = array.length + (length - source);
            array = Arrays.copyOf(array, size);
        }else{
            size += length;
        }

        System.arraycopy(collectionArray, 0, array, index, length);
        return length > 0;
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
        return (T) array[index];
    }

    @Override
    public T set(int index, T element) {

        T value = (T) array[index];
        array[index] = element;
        return value;
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException("Invalid operation.");
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

    public static <T> void copy (List<? super T> dest, List<? extends T> src) {
        dest.addAll(src);
    }
}
