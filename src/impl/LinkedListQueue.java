package impl;

import adt.Queue;

public class LinkedListQueue<T> implements Queue<T> {
    private Node<T> front;
    private Node<T> back;
    private int size;

    public LinkedListQueue() {
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public void enqueue(T value) {
        if (size == 0) {
            front = new Node<>(value);
            back = front;
        } else {
            back.setLink(new Node<>(value));
            back = back.getLink();
        }
        size++;
    }

    @Override
    public T dequeue() throws Exception {
        if (size == 0) {
            throw new Exception("Queue is empty, nothing to dequeue");
        }
        T result = front.getValue();
        size--;
        front = front.getLink();
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public String toString() {
        String result;
        if (size == 0) {
            result = "Queue is empty";
        } else {
            Node temp = front;
            result = "[";
            while (temp.getLink() != null) {
                result = result + "{ " + temp.getValue() + "},";
                temp = temp.getLink();
            }
            result = result + "{ " + temp.getValue() + "}" + "]";
        }
        return result;
    }
}
