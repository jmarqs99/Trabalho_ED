package EstruturasDeDados;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
 * @param <T> generico
 */
public class Network<T> implements NetworkADT<T> {

    protected final int DEFAULT_CAPACITY = 10;
    protected int numVertices;
    protected Double[][] adjMatrix;
    protected T[] vertices;

    /**
     * Construtor sem parametros
     */
    public Network() {
        this.numVertices = 0;
        this.adjMatrix = new Double[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        this.vertices = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    @Override
    public void addEdge(T vertex1, T vertex2, double weight) throws ElementNotFoundException {
        addEdgeInter(getIndex(vertex1), getIndex(vertex2), weight);
    }

    @Override
    public void addEdge(T vertex1, T vertex2) throws ElementNotFoundException {
        addEdgeInter(getIndex(vertex1), getIndex(vertex2), 0.0);
    }

    private void addEdgeInter(int index1, int index2, Double weight) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = weight;
        }
    }

    /**
     * Retorna o indice do vertice dado
     *
     * @param vertex vertice dado
     * @return um inteiro com o indice do vertice
     * @throws ElementNotFoundException caso o elemento não seja encontrado
     */
    public int getIndex(T vertex) throws ElementNotFoundException {
        int pos = -1;
        boolean found = false;
        for (int i = 0; i < size() && !found; i++) {
            if (vertices[i].equals(vertex)) {
                pos = i;
                found = true;
            }
        }
        if (pos == -1) {
            throw new ElementNotFoundException("Vertície " + vertex + " não existente no gráfico!");
        }
        return pos;
    }

    private boolean indexIsValid(int index) {
        return vertices[index] != null;
    }

    @Override
    public double shortestPathWeight(T vertex1, T vertex2) throws ElementNotFoundException {
        int startIndex = getIndex(vertex1);
        int targetIndex = getIndex(vertex2);

        if (!indexIsValid(startIndex) && !indexIsValid(targetIndex)) {
            throw new ElementNotFoundException();
        }

        boolean[][] visited = new boolean[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            for (int y = 0; y < numVertices; y++) {
                visited[i][y] = false;
            }
        }
        LinkedQueue<ShortestPathNode<Integer>> traversalQueue = new LinkedQueue<>();
        ShortestPathNode<Integer>[] nodes = new ShortestPathNode[numVertices];

        for (int i = 0; i < numVertices; i++) {
            nodes[i] = new ShortestPathNode<>(i, null, Double.MAX_VALUE);
        }
        ShortestPathNode<Integer> x = nodes[0];
        traversalQueue.enqueue(new ShortestPathNode<>(startIndex, null, 0.0));
        visited[startIndex][0] = true;

        while (!traversalQueue.isEmpty()) {
            try {
                x = traversalQueue.dequeue();
            } catch (EmptyCollectionException ex) {
                Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
            }
            /**
             * Find all vertices adjacent to x that have not been visited and
             * queue them up
             */
            if (x.getElement() != targetIndex) {
                for (int i = 0; i < numVertices; i++) {
                    if (adjMatrix[x.getElement()][i] != null && !visited[x.getElement()][i]) {

                        if (nodes[i].getLenght() > x.getLenght() + adjMatrix[x.getElement()][i]) {
                            nodes[i].setAntecessor(x);
                            nodes[i].setLenght(x.getLenght() + adjMatrix[x.getElement()][i]);
                        }
                        traversalQueue.enqueue(nodes[i]);
                        visited[x.getElement()][i] = true;
                    }
                }
            }

        }
        return nodes[targetIndex].getLenght();
    }

    @Override
    public void addVertex(T vertex) {
        if (numVertices == vertices.length) {
            expandCapacity();
        }

        vertices[numVertices] = vertex;

        for (int i = 0; i <= numVertices; i++) {
            adjMatrix[numVertices][i] = null;
            adjMatrix[i][numVertices] = null;
        }
        numVertices++;
    }

    @Override
    public void removeVertex(T vertex) throws ElementNotFoundException {
        int pos = getIndex(vertex);

        numVertices--;

        for (int i = pos; i < size(); i++) {
            vertices[i] = vertices[i + 1];
        }

        vertices[size()] = null;

        for (int i = pos; i < size(); i++) {
            for (int y = 0; y < size() + 1; y++) {
                adjMatrix[i][y] = adjMatrix[i + 1][y];
            }
        }

        for (int i = pos; i < size(); i++) {
            for (int y = 0; y < size(); y++) {
                adjMatrix[y][i] = adjMatrix[y][i + 1];
            }
        }

        for (int i = 0; i < size(); i++) {
            adjMatrix[size()][i] = null;
            adjMatrix[i][size()] = null;
        }
        adjMatrix[size()][size()] = null;
    }

    @Override
    public void removeEdge(T vertex1, T vertex2) throws ElementNotFoundException {
        removeEdge(getIndex(vertex1), getIndex(vertex2));
    }

