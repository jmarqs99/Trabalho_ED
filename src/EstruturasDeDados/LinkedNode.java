package EstruturasDeDados;

/**
 *
 * @author Utilizador
 * @param <T>
 */
public class LinkedNode<T> {

    private LinkedNode<T> next;
    private T element;

    /**
     *
     * @param next
     * @param element
     */
    public LinkedNode(LinkedNode<T> next, T element) {
        this.next = next;
        this.element = element;
    }

    /**
     *
     * @return
     */
    public LinkedNode<T> getNext() {
        return next;
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
     * @param next
     */
    public void setNext(LinkedNode<T> next) {
        this.next = next;
    }

    /**
     *
     * @param element
     */
    public void setElement(T element) {
        this.element = element;
    }

}
