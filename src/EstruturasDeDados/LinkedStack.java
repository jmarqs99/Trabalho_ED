package EstruturasDeDados;

import Exceptions.EmptyCollectionException;

/**
 * Classe que representa uma Stack de forma ligada
 * 
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
 * @param <T> generico
 */
public class LinkedStack<T> implements StackADT<T> {

    private LinkedNode<T> top;
    private int count;

    /**
     * Construtor sem parametros
     */
    public LinkedStack() {
        this.top = null;
        this.count = 0;
    }

    @Override
    public void push(T element) {
        LinkedNode<T> newNode = new LinkedNode<>(top, element);

        top = newNode;

        count++;
    }

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

    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty() == true) {
            throw new EmptyCollectionException("A stack não tem elementos!\n");
        }
        return top.getElement();
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
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
