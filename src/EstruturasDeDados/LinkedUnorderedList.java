package EstruturasDeDados;

import Exceptions.ElementNotFoundException;

/**
 * Classe que representa uma lista não ordenada de forma ligada
 * 
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
 * @param <T> generico
 */
public class LinkedUnorderedList<T> extends LinkedList<T> implements UnorderedListADT<T> {


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
