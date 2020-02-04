package EstruturasDeDados;

/**
 *
 * @author Utilizador
 * @param <T>
 */
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {

    /**
     *
     * @param element
     */
    @Override
    public void addToFront(T element) {
        if (!isEmpty()) {
            
            for (int i = size(); i > 0; i--) {
                list[i] = list[i - 1];
            }
        }
        list[0] = element;
        rear++;
    }

    /**
     *
     * @param element
     */
    @Override
    public void addToRear(T element) {
        list[rear] = element;
        rear++;
    }

    /**
     *
     * @param element
     * @param prevElement
     * @throws Exception
     */
    @Override
    public void addAfter(T element, T prevElement) throws Exception {
        if (contains(prevElement)) {
            
            for (int i = 0; i < size(); i++) {
                
                if (list[i] == prevElement) {
                    
                    for (int k = size(); k > i + 1; k--) {
                        list[k] = list[k - 1];
                    }
                    list[i + 1] = element;
                    i = size();
                }
            }
            rear++;
        } else {
            throw new Exception("Elemento não existe na lista");
        }
    }

}
