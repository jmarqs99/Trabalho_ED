package Classes;

import EstruturasDeDados.ArrayUnorderedList;
import EstruturasDeDados.Network;
import Exceptions.ElementNotFoundException;

/**
 * <h3>
 * ESTG - Escola Superior de Tecnologia e Gestão<br>
 * IPP - Instituto Politécnico do Porto<br>
 * LEI - Licenciatura em Engenharia Informática<br>
 * PP - Paradigmas de Programação<br>
 * </h3>
 * <p>
 * <strong>Author: </strong><br>
 * Joao Sousa<br>
 * <strong>Description: </strong><br>
 * Class that represents
 * </p>
 * @param <T>
 */

public class NetworkJogo<T> extends Network<T> {

    /**
     * Gives the Weight between the vertices given
     *
     * @param vertex1
     * @param vertex2
     * @return The weight of the edge between the vertices given
     * @throws ElementNotFoundException if at least on of the vertices wasn't
     * found
     */
    public double getWeight(T vertex1, T vertex2) throws ElementNotFoundException {
        return (double) (super.adjMatrix[super.getIndex(vertex1)][super.getIndex(vertex2)]);
    }

    /**
     * Method to get all the edges of a specific Vertex.
     *
     * @param vertex Vertex to get the edges
     * @return An Unordered List with the edges
     * @throws ElementNotFoundException if the Vertex wasn't found
     */
    public ArrayUnorderedList<T> getEdges(T vertex) throws ElementNotFoundException {
        int index = getIndex(vertex);
        ArrayUnorderedList result = new ArrayUnorderedList<>();
        for (int i = 0; i < super.vertices.length; i++) {
            if (adjMatrix[index][i] != null) {
                result.addToRear(super.vertices[i]);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
