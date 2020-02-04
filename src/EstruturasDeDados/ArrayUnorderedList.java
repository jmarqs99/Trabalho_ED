package EstruturasDeDados;

/**
 * @author Grupo 21
 * @author João Pedro Faria Marques nº8180551, T2
 * @author João Pedro Brandão Moreira de Sousa nº8180175, T4
 * @param <T> generico
 */
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {

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

    @Override
    public void addToRear(T element) {
        list[rear] = element;
        rear++;
    }

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
