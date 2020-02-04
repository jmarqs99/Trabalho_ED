package EstruturasDeDados;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import java.util.Iterator;

/**
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
 * @param <T> generico
 */
public interface ListaADT<T> extends Iterable<T> {

    /**
     *
     * Remove e retorna o primeiro elemento desta lista.
     *
     * @return o primeiro elemento desta lista
     * @throws EmptyCollectionException lança exceção caso coleção esteja vazia
     */
    public T removeFirst() throws EmptyCollectionException;

    /**
     *
     * Remove e retorna o último elemento desta lista
     *
     * @return Remove e retorna o último elemento desta lista
     * @throws EmptyCollectionException lança exceção caso coleção esteja vazia
     */
    public T removeLast() throws EmptyCollectionException;

    /**
     *
     * Remove e retorna o elemento especificado dessa lista.
     *
     * @param element
     * @return elemento o elemento a ser removido da lista
     * @throws EmptyCollectionException lança exceção caso coleção esteja vazia
     * @throws ElementNotFoundException lança exceção caso o elemento não seja
     * encontrado
     */
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException;

    /**
     *
     * Retorna uma referência ao primeiro elemento nesta lista.
     *
     * @return uma referência ao primeiro elemento nesta lista
     */
    public T first();

    /**
     * Retorna uma referência ao ultimo elemento nesta lista.
     *
     * @return uma referência ao ultimo elemento nesta lista
     */
    public T last();

    /**
     *
     * Retorna true se esta lista contiver o destino especificado elemento.
     *
     * @param target o alvo que está sendo procurado na lista
     * @return true se a lista contiver esse elemento
     */
    public boolean contains(T target);

    /**
     *
     * Retornará true se esta lista não contiver elementos.
     *
     * @return true se esta lista não contiver elementos
     */
    public boolean isEmpty();

    /**
     *
     * Retorna o número de elementos nesta lista
     *
     * @return a representação inteira do número de elementos nesta lista
     */
    public int size();

    @Override
    public Iterator<T> iterator();

    @Override
    public String toString();
}
