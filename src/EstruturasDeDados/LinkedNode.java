package EstruturasDeDados;

/**
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
 * @param <T> generico
 */
public class LinkedNode<T> {

    private LinkedNode<T> next;
    private T element;

    /**
     * Construtor parameterizado
     * @param next elemento seguinte
     * @param element elemento atual
     */
    public LinkedNode(LinkedNode<T> next, T element) {
        this.next = next;
        this.element = element;
    }

    /**
     * Retorna o proximo elemento
     * @return o proximo elemento
     */
    public LinkedNode<T> getNext() {
        return next;
    }

    /**
     * Retorna o elemento
     * @return o elemento
     */
    public T getElement() {
        return element;
    }

    /**
     * Define o proximo elemento 
     * @param next o proximo elemento
     */
    public void setNext(LinkedNode<T> next) {
        this.next = next;
    }

    /**
     * Define o elemento atual
     * @param element o elemento atual
     */
    public void setElement(T element) {
        this.element = element;
    }

}
