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
public class LinkedUnorderedList<T> extends LinkedList<T> implements UnorderedListADT<T> {

    public LinkedUnorderedList() {
    }

    @Override
    public void addToFront(T element) {
        DoubleNode node = new DoubleNode(element);
        node.setNext(head);
        node.setPrev(null);
        if (head != null) {
            head.setPrev(node);
        }
        head = node;
        count++;
    }

    @Override
    public void addToRear(T element) {
        DoubleNode node = new DoubleNode(element);
        if (head == null) {
            head = tail = node;
        }
        node.next = null;
        DoubleNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = node;
        count++;
    }

    @Override
    public void addAfter(T element, T prevElement) throws ElementNotFoundException {
        if (!contains(prevElement)) {
            throw new ElementNotFoundException("Elemento não existe!");
        }
        DoubleNode node = new DoubleNode(element);
        DoubleNode current = head;

        while (current != null) {
            if (current.getElement() == prevElement) {
                node.setNext(current.getNext());
                current.setNext(node);
            }
            current = current.getNext();
        }
        count++;
    }
}
