package Classes;

import EstruturasDeDados.ArrayUnorderedList;
import EstruturasDeDados.Network;
import Exceptions.ElementNotFoundException;

/**
 * Classe para adicionar métodos adicionais á Network
 *
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
 * @param <T> genérico
 */
public class NetworkJogo<T> extends Network<T> {

    /**
     * Define o peso entre os dois vertices dados
     *
     * @param vertex1 primeiro vertice
     * @param vertex2 segundo vertice
     * @return O peso da aresta entre os vertices dados
     * @throws ElementNotFoundException caso um dos vertices não seja encontrado
     */
    public double getWeight(T vertex1, T vertex2) throws ElementNotFoundException {
        return (double) (super.adjMatrix[super.getIndex(vertex1)][super.getIndex(vertex2)]);
    }

    /**
     * Método para retornar todas as arestas para o dado vertice
     *
     * @param vertex vertice ao qual irão ser procuradas arestas
     * @return uma lista não ordenada com os vertices aos quais existe ligação
     * @throws ElementNotFoundException caso o vertice não seja encontrado
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
        return super.toString();
    }

    public String toStringWithoutGhosts() {

        String res = "  ";
        for (int y = 0; y < size(); y++) {
            res = res + " " + vertices[y];
        }
        res = res + "<br>";
        for (int i = 0; i < size(); i++) {
            res = res + vertices[i] + " ";
            for (int y = 0; y < size(); y++) {

                res = res + " " + (adjMatrix[i][y] != null ? "S" : "N");
            }
            res = res + "<br>";
        }
        return res;
    }

}
