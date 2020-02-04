package EstruturasDeDados;

import java.util.Iterator;

/**
 *
 * @author Utilizador
 * @param <T>
 */
public class LinkedIterator<T> implements Iterator {

    private DoubleNode<T> current;

    /**
     *
     * @param list
     */
    public LinkedIterator(LinkedList<T> list) {
        current = list.head;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Object next() {
        T data = current.getElement();
        current = current.getNext();
        return data;
    }

}
