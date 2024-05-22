package collections;

public class Stack<T> extends Project {

    private T[] data;

    public Stack(){
        
        data = (t[])(new Object[10]);
    }

    public Stack(int capacity){
        
        data = (t[])(new Object[capacity]);
    }

    public void push(T value){

        if (size == data.length) {
            
            T[] copy = (t[])(new Object[data.length * 2]);
            
            for (int i = 0; i < size; i++) {
                
                copy[i] = data[i];
            }

            data = copy;
        }

        data[size] = value;
        size ++;

    }

    public void pop(){

        if (size == 0) {
            return;
        }

        size --;
    }

}