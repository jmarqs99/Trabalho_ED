/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstruturasDeDados;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Utilizador
 */
public class Network<T> implements NetworkADT<T> {

    protected final int DEFAULT_CAPACITY = 10;
    protected int numVertices;
    protected Double[][] adjMatrix;
    protected T[] vertices;

    public Network() {
        super();
        this.numVertices = 0;
        this.adjMatrix = new Double[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
    }

    @Override
    public void addEdge(T vertex1, T vertex2, double weight) throws ElementNotFoundException {
        addEdge(getIndex(vertex1), getIndex(vertex2), weight);
    }

    @Override
    public double shortestPathWeight(T vertex1, T vertex2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        int startIndex = getIndex(vertex);
        numVertices--;

        for (int i = startIndex; i < numVertices; i++) {
            vertices[i] = vertices[i + 1];
        }

        for (int i = startIndex; i < numVertices; i++) {
            for (int j = 0; j <= numVertices; j++) {
                adjMatrix[i][j] = adjMatrix[i + 1][j];
            }
        }

        for (int i = startIndex; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjMatrix[j][i] = adjMatrix[j][i + 1];
            }
        }

        for (int i = 0; i < numVertices; i++) {
            adjMatrix[numVertices][i] = null;
            adjMatrix[i][numVertices] = null;
        }
        adjMatrix[numVertices][numVertices] = null;
    }

    @Override
    public void addEdge(T vertex1, T vertex2) throws ElementNotFoundException {
        addEdge(getIndex(vertex1), getIndex(vertex2), 0.0);
    }

    private void addEdge(int index1, int index2, Double weigth) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = weigth;
        }
    }

    @Override
    public void removeEdge(T vertex1, T vertex2) throws ElementNotFoundException {
        removeEdge(getIndex(vertex1), getIndex(vertex2));
    }

    private void removeEdge(int index1, int index2) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = null;
        }
    }

    @Override
    public Iterator iteratorBFS(T startVertex) throws ElementNotFoundException {
        Integer x = null;
        Queue<Integer> traversalQueue = new Queue<Integer>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<T>();
        int startIndex = getIndex(startVertex);

        if (!indexIsValid(startIndex)) {
            return resultList.iterator();
        }

        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        traversalQueue.enqueue(new Integer(startIndex));
        visited[startIndex] = true;

        while (!traversalQueue.isEmpty()) {
            try {
                x = traversalQueue.dequeue();
            } catch (EmptyCollectionException ex) {
                Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
            }
            resultList.addRear(vertices[x.intValue()]);
            /**
             * Find all vertices adjacent to x that have not been visited and
             * queue them up
             */
            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[x.intValue()][i] != null && !visited[i]) {
                    traversalQueue.enqueue(new Integer(i));
                    visited[i] = true;
                }
            }
        }
        return resultList.iterator();
    }

    @Override
    public Iterator iteratorDFS(T startVertex) throws ElementNotFoundException {
        Integer x = null;
        int startIndex = getIndex(startVertex);
        boolean found;
        LinkedStack<Integer> traversalStack = new LinkedStack<Integer>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<T>();
        boolean[] visited = new boolean[numVertices];

        if (!indexIsValid(startIndex)) {
            return resultList.iterator();
        }
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        traversalStack.push(new Integer(startIndex));
        resultList.addRear(vertices[startIndex]);
        visited[startIndex] = true;

        while (!traversalStack.isEmpty()) {
            try {
                x = traversalStack.peek();
            } catch (EmptyCollectionException ex) {
                Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
            }
            found = false;
            /**
             * Find a vertex adjacent to x that has not been visited and push it
             * on the stack
             */
            for (int i = 0; (i < numVertices) && !found; i++) {
                if (adjMatrix[x][i] != null && !visited[i]) {
                    traversalStack.push(new Integer(i));
                    resultList.addRear(vertices[i]);
                    visited[i] = true;
                    found = true;
                }
            }
            if (!found && !traversalStack.isEmpty()) {
                try {
                    traversalStack.pop();
                } catch (EmptyCollectionException ex) {
                    Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        Queue<ShortestPathNode<Integer>> traversalQueue = new Queue<>();
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

                        if (nodes[i].getLength() > x.getLength() + adjMatrix[x.getElement()][i]) {
                            nodes[i].setAntecessor(x);
                            nodes[i].setLength(x.getLength() + adjMatrix[x.getElement()][i]);
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
            resultList.addFront(vertices[x.getElement()]);
            x = x.getAntecessor();
            if (x == null) {
                finished = true;
            }
        }
        return resultList.iterator();
    }

    @Override
    public boolean isEmpty() {
        return numVertices == 0;
    }

    @Override
    public boolean isConnected() {
        boolean cone = true;
        boolean current = false;

        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); j++) {
                if (adjMatrix[i][j] != null && i != j) {
                    current = true;
                }
            }
            if (current == false) {
                cone = false;
            }
        }
        return cone;
    }

    @Override
    public int size() {
        return numVertices;
    }

    private void expandCapacity() {
        Double newMatrix[][] = new Double[vertices.length + vertices.length][vertices.length + vertices.length];
        for (int i = 0; i < vertices.length; i++) {
            for (int j = 0; j < vertices.length; j++) {
                newMatrix[i][j] = adjMatrix[i][j];
            }
        }
        T newVertice[] = (T[]) (new Object[vertices.length + vertices.length]);
        for (int i = 0; i < vertices.length; i++) {
            newVertice[i] = vertices[i];
        }
        vertices = newVertice;
    }

    @Override
    public String toString() {
        String result = "  ";

        for (int j = 0; j < numVertices; j++) {
            result = result + " " + vertices[j];
        }

        result = result + "\n";

        for (int i = 0; i < numVertices; i++) {
            result = result + vertices[i] + " ";
            for (int j = 0; j < numVertices; j++) {
                result = result + " " + (adjMatrix[i][j] != null ? adjMatrix[i][j] : "N");
            }
            result = result + "\n";
        }
        return result;
    }

    private int getIndex(T vertex) throws ElementNotFoundException {
        int pos = -1;
        boolean found = false;
        for (int i = 0; i <= numVertices; i++) {
            if (vertices[i] == vertex && !found) {
                pos = i;
                found = true;
            }
        }

        if (pos == -1) {
            throw new ElementNotFoundException();
        }

        return pos;
    }

    private boolean indexIsValid(int index) {
        return vertices[index] != null;
    }
}
