package EstruturasDeDados;

/**
 * Classe um nó duplamente ligado
 * 
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
 * @param <T> generico
 */
public class DoubleNode<T> {

    private T element;
    protected DoubleNode<T> next;
    private DoubleNode<T> prev;

    /**
     * Construtor sem parametros
     */
    public DoubleNode() {
        this.element = null;
        this.next = null;
        this.prev = null;
    }

    /**
     * Construtor parameterizado
     *
     * @param element elemento node
     */
    public DoubleNode(T element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }

    /**
     * Construtor parameterizado
     *
     * @param element elemento node
     * @param next elemento seguinte
     * @param prev elemento anterior
     */
    public DoubleNode(T element, DoubleNode<T> next, DoubleNode<T> prev) {
        this.element = element;
        this.next = next;
        this.prev = prev;
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
     * @param element elemento a definir
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * Retorna o elemento seguinte
     *
     * @return o elemento seguinte
     */
    public DoubleNode<T> getNext() {
        return next;
    }

    /**
     * Define o elemento seguinte
     *
     * @param next o elemento seguinte
     */
    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    /**
     * Retorna o elemento anterior
     *
     * @return o elemento anterior
     */
    public DoubleNode<T> getPrev() {
        return prev;
    }

    /**
     * Define o elemento anterior
     *
     * @param prev o elemento anterior
     */
    public void setPrev(DoubleNode<T> prev) {
        this.prev = prev;
    }

}