    /**
     * Remove a ligação entre 2 vertices com os indices dados
     *
     * @param index1 indice do primeiro vertice
     * @param index2 indice do segundo vertice
     */
    public void removeEdge(int index1, int index2) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = null;
        }
    }

    @Override
    public Iterator iteratorBFS(T startVertex) throws ElementNotFoundException {
        Integer x = null;
        int startIndex = getIndex(startVertex);
        LinkedQueue<Integer> traversalQueue = new LinkedQueue<>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();

        if (!indexIsValid(startIndex)) {
            return resultList.iterator();
        }

        boolean[] visited = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        traversalQueue.enqueue(startIndex);
        visited[startIndex] = true;

        while (!traversalQueue.isEmpty()) {
            try {
                x = traversalQueue.dequeue();
            } catch (EmptyCollectionException ex) {
                Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
            }
            resultList.addToRear(vertices[x]);
            /**
             * Find all vertices adjacent to x that have not been visited and
             * queue them up
             */
            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[x][i] != null && !visited[i]) {
                    traversalQueue.enqueue(i);
                    visited[i] = true;
                }
            }
        }
        return resultList.iterator();
    }

    @Override
    public Iterator iteratorDFS(T startVertex) throws ElementNotFoundException {
        Integer x = null;
        boolean found;
        int startIndex = getIndex(startVertex);
        LinkedStack<Integer> traversalStack = new LinkedStack<>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();
        boolean[] visited = new boolean[numVertices];

        if (!indexIsValid(startIndex)) {
            return resultList.iterator();
        }
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        traversalStack.push(startIndex);
        resultList.addToRear(vertices[startIndex]);
        visited[startIndex] = true;

        while (!traversalStack.isEmpty()) {
            try {
                x = traversalStack.peek();
                found = false;
                /**
                 * Find a vertex adjacent to x that has not been visited and
                 * push it on the stack
                 */
                for (int i = 0; (i < numVertices) && !found; i++) {
                    if (adjMatrix[x][i] != null && !visited[i]) {
                        traversalStack.push(i);
                        resultList.addToRear(vertices[i]);
                        visited[i] = true;
                        found = true;
                    }
                }
                if (!found && !traversalStack.isEmpty()) {
                    traversalStack.pop();
                }
            } catch (EmptyCollectionException ex) {
                Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultList.iterator();
    }

    @Override
    public Iterator iteratorShortestPath(T startVertex, T targetVertex) throws ElementNotFoundException {
        int startIndex = getIndex(startVertex);
        int targetIndex = getIndex(targetVertex);

        if (!indexIsValid(startIndex) && !indexIsValid(targetIndex)) {
            throw new ElementNotFoundException();
        }

        boolean[][] visited = new boolean[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            for (int y = 0; y < numVertices; y++) {
                visited[i][y] = false;
            }
        }

        LinkedQueue<ShortestPathNode<Integer>> traversalQueue = new LinkedQueue<>();
        ShortestPathNode<Integer>[] nodes = new ShortestPathNode[numVertices];

        for (int i = 0; i < numVertices; i++) {
            nodes[i] = new ShortestPathNode<>(i, null, Double.MAX_VALUE);
        }

        ShortestPathNode<Integer> x = nodes[0];
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();
        traversalQueue.enqueue(new ShortestPathNode<>(startIndex, null, 0.0));
        visited[startIndex][0] = true;

        while (!traversalQueue.isEmpty()) {
            try {
                x = traversalQueue.dequeue();
            } catch (EmptyCollectionException ex) {
                Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
            }
            /**
             * Find all vertices adjacent to x that have not been visited and
             * queue them up
             */
            if (x.getElement() != targetIndex) {
                for (int i = 0; i < numVertices; i++) {
                    if (adjMatrix[x.getElement()][i] != null && !visited[x.getElement()][i]) {

                        if (nodes[i].getLenght() > x.getLenght() + adjMatrix[x.getElement()][i]) {
                            nodes[i].setAntecessor(x);
                            nodes[i].setLenght(x.getLenght() + adjMatrix[x.getElement()][i]);
                        }
                        traversalQueue.enqueue(nodes[i]);
                        visited[x.getElement()][i] = true;
                    }
                }
            }

        }
        x = nodes[targetIndex];
        boolean finished = false;
        while (!finished) {
            resultList.addToFront(vertices[x.getElement()]);
            x = x.getAntecessor();
            if (x == null) {
                finished = true;
            }
        }
        return resultList.iterator();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean isConnected() {
        boolean connected = true;

        for (int i = 0; i < size() && connected; i++) {

            boolean currentLine = false;

            for (int y = 0; y < size(); y++) {
                if (adjMatrix[i][y] != null && i != y) {
                    currentLine = true;
                }
            }
            if (currentLine == false) {
                connected = false;
            }
        }
        return connected;
    }

    @Override
    public int size() {
        return numVertices;
    }

    @Override
    public String toString() {
        String res = "  ";

        for (int y = 0; y < size(); y++) {
            res = res + " " + vertices[y];
        }

        res = res + "<br>";

        for (int i = 0; i < size(); i++) {
            res = res + vertices[i] + " ";
            for (int y = 0; y < size(); y++) {

                res = res + " " + (adjMatrix[i][y] != null ? adjMatrix[i][y] : "N");
            }
            res = res + "<br>";
        }
        return res;
    }

    private void expandCapacity() {
        Double newMatrix[][] = new Double[vertices.length + vertices.length][vertices.length + vertices.length];

        for (int i = 0; i < vertices.length; i++) {
            for (int y = 0; i < vertices.length; i++) {
                newMatrix[i][y] = adjMatrix[i][y];
            }
        }
        adjMatrix = newMatrix;

        T newVertice[] = (T[]) (new Object[vertices.length + vertices.length]);

        for (int i = 0; i < vertices.length; i++) {
            newVertice[i] = vertices[i];
        }
        vertices = newVertice;
    }
}
