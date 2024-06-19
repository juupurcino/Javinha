package collections.iterator;
import collections.*;
import collections.execeptions.CheckedExeption;

public class QueueIterator<E> implements Iterator<E> {
    
    private Queue<E> queue;
    private Node<E> current;
    private int step = - 1;

    public QueueIterator(Queue<E> queue) {
        this.queue = queue;
    }
    
    @Override
    public E next() throws CheckedExeption{
        
        step++;
        
        if (queue != null) {
            current = queue.getHead();
            return current.getValue();
            
        }
        
        if (current.getNext() != null) {
            current = current.getNext();
            step ++;
            return current.getValue();    
        }
        
        throw new CheckedExeption("Lista vazia"); 
        
    }
    
    @Override
    public boolean hasNext(){

        return (current.getNext() != null) ? true : false;
    }
}
