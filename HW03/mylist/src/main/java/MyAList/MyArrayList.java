package MyAList;

import java.util.*;
import java.util.function.UnaryOperator;

/**
 * Created by anton on 02.11.17.
 */
public class MyArrayList<T> implements List<T> {
    private static  int CAPACITY = 10;
    private   Object[] data;
    private int size;

    public MyArrayList() {
        this(CAPACITY);
    }

    public MyArrayList(Collection<? extends T> c) {
        data =  c.toArray();
        size = data.length;
    }

    public MyArrayList(int capacity) {
        data = new Object[capacity];
        size = 0;
    }

    private void ensureCapacity() {
        if (size >= data.length) {
            Object[] newData = (new Object[size * 2 + 1]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        dest.addAll(src);
    }

    public static <T> void sort(List<T> list, Comparator<? super T> c) {
        list.sort(c);
    }

    @Override
    public void sort(Comparator<? super T> c) {
        ListIterator<T> i = this.listIterator();
        Object[] a = this.toArray();
        Arrays.sort(a, (Comparator) c);
        for (Object ignored : a) {
            i.next();
        }
        data = a;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() <= 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>(0);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data, this.size());
    }

    @Override
    public boolean add(T t) {
        int available = data.length - size;
        if(available < 1) {
            data = Arrays.copyOf(data, size + 1);
        }

        data[size++] = t;

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Object[] collectionArray = c.toArray();
        int length = collectionArray.length;
        int position = size;
        int available = data.length - size;

        if(length > available) {
            size = data.length + (length - available);
            data = Arrays.copyOf(data, size);
        }else{
            size += length;
        }

        System.arraycopy(collectionArray, 0, data, position, length);
        return length > 0;
    }

    @Override
    public T get(int index) {
        return (T) data[index];
    }

    @Override
    public T set(int index, T element) {
        T value = (T) data[index];
        data[index] = element;
        return value;
    }

    @Override
    public void add(int index, T element) {
        ensureCapacity();

        for(int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];

        data[index] = element;
        size++;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new MyIterator<>(0);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new MyIterator<>(index);
    }


    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    private class MyIterator<E> implements ListIterator<E> {

        int current;
        int last = -1;

        public MyIterator(int index) {
            super();
            current = index;
        }

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public E next() {
            last = current;
            E result = null;
            if(current <= (size() - 1)){
                result = (E) data[current++];
            }
            return result;
        }

        @Override
        public boolean hasPrevious() {
            throw new UnsupportedOperationException("Invalid operation.");
        }

        @Override
        public E previous() {
            throw new UnsupportedOperationException("Invalid operation.");
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException("Invalid operation.");
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException("Invalid operation.");
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }

        @Override
        public void set(E e) {
            MyArrayList.this.set(last, (T) e);
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException("Invalid operation.");
        }
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
    public List<T> subList(int fromIndex, int toIndex) {
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
    public boolean addAll(int index, Collection<? extends T> c) {
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
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public Spliterator<T> spliterator() {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        throw new UnsupportedOperationException("Invalid operation.");
    }
}

