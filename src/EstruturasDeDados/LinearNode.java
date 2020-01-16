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
public class LinearNode<T> {

    private LinearNode<T> next;
    private T element;

    public LinearNode(LinearNode<T> next, T element) {
        this.next = next;
        this.element = element;
    }

    public LinearNode() {
    }

    public LinearNode<T> getNext() {
        return next;
    }

    public void setNext(LinearNode<T> next) {
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

}
