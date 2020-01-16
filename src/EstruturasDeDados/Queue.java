/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstruturasDeDados;

import Exceptions.EmptyCollectionException;

/**
 *
 * @author Utilizador
 * @param <T>
 */
public class Queue<T> implements QueueADT<T> {

    private LinearNode<T> rear;
    private LinearNode<T> front;
    private int count;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.count = 0;
    }

    @Override
    public void enqueue(T element) {
        LinearNode<T> node = new LinearNode<>(null, element);

        if (isEmpty()) {
            front = node;
        } else {
            rear.setNext(node);
        }
        rear = node;

        count++;
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if (count == 0) {
            throw new EmptyCollectionException("Vazio");
        }

        T oldFront = front.getElement();
        front = front.getNext();

        count--;

        return oldFront;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (count == 0) {
            throw new EmptyCollectionException("Vazio");
        }
        return front.getElement();
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        String result = "To String:";
        LinearNode<T> node = front;
        for (int i = 0; i < size(); i++) {
            result = result + "\n" + node.getElement();
            node = node.getNext();
        }
        return result;
    }

}
