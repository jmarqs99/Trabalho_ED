package EstruturasDeDados;

/**
 *
 * @author Utilizador
 * @param <T>
 */
public class LinearNode<T> {

    private LinearNode<T> next;
    private T element;

    /**
     *
     * @param next
     * @param element
     */
    public LinearNode(LinearNode<T> next, T element) {
        this.next = next;
        this.element = element;
    }

    /**
     *
     * @return
     */
    public LinearNode<T> getNext() {
        return next;
    }

    /**
     *
     * @param next
     */
    public void setNext(LinearNode<T> next) {
        this.next = next;
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

}
