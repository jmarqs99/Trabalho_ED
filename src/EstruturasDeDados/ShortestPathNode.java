package EstruturasDeDados;

/**
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
 * @param <T> generico
 */
public class ShortestPathNode<T> {

    protected T element;
    protected ShortestPathNode<T> antecessor;
    protected Double lenght;

    /**
     * Construtor parameterizado
     *
     * @param element elemento atual
     * @param antecessor elemento anterior
     * @param len tamanho
     */
    public ShortestPathNode(T element, ShortestPathNode<T> antecessor, Double len) {
        this.element = element;
        this.antecessor = antecessor;
        this.lenght = len;
    }

    /**
     * Retorna o elemento
     *
     * @return o elemento
     */
    public T getElement() {
        return element;
    }

    /**
     * Define o elemento
     *
     * @param element o elemento a ser definido
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * Retrona o node anterior
     *
     * @return o node anterior
     */
    public ShortestPathNode<T> getAntecessor() {
        return antecessor;
    }

    /**
     * Define o node anterior
     *
     * @param antecessor o node anterior
     */
    public void setAntecessor(ShortestPathNode<T> antecessor) {
        this.antecessor = antecessor;
    }

    /**
     * Retorna o tamanho
     *
     * @return o tamanho
     */
    public Double getLenght() {
        return lenght;
    }

    /**
     * Define o tamanho
     *
     * @param lenght valor do tamanho
     */
    public void setLenght(double lenght) {
        this.lenght = lenght;
    }

}
