package EstruturasDeDados;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import java.util.Iterator;

/**
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
 * @param <T> generico
 */
public class ArrayList<T> implements ListaADT<T>, Iterable<T> {

    final int DEFAULT_SIZE = 1000;
    protected int rear;
    protected T[] list;

    /**
     * Construtor sem parametros
     */
    public ArrayList() {
        this.list = (T[]) new Object[DEFAULT_SIZE];
        this.rear = 0;
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        T result = list[0];
        rear--;

        for (int i = 0; i < size(); i++) {
            list[i] = list[i + 1];
        }
        return result;
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        T result = list[rear - 1];

        list[rear] = null;
        rear--;

        return result;
    }

    @Override
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        int pos = -1;

        if (isEmpty()) {
            throw new EmptyCollectionException();
        }

        for (int i = 0; i < size(); i++) {
            if (list[i] == element) {
                pos = i;
            }
        }
        if (pos == -1) {
            throw new ElementNotFoundException();
        }

        for (; pos < size(); pos++) {
            list[pos] = list[pos + 1];
        }

        rear--;
        return list[pos];

    }

    @Override
    public T first() {
        return list[0];
    }

    @Override
    public T last() {
        return list[rear - 1];
    }

    @Override
    public boolean contains(T target) {
        boolean found = false;

        for (int i = 0; i < size(); i++) {

            if (list[i] == target) {
                found = true;
            }
        }
        return found;
    }

    @Override
    public boolean isEmpty() {
        return (rear == 0);
    }

    @Override
    public int size() {
        return rear;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator itr = new ArrayIterator(rear, list);

        return itr;
    }

    private class ArrayIterator<T> implements Iterator {

        private final int count;
        private final T[] item;
        private int current;

        public ArrayIterator(int size, T[] collection) {
            this.count = size;
            this.item = collection;
            this.current = 0;
        }

        @Override
        public boolean hasNext() {
            return (current < count);
        }

        @Override
        public Object next() {
            current++;
            return item[current - 1];
        }
    }

    @Override
    public String toString() {
        String result = "To String:";

        for (int i = 0; i < rear; i++) {
            result = result + "\n" + list[i];
        }
        return result;
    }

}
