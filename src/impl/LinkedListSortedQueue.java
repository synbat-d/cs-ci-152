package impl;

import adt.SortedQueue;

public class LinkedListSortedQueue<T extends Comparable> implements SortedQueue<T> {
    private Node<T> front;
    private int size;

    public LinkedListSortedQueue() {
        front = null;
        size = 0;
    }

    @Override
    public void insert(T value) {
        Node<T> newNode = new Node<>(value);
        if (size == 0) {
            front = newNode;
        } else {
            Node<T> backNode = front;
            while (backNode.getLink() != null) {
                backNode = backNode.getLink();
            }
            if (value.compareTo(front.getValue()) <= 0) {
                newNode.setLink(front);
                front = newNode;
            } else if (value.compareTo(backNode.getValue()) > 0) {
                backNode.setLink(newNode);
            } else {
                Node<T> tempNode = front;
                while (tempNode.getLink() != null) {
                    if (value.compareTo(tempNode.getValue()) > 0) {
                        newNode.setLink(tempNode.getLink());
                        tempNode.setLink(newNode);
                    }
                }
            }
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
                result = result + " " + temp.getValue() + ",";
                temp = temp.getLink();
            }
            result = result + " " + temp.getValue() + "]";
        }
        return result;
    }
}
