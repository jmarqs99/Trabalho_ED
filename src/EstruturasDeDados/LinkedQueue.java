package EstruturasDeDados;

import Exceptions.EmptyCollectionException;

/**
 * Classe que representa uma queue de forma ligada
 * 
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
 * @param <T> generico
 */
public class LinkedQueue<T> implements QueueADT<T> {

    private LinkedNode<T> front;
    private LinkedNode<T> rear;
    private int count;

    /**
     * Construtor sem parametros
     */
    public LinkedQueue() {
        this.front = null;
        this.rear = null;
        this.count = 0;
    }

    @Override
    public void enqueue(T element) {
        LinkedNode<T> newNode = new LinkedNode<>(null, element);

        if (isEmpty()) {
            front = newNode;
        } else {
            rear.setNext(newNode);
        }

        rear = newNode;

        count++;
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Queue vazia!");
        }

        LinkedNode<T> result = front;

        front = front.getNext();

        count--;

        return result.getElement();
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Queue vazia!");
        }
        return front.getElement();
    }

    @Override
    public boolean isEmpty() {
        return (front == null);
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        String result = "To string:\n";
        LinkedNode<T> iteratioNode = front;
        
        for (int i = 0; i < size(); i++) {
            result = result + iteratioNode.getElement() + "\n";
            iteratioNode = iteratioNode.getNext();
        }
        return result;
    }

}
