package collections;

public abstract class List <T> extends Project  {

    public abstract void add(T value);
    public abstract T get(int index);
    public abstract void set(int index, T value);

}