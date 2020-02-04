package EstruturasDeDados;

/**
 * Classe para gerir classificações acerca do jogador
 *
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
 * @param <T> generico
 */
public interface UnorderedListADT<T> extends ListaADT<T> {

    /**
     * Adiciona o elemento ao inicio da lista
     *
     * @param element elemento a ser adicionado
     */
    public void addToFront(T element);

    /**
     * Adiciona o elemento ao fim da lista
     *
     * @param element elemento a ser adicionado
     */
    public void addToRear(T element);

    /**
     * Adiciona o elemento depois de outro elemento
     *
     * @param element elemento a ser adicionado
     * @param prevElement elemento de referencia ao qual sera adicionado depois
     * @throws Exception caso o elemento não exista
     */
    public void addAfter(T element, T prevElement) throws Exception;
}
