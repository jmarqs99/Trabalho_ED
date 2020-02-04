package EstruturasDeDados;

import Exceptions.EmptyCollectionException;

/**
 *
 * @author Utilizador
 * @param <T>
 */
public class LinkedStack<T> implements StackADT<T> {

    private LinkedNode<T> top;
    private int count;

    /**
     *
     */
    public LinkedStack() {
        this.top = null;
        this.count = 0;
    }

    /**
     *
     * @param element
     */
    @Override
    public void push(T element) {
        LinkedNode<T> newNode = new LinkedNode<>(top, element);
        top = newNode;
        count++;
    }

    /**
     *
     * @return @throws EmptyCollectionException
     */
    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty() == true) {
            throw new EmptyCollectionException("ERRO:Sem elementos na Stack!");
        }
        T result = top.getElement();
        top = top.getNext();
        count--;
        return result;
    }

    /**
     *
     * @return @throws EmptyCollectionException
     */
    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty() == true) {
            throw new EmptyCollectionException("ERRO:Sem elementos na Stack!");
        }
        return top.getElement();
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public int size() {
        return count;
    }

    public String toString() {
        String result = "";
        LinkedNode<T> iterationNode = top;
        for (int i = 0; i < count; i++) {
            result = result + iterationNode.getElement().toString() + "\n";
            iterationNode = iterationNode.getNext();
        }
        return result;
    }
}
