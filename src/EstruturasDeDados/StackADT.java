package EstruturasDeDados;

import Exceptions.EmptyCollectionException;

/**
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
 * @param <T> genérico
 */
public interface StackADT<T> {

    /**
     *
     * Adiciona um elemento ao topo desta pilha
     *
     * @param element elemento elemento a ser empurrado para a pilha
     */
    public void push(T element);

    /**
     *
     * Remove e retorna o elemento superior dessa pilha.
     *
     * @return elemento removido da parte superior da pilha
     * @throws Exceptions.EmptyCollectionException lança exceção caso coleção
     * esteja vazia
     */
    public T pop() throws EmptyCollectionException;

    /**
     *
     * Retorna sem remover o elemento superior desta pilha.
     *
     * @return elemento no topo da pilha
     * @throws Exceptions.EmptyCollectionException lança exceção caso coleção
     * esteja vazia
     */
    public T peek() throws EmptyCollectionException;

    /**
     *
     * Retorna true se essa pilha não contém elementos.
     *
     * @return booleano se esta pilha está vazia ou não
     */
    public boolean isEmpty();

    /**
     *
     * Retorna o número de elementos nesta pilha
     *
     * @return int número de elementos nesta pilha
     */
    public int size();

    @Override
    public String toString();
}
