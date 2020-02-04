package EstruturasDeDados;

import Exceptions.ElementNotFoundException;
import java.util.Iterator;

/**
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
 * @param <T> generico
 */
public interface GraphADT<T> {

    /**
     *
     * Adiciona um vértice a este gráfico, associando o objeto ao vértice.
     *
     * @param vertex vértice o vértice a ser adicionado a este gráfico
     */
    public void addVertex(T vertex);

    /**
     *
     * Remove um único vértice com o valor fornecido deste gráfico.
     *
     * @param vertex vértice o vértice a ser removido deste gráfico
     * @throws ElementNotFoundException caso o elemento não seja encontrado
     */
    public void removeVertex(T vertex) throws ElementNotFoundException;

    /**
     * Inserts an edge between two vertices of this graph.
     *
     * @param vertex1 o primeiro vértice
     * @param vertex2 o segundo vertice
     * @throws ElementNotFoundException caso o elemento não seja encontrado
     */
    public void addEdge(T vertex1, T vertex2) throws ElementNotFoundException;

    /**
     *
     * Remove uma aresta entre dois vértices deste gráfico
     *
     * @param vertex1 o primeiro vertice
     * @param vertex2 o segundo vertice
     * @throws ElementNotFoundException caso o elemento não seja encontrado
     */
    public void removeEdge(T vertex1, T vertex2) throws ElementNotFoundException;

    /**
     *
     * Retorna um iterador que executa uma primeira pesquisa de largura percurso
     * iniciando no índice especificado.
     *
     * @param startVertex o vertice para iniciar a pesquisa
     * @return um iterador que executa uma primeira travessia de largura
     * @throws ElementNotFoundException caso o elemento não seja encontrado
     */
    public Iterator iteratorBFS(T startVertex) throws ElementNotFoundException;

    /**
     * Retorna um iterador que executa uma primeira pesquisa de profundidade
     * percurso iniciando no índice especificado.
     *
     * @param startVertex o vertice para iniciar a pesquisa
     * @return um iterador que executa uma primeira travessia de profundidade
     * @throws ElementNotFoundException caso o elemento não seja encontrado
     */
    public Iterator iteratorDFS(T startVertex) throws ElementNotFoundException;

    /**
     * Retorna um iterador que executa uma primeira pesquisa de caminho mais
     * curto percurso iniciando no índice especificado.
     *
     * @param startVertex o vertice para iniciar a pesquisa
     * @param targetVertex o vertice para terminar a pesquisa
     * @return um iterador que executa uma primeira travessia de caminho mais
     * curto
     * @throws ElementNotFoundException caso o elemento não seja encontrado
     */
    public Iterator iteratorShortestPath(T startVertex, T targetVertex) throws ElementNotFoundException;

    /**
     *
     * Retorna true se este gráfico estiver vazio, false caso contrário.
     *
     * @return true se o grafo está vazio
     */
    public boolean isEmpty();

    /**
     *
     * true se este gráfico estiver conectado, false caso contrário.
     *
     * @return true se este gráfico estiver conectado
     */
    public boolean isConnected();

    /**
     *
     * Retorna o número de vértices neste gráfico
     *
     * @return o número inteiro de vértices neste gráfico
     */
    public int size();

    @Override
    public String toString();

}
