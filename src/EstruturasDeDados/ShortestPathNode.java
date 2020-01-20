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
public class ShortestPathNode<T> {

    public T element;
    public ShortestPathNode<T> antecessor;
    public Double length;

    public ShortestPathNode(T element, ShortestPathNode<T> antecessor, Double length) {
        this.element = element;
        this.antecessor = antecessor;
        this.length = length;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public ShortestPathNode<T> getAntecessor() {
        return antecessor;
    }

    public void setAntecessor(ShortestPathNode<T> antecessor) {
        this.antecessor = antecessor;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

}
