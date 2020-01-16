/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstruturasDeDados;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import java.util.Iterator;

/**
 *
 * @author Utilizador
 * @param <T>
 */
public interface ListaADT<T> extends Iterable<T> {

    public T removeFirst() throws EmptyCollectionException;

    public T removeLast() throws EmptyCollectionException;

    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException;

    public T first();

    public T last();
    
    public boolean contains(T target);

    public boolean isEmpty();

    public int size();

    @Override
    public Iterator<T> iterator();

    @Override
    public String toString();
}
