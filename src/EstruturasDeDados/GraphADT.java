/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstruturasDeDados;

import Exceptions.ElementNotFoundException;
import java.util.Iterator;

/**
 *
 * @author Utilizador
 */
public interface GraphADT<T> {

    public void addVertex(T vertex) throws ElementNotFoundException;

    public void removeVertex(T vertex) throws ElementNotFoundException;

    public void addEdge(T vertex1, T vertex2) throws ElementNotFoundException;

    public void removeEdge(T vertex1, T vertex2) throws ElementNotFoundException;

    public Iterator iteratorBFS(T startVertex) throws ElementNotFoundException;

    public Iterator iteratorDFS(T startVertex) throws ElementNotFoundException;

    public Iterator iteratorShortestPath(T startVertex, T targetVertex) throws ElementNotFoundException;

    public boolean isEmpty();

    public boolean isConnected();

    public int size();

    @Override
    public String toString();

}
