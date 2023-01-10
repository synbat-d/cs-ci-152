package impl;

import adt.Stack;

public class LinkedListStack<T> implements Stack<T> {
    private Node<T> top;
    private int size;

    public LinkedListStack() {
        top = null;
        size = 0;
    }

    @Override
    public void push(T value) {
        if (size == 0) {
            top = new Node<>(value);
            top.setLink(null);
        } else {
            Node newNode = new Node(value);
            newNode.setLink(top);
            top = newNode;
        }
        size++;
    }

    @Override
    public T pop() throws Exception {
        if (size == 0) {
            throw new Exception("Stack is empty");
        } else {
            T result = top.getValue();
            top = top.getLink();
            size--;
            return result;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    public String toString() {
        String result = "[";
        if (size == 0) {
            result = "Queue is empty";
        } else {
            Node temp = top;
            while (temp != null) {
                result = result + "{" + temp.getValue() + "}";
                temp = temp.getLink();
            }
            result = result + "]";
        }
        return result;
    }
}
