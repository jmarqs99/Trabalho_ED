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
    protected T element;
    protected ShortestPathNode<T> antecessor;
    protected Double lenght;

    public ShortestPathNode(T element, ShortestPathNode<T> antecessor,Double len) {
        this.element = element;
        this.antecessor = antecessor;
        this.lenght = len;
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

    public Double getLenght() {
        return lenght;
    }

    public void setLenght(double lenght) {
        this.lenght = lenght;
    }
    
}
