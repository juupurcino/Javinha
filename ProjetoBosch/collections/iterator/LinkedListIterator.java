package collections.iterator;
import collections.execeptions.CheckedExeption;
import collections.*;

public class LinkedListIterator<E> implements Iterator<E>{
    
    private LinkedList<E> linkedList;
    private Node<E> current;
    private int step = -1;
    
    public LinkedListIterator(LinkedList<E> linkedList) {
        this.linkedList = linkedList;
        if (linkedList != null) {
            current = linkedList.getHead();
        }
    }

    @Override
    public E next() throws CheckedExeption{

        step ++;

        if (current == null) {
            throw new CheckedExeption("Lista vazia");
        }
        
        E value = current.getValue();
        current = current.getNext();
        step ++;
        return value;

    }

    @Override
    public boolean hasNext(){

        return (current != null);
    }
}
