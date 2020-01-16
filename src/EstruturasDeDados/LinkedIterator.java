/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstruturasDeDados;

import java.util.Iterator;

/**
 *
 * @author Utilizador
 * @param <T>
 */
public class LinkedIterator<T> implements Iterator {

    DoubleNode<T> current;

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
