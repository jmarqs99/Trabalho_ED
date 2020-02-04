package EstruturasDeDados;

/**
 *
 * @author Utilizador
 * @param <T>
 */
public class DoubleNode<T> {

    private T element;
    protected DoubleNode<T> next;
    private DoubleNode<T> prev;

    /**
     *
     */
    public DoubleNode() {
        this.element = null;
        this.next = null;
        this.prev = null;
    }

    /**
     *
     * @param element
     */
    public DoubleNode(T element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }

    /**
     *
     * @param element
     * @param next
     * @param prev
     */
    public DoubleNode(T element, DoubleNode<T> next, DoubleNode<T> prev) {
        this.element = element;
        this.next = next;
        this.prev = prev;
    }

    /**
     *
     * @return
     */
    public T getElement() {
        return element;
    }

    /**
     *
     * @param element
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     *
     * @return
     */
    public DoubleNode<T> getNext() {
        return next;
    }

    /**
     *
     * @param next
     */
    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    /**
     *
     * @return
     */
    public DoubleNode<T> getPrev() {
        return prev;
    }

    /**
     *
     * @param prev
     */
    public void setPrev(DoubleNode<T> prev) {
        this.prev = prev;
    }

}
