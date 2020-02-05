package EstruturasDeDados;

/**
 * Classe que representa um nó simples
 * 
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
 * @param <T> generico
 */
public class LinearNode<T> {

    private LinearNode<T> next;
    private T element;

    /**
     * Construtor parameterizado
     *
     * @param next proximo elemento
     * @param element elemento atual
     */
    public LinearNode(LinearNode<T> next, T element) {
        this.next = next;
        this.element = element;
    }

    /**
     * Retorna o elemento seguinte
     *
     * @return o elemento seguinte
     */
    public LinearNode<T> getNext() {
        return next;
    }

    /**
     * Define o elemento seguinte
     *
     * @param next o elemento seguinte
     */
    public void setNext(LinearNode<T> next) {
        this.next = next;
    }

    /**
     * Retorna o elemento
     *
     * @return o elemento
     */
    public T getElement() {
        return element;
    }

    /**
     * Define o elemento
     *
     * @param element o elemento a definir
     */
    public void setElement(T element) {
        this.element = element;
    }

}
