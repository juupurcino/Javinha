package collections;
import collections.execeptions.CheckedExeption;

public class Queue<T> extends Project{

    private Node<T> head = null;
    private Node<T> tail = null;

    public void add(T value){

        Node<T> newnode = new Node<T>(value);
        this.size++;

        if (head == null){
            head = newnode;
            tail = head;
            return;
        }

        newnode.setPrevious(tail);
        tail.setNext(newnode);
        tail = newnode;
    }

    public T dequeue(){

        if(head == null){
            throw new CheckedExeption("Indice Invalido");
        }
        

        T aux = head.getValue();

        head = head.getNext();
        if (head != null) {
            head.setPrevious(null);
        }

        size --;

        return aux;

    }   

    public Node<T> getHead(){
        return this.head;
    }
    
}
