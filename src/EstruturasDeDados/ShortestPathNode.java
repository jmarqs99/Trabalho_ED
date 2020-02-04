package EstruturasDeDados;

/**
 *
 * @author Utilizador
 * @param <T>
 */
public class ShortestPathNode<T> {

    /**
     *
     */
    protected T element;

    /**
     *
     */
    protected ShortestPathNode<T> antecessor;

    /**
     *
     */
    protected Double lenght;

    /**
     *
     * @param element
     * @param antecessor
     * @param len
     */
    public ShortestPathNode(T element, ShortestPathNode<T> antecessor,Double len) {
        this.element = element;
        this.antecessor = antecessor;
        this.lenght = len;
    }

    /**
     *
     * @return
     */
    public T getElement() {
        return element;
    }

    /**
     *
     * @param element
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     *
     * @return
     */
    public ShortestPathNode<T> getAntecessor() {
        return antecessor;
    }

    /**
     *
     * @param antecessor
     */
    public void setAntecessor(ShortestPathNode<T> antecessor) {
        this.antecessor = antecessor;
    }

    /**
     *
     * @return
     */
    public Double getLenght() {
        return lenght;
    }

    /**
     *
     * @param lenght
     */
    public void setLenght(double lenght) {
        this.lenght = lenght;
    }
    
}
