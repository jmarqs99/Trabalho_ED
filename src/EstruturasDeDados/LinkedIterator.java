package EstruturasDeDados;

import java.util.Iterator;

/**
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
 * @param <T> generico
 */
public class LinkedIterator<T> implements Iterator {

    private DoubleNode<T> current;

    /**
     * Construtor parameterizado
     *
     * @param list LinkedList para definir o elemento atual
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
