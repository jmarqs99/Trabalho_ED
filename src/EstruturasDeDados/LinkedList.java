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
public class LinkedList<T> implements ListaADT<T>, Iterable<T> {

    int count = 0;
    protected DoubleNode<T> head;
    protected DoubleNode<T> tail;

    /**
     * Construtor parameterizado
     *
     * @param head elemento cabeça
     * @param tail elemento cauda
     */
    public LinkedList(DoubleNode<T> head, DoubleNode<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    /**
     * Construtor sem parametros
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (size() == 0) {
            throw new EmptyCollectionException();
        }
        
        T result = head.getElement();
        head = head.getNext();
        
        count--;

        return result;
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        if (size() == 0) {
            throw new EmptyCollectionException();
        }
        T result = tail.getElement();
        
        tail = tail.getPrev();
        tail.setNext(null);
        
        count--;

        return result;
    }

    @Override
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (size() == 0) {
            throw new EmptyCollectionException();
        }
        if (contains(element) == false) {
            throw new ElementNotFoundException();
        }
        DoubleNode current = head;
        DoubleNode prev = null;
        
        T temp = null;

        do {
            if (current.getElement() == element) {
                current.setElement(temp);
                
                if (prev == null) {
                    head.setNext(head);
                    head.setPrev(null);
                } else {
                    prev.setNext(current.getNext());
                }
            }
            prev = current;
            current.setNext(current);
        } while (current != null);

        return temp;
    }

    @Override
    public T first() {
        return head.getElement();
    }

    @Override
    public T last() {
        return tail.getElement();
    }

    @Override
    public boolean contains(T target) {
        DoubleNode atual = head;

        while (atual != null) {
            if (atual.getElement().equals(target)) {
                return true;
            }
            atual = atual.getNext();
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator itr = new LinkedIterator(this);

        return itr;
    }

    @Override
    public String toString() {
        String result = "To String:";
        DoubleNode<T> node = head;
        
        for (int i = 0; i < size(); i++) {
            result = result + "\n" + node.getElement();
            node = node.getNext();
        }
        return result;
    }

}
