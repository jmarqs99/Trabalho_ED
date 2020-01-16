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
public class ShortestPathNodeGraph<T> {

    public T element;
    public ShortestPathNodeGraph<T> antecessor;

    public ShortestPathNodeGraph(T element, ShortestPathNodeGraph<T> antecessor) {
        this.element = element;
        this.antecessor = antecessor;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public ShortestPathNodeGraph<T> getAntecessor() {
        return antecessor;
    }

    public void setAntecessor(ShortestPathNodeGraph<T> antecessor) {
        this.antecessor = antecessor;
    }

    

}
