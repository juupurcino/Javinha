package collections;

public class Node <T> {
    
    private T value;
    private Node<T> next = null;
    private Node<T> previous = null;
    
    Node (T value){
    
        this.value = value;
    }
    
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

}
