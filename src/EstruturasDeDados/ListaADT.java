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

    /**
     *
     * @return
     * @throws EmptyCollectionException
     */
    public T removeFirst() throws EmptyCollectionException;

    /**
     *
     * @return
     * @throws EmptyCollectionException
     */
    public T removeLast() throws EmptyCollectionException;

    /**
     *
     * @param element
     * @return
     * @throws EmptyCollectionException
     * @throws ElementNotFoundException
     */
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException;

    /**
     *
     * @return
     */
    public T first();

    /**
     *
     * @return
     */
    public T last();
    
    /**
     *
     * @param target
     * @return
     */
    public boolean contains(T target);

    /**
     *
     * @return
     */
    public boolean isEmpty();

    /**
     *
     * @return
     */
    public int size();

    @Override
    public Iterator<T> iterator();

    /**
     *
     * @return
     */
    @Override
    public String toString();
}
