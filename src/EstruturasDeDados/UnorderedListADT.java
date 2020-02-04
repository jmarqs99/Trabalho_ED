package EstruturasDeDados;

/**
 *
 * @author Utilizador
 * @param <T>
 */
public interface UnorderedListADT<T> extends ListaADT<T> {

    /**
     *
     * @param element
     */
    public void addToFront(T element);

    /**
     *
     * @param element
     */
    public void addToRear(T element);

    /**
     *
     * @param element
     * @param prevElement
     * @throws Exception
     */
    public void addAfter(T element, T prevElement) throws Exception;
}
