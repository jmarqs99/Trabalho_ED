package EstruturasDeDados;

import Exceptions.EmptyCollectionException;

/**
 *
 * @author Utilizador
 * @param <T>
 */
public interface QueueADT<T> {

    /**
     *
     * @param element
     */
    public void enqueue(T element);

    /**
     *
     * @return
     * @throws EmptyCollectionException
     */
    public T dequeue() throws EmptyCollectionException;

    /**
     *
     * @return
     * @throws EmptyCollectionException
     */
    public T first() throws EmptyCollectionException;

    /**
     *
     * @return
     */
    public boolean isEmpty();

    /**
     *
     * @return
     */
    public int size();

    /**
     *
     * @return
     */
    @Override
    public String toString();
}
