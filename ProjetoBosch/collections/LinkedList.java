package collections;
import collections.execeptions.CheckedExeption;

public class LinkedList<T> extends List <T> {

    private Node<T> head = null;
    private Node<T> tail = null;

    @Override
    public void add(T value){

        Node<T> newnode = new Node<T>(value);
        this.size ++;

        if (head == null) {
            head = newnode;
            tail = head;
            return;
        }

        newnode.setPrevious(tail);
        tail.setNext(newnode);
        tail = newnode;

    }

    @Override
    public T get(int index) throws CheckedExeption{

        if(index < 0 || index >= size){

            Node<T> current = head;

            while(index > 0){

                current = current.getNext();
                index --;
            }

            return current.getValue();
        }
        
        throw new CheckedExeption("Indice invalido");
    }

    @Override
    public void set(int index, T value){

        if (index >= size) {
            throw new CheckedExeption("Indice Invalido");
        }
        
        Node<T> current = head;

        int i = 0;

        while (i != index) {
            current = current.getNext();
            i ++;
        }

        current.setValue(value);
    }


    public Node<T> getHead(){
        return this.head;
    }

}