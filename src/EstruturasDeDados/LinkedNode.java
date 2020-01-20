/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstruturasDeDados;

/**
 *
 * @author Utilizador
 */
public class LinkedNode<T> {

    private LinkedNode<T> next;
    private T element;

    public LinkedNode(LinkedNode<T> next, T element) {
        this.next = next;
        this.element = element;
    }

    public LinkedNode<T> getNext() {
        return next;
    }

    public T getElement() {
        return element;
    }

    public void setNext(LinkedNode<T> next) {
        this.next = next;
    }

    public void setElement(T element) {
        this.element = element;
    }

}
