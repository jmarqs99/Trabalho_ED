/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstruturasDeDados;

import Exceptions.ElementNotFoundException;

/**
 *
 * @author Utilizador
 * @param <T>
 */
public interface NetworkADT<T> extends GraphADT<T> {

    public void addEdge(T vertex1, T vertex2, double weight) throws ElementNotFoundException;

    public double shortestPathWeight(T vertex1, T vertex2);

}
