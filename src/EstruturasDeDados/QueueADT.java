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
 */
public interface QueueADT<T> {

    public void enqueue(T element);

    public T dequeue() throws EmptyCollectionException;

    public T first() throws EmptyCollectionException;

    public boolean isEmpty();

    public int size();

    @Override
    public String toString();
}
