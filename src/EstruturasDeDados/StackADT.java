package EstruturasDeDados;

import Exceptions.EmptyCollectionException;

/**
 *
 * @author Utilizador
 * @param <T>
 */
public interface StackADT<T> {

    /**
     *
     * @param element
     */
    public void push(T element);

    /**
     *
     * @return
     * @throws EmptyCollectionException
     */
    public T pop() throws EmptyCollectionException;

    /**
     *
     * @return
     * @throws EmptyCollectionException
     */
    public T peek() throws EmptyCollectionException;

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
