package collections;
import collections.execeptions.CheckedExeption;

public class ArrayList <T> extends List <T>{

    private T[] data;

    /**
     * 
     */
    public ArrayList(){

        data = (t[])(new Object[10]);
    }
    
    public ArrayList(int capacity){

        data = (t[])(new Object[10]);
    }
    
    @Override
    public void add(T value){

        if (this.size == data.length) {
            T[] copy = (t[])(new Object[data.length * 2]);
            
            for (int i = 0; i < size; i++) {
                copy[i] = data[i];   
            }

            data = copy;
        }

        data[size] = value;
        size ++;
    }

    @Override
    public T get(int index) throws CheckedExeption{

        if (index < size && index >= 0) {
            return data[index];
        }

        throw new CheckedExeption("Indice Invalido");
    }

    @Override
    public void set(int index, T value){

        if (index < size && index >= 0) {
            data[index] = value;
        }

        throw new CheckedExeption("Indice Invalido");
    }


}