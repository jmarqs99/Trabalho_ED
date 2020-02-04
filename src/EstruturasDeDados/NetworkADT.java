package EstruturasDeDados;

import Exceptions.ElementNotFoundException;

/**
 *
 * @author Utilizador
 * @param <T>
 */
public interface NetworkADT<T> extends GraphADT<T> {

    /**
     *
     * @param vertex1
     * @param vertex2
     * @param weight
     * @throws ElementNotFoundException
     */
    public void addEdge(T vertex1, T vertex2, double weight) throws ElementNotFoundException;

    /**
     *
     * @param vertex1
     * @param vertex2
     * @return
     * @throws ElementNotFoundException
     */
    public double shortestPathWeight(T vertex1, T vertex2) throws ElementNotFoundException;

}
