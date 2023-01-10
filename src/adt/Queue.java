package adt;

public interface Queue<T> {
    public void enqueue(T value);

    public T dequeue() throws Exception;

    public int getSize();

    public void clear();

    @Override
    public String toString();

}
