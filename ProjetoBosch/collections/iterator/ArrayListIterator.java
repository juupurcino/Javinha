package collections.iterator;
import collections.ArrayList;
import collections.execeptions.CheckedExeption;

public class ArrayListIterator<E> implements Iterator<E>{

    private ArrayList<E> array;
    private int step = -1;
    
    public ArrayListIterator(ArrayList<E> array) {
        this.array = array;
    }

    @Override
    public E next() throws CheckedExeption{

        if (!hasNext()) {
            throw new CheckedExeption("Nao tem proximo!");

        } 
         
        step++;

        return array.get(step);
    }

    @Override
    public boolean hasNext(){

        return step + 1 < array.getSize();        
    }

}
