package EstruturasDeDados;

import Exceptions.EmptyCollectionException;

/**
 * Interface que contrata uma queue
 * 
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
 * @param <T> generico
 */
public interface QueueADT<T> {

    /**
     *
     * Adiciona um elemento à parte traseira desta fila.
     *
     * @param element o elemento a ser adicionado ao a parte traseira desta fila
     */
    public void enqueue(T element);

    /**
     *
     * Remove e retorna o elemento na frente do essa fila.
     *
     * @return o elemento na frente desta fila
     * @throws EmptyCollectionException caso a coleção esteja vazia
     */
    public T dequeue() throws EmptyCollectionException;

    /**
     *
     * Retorna sem remover o elemento na frente do essa fila.
     *
     * @return o primeiro elemento nesta fila
     * @throws Exceptions.EmptyCollectionException caso a coleção esteja vazia
     */
    public T first() throws EmptyCollectionException;

    /**
     * Retorna true se essa fila não contiver elementos
     *
     * @return true se esta fila estiver vazia
     */
    public boolean isEmpty();

    /**
     *
     *
     * Retorna o número de elementos nesta fila.
     *
     * @return a representação inteira do tamanho dessa fila
     */
    public int size();

    @Override
    public String toString();
}
