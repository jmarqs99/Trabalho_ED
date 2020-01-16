/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstruturasDeDados;

import Exceptions.EmptyCollectionException;
import java.util.Arrays;

/**
 *
 * @author Utilizador
 */
public class LinkedStack<T> implements StackADT<T> {

    private LinkedNode<T> top;
    private int count = 0;

    public LinkedStack() {
        this.top = null;
    }

    @Override
    public void push(T element) {
        LinkedNode<T> newNode = new LinkedNode<T>(top, element);
        top = newNode;
        count++;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if (count == 0) {
            throw new EmptyCollectionException();
        }
        T result = top.getElement();
        top = top.getNext();
        count--;
        return result;
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if (count == 0) {
            throw new EmptyCollectionException();
        } else {
            return top.getElement();
        }
    }

    @Override
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return count;
    }

}
