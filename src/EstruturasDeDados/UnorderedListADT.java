/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstruturasDeDados;

import Exceptions.ElementNotFoundException;

/**
 *
 * @author Utilizador
 * @param <T>
 */
public interface UnorderedListADT<T> {

    public void addFront(T element);

    public void addRear(T element);

    public void addAfter(T element, T prevElement) throws ElementNotFoundException;
}
