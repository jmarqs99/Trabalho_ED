package EstruturasDeDados;

/**
 * Interface que contrata uma lista ordenada
 *
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
 * @param <T> generico
 */
public interface OrderedListADT<T> extends ListaADT<T> {

    /**
     * Adiciona o elemento especificado a esta lista em a localização adequada
     *
     * @param element elemento o elemento a ser adicionado a esta lista
     */
    public void add(T element);

}
