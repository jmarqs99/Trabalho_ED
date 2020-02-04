package EstruturasDeDados;

import Exceptions.ElementNotFoundException;
import java.util.Iterator;

/**
 *
 * @author Utilizador
 * @param <T>
 */
public interface GraphADT<T> {

    /**
     *
     * @param vertex
     */
    public void addVertex(T vertex);

    /**
     *
     * @param vertex
     * @throws ElementNotFoundException
     */
    public void removeVertex(T vertex) throws ElementNotFoundException;

    /**
     *
     * @param vertex1
     * @param vertex2
     * @throws ElementNotFoundException
     */
    public void addEdge(T vertex1, T vertex2) throws ElementNotFoundException;

    /**
     *
     * @param vertex1
     * @param vertex2
     * @throws ElementNotFoundException
     */
    public void removeEdge(T vertex1, T vertex2) throws ElementNotFoundException;

    /**
     *
     * @param startVertex
     * @return
     * @throws ElementNotFoundException
     */
    public Iterator iteratorBFS(T startVertex) throws ElementNotFoundException;

    /**
     *
     * @param startVertex
     * @return
     * @throws ElementNotFoundException
     */
    public Iterator iteratorDFS(T startVertex) throws ElementNotFoundException;

    /**
     *
     * @param startVertex
     * @param targetVertex
     * @return
     * @throws ElementNotFoundException
     */
    public Iterator iteratorShortestPath(T startVertex, T targetVertex) throws ElementNotFoundException;

    /**
     *
     * @return
     */
    public boolean isEmpty();

    /**
     *
     * @return
     */
    public boolean isConnected();

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
