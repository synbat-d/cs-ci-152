package impl;

import adt.Deque;

public class LinkedListDeque<T> implements Deque<T> {

    private DoublyLinkedNode<T> front;
    private DoublyLinkedNode<T> back;
    private int size;

    public LinkedListDeque() {
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public void pushToFront(T value) {
        DoublyLinkedNode<T> newNode = new DoublyLinkedNode(value);
        if (size == 0) {
            front = newNode;
            back = newNode;
        } else {
            newNode.setNext(front);
            front.setPrevious(newNode);
            front = newNode;
        }
        size++;
    }

    @Override
    public void pushToBack(T value) {
        DoublyLinkedNode<T> newNode = new DoublyLinkedNode(value);
        if (size == 0) {
            front = newNode;
            back = newNode;
        } else {
            newNode.setPrevious(back);
            back.setNext(newNode);
            back = newNode;
        }
        size++;
    }

    @Override
    public T popFromFront() throws Exception {
        if (size == 0) {
            throw new Exception("Deque is empty, nothing to pop");
        }
        T result = front.getValue();
        size--;

        if (size != 0) {
            front = front.getNext();
            front.setPrevious(null);
        } else {
            clear();
        }

        return result;
    }

    @Override
    public T popFromBack() throws Exception {
        if (size == 0) {
            throw new Exception("Deque is empty, nothing to pop");
        }
        T result = back.getValue();
        size--;
        if (size != 0) {
            back = back.getPrevious();
            back.setNext(null);
        } else {
            clear();
        }
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
            DoublyLinkedNode temp = front;
            result = "[";
            while (temp.getNext() != null) {
                result = result + "{ " + temp.getValue() + "},";
                temp = temp.getNext();
            }
            result = result + "{ " + temp.getValue() + "}" + "]";
        }
        return result;
    }
}
