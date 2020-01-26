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
public class LinkedQueue<T> implements QueueADT<T> {

    private LinkedNode<T> front;
    private LinkedNode<T> rear;
    private int count;

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
