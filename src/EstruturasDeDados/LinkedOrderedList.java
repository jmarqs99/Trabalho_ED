package EstruturasDeDados;

/**
 *
 * @author Utilizador
 * @param <T>
 */
public class LinkedOrderedList<T> extends LinkedList<T> implements OrderedListADT<T> {

    /**
     *
     * @param element
     */
    @Override
    public void add(T element) {
        if (element instanceof Comparable) {
            if (isEmpty()) {
                head = new DoubleNode<>(element);
                tail = head;

            } else {
                boolean found = false;
                DoubleNode<T> current = head;

                while (current != null && found == false) {
                    Comparable<T> tmp = (Comparable<T>) current.getElement();
                    if (tmp.compareTo(element) > 0) {
                        found = true;
                    } else {
                        current = current.getNext();
                    }
                }

                if (found == true) {
                    if (current == head) {
                        DoubleNode<T> olderHead = head;
                        head = new DoubleNode<>(element);
                        head.setNext(olderHead);
                        olderHead.setPrev(head);
                    } else {
                        DoubleNode<T> previous = current.getPrev();
                        DoubleNode<T> newNode = new DoubleNode<>(element);

                        previous.setNext(newNode);
                        current.setPrev(newNode);

                        newNode.setPrev(previous);
                        newNode.setNext(current);
                    }
                } else {
                    DoubleNode<T> olderTail = tail;
                    tail = new DoubleNode<>(element);
                    tail.setPrev(olderTail);
                    olderTail.setNext(tail);
                }

            }
            count++;
        } else {
            System.out.println("O elemento não é comparavel!");
        }

    }

}
