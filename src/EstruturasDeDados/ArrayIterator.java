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
public class ArrayIterator<T> implements Iterator {

    private final int count;
    private final T[] item;
    private int current;

    public ArrayIterator(int size, T[] colletion) {
        count = size;
        current = 0;
        item = colletion;
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

    @Override
    public void remove() {
        Iterator.super.remove(); //To change body of generated methods, choose Tools | Templates.
    }

}
