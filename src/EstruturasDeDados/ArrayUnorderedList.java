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
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {

    @Override
    public void addFront(T element) {
        if (!this.isEmpty()) {
            T temp[] = (T[]) new Object[DEFAULT_SIZE + 1];
            for (int i = size(); i > 0; i--) {
                list[i] = list[i - 1];
            }

            list = temp;

        }

        list[0] = element;
        rear++;
    }

    @Override
    public void addRear(T element) {
        list[rear] = element;
        rear++;
    }

    @Override
    public void addAfter(T element, T prevElement) throws ElementNotFoundException {
        int pos = -1;

        for (int i = 0; i < size(); i++) {
            if (list[i] == prevElement) {
                pos = i + 1;
                i = size();
            }
        }

        if (pos == -1) {
            throw new ElementNotFoundException();
        }

        if (list[pos] == null) {
            list[pos] = element;

        } else {
            for (int i = size(); i > pos; i--) {
                list[i] = list[i - 1];
            }
            list[pos] = element;
        }

        rear++;
    }

}
