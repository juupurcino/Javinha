package collections.iterator;

import collections.Stack;
import collections.execeptions.CheckedExeption;

public class StackIterator<E> implements Iterator<E> {
    
    private Stack<E> stack;
    private int step = -1;
    
    public StackIterator(Stack<E> stack) {
        this.stack = stack;
    }

    @Override
    public E next() throws CheckedExeption{

        if (!hasNext()) {
            throw new CheckedExeption("Nao tem proximo!");

        } 
         
        step++;

        return stack.get(step);
    }

    @Override
    public boolean hasNext(){

        return step + 1 < stack.getSize();        
    }

}

