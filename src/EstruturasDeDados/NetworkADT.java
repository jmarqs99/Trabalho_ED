package EstruturasDeDados;

import Exceptions.ElementNotFoundException;

/**
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
 * @param <T> generico
 */
public interface NetworkADT<T> extends GraphADT<T> {

    /**
     *
     * Insere uma aresta entre dois vértices deste gráfico.
     *
     * @param vertex1 primeiro vertice
     * @param vertex2 segundo vertice
     * @param weight peso
     * @throws ElementNotFoundException caso a coleção esteja vazia
     */
    public void addEdge(T vertex1, T vertex2, double weight) throws ElementNotFoundException;

    /**
     *
     * Retorna o peso do caminho mais curto nesta rede.
     *
     * @param vertex1 primeiro vertice
     * @param vertex2 segundo vertice
     * @return o peso do caminho mais curto nesta rede
     * @throws ElementNotFoundException caso o elemento não seja encontrado
     */
    public double shortestPathWeight(T vertex1, T vertex2) throws ElementNotFoundException;

}
