/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstruturasDeDados;

/**
 *
 * @author Utilizador
 * @param <T>
 */
public class DoubleNode<T> {

    private T element;
    DoubleNode<T> next;
    private DoubleNode<T> prev;

    public DoubleNode() {
        this.element = null;
        this.next = null;
        this.prev = null;
    }

    public DoubleNode(T element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }

    public DoubleNode(T element, DoubleNode<T> next, DoubleNode<T> prev) {
        this.element = element;
        this.next = next;
        this.prev = prev;
    }
    

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public DoubleNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoubleNode<T> prev) {
        this.prev = prev;
    }

}
