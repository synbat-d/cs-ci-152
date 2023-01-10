package impl;

import adt.Queue;

public class ArrayQueue<T> implements Queue<T> {
    private T[] array;
    private int size;
    private int front;
    private int back;

    public ArrayQueue() {
        array = (T[]) new Object[5];
        size = 0;
    }

    @Override
    public void enqueue(T value) {
        if (size == 0) {
            array[0] = value;
            front = 0;
            back = 0;
            size++;
            return;
        }
        if (size < array.length) {
            if (back < array.length - 1) {
                array[back + 1] = value;
                back++;
                size++;
            } else {
                back = 0;
                array[back] = value;
                size++;
            }
        } else {
            T[] arrayNew = (T[]) new Object[size * 2];
            if (back > front) {
                int i;
                for (i = 0; i < array.length; i++) {
                    arrayNew[i] = array[i];
                }
                arrayNew[i] = value;
                array = arrayNew;
                back = i;
                size++;
            } else {
                int j = 0;
                for (int i = front; i < array.length; i++) {
                    arrayNew[j] = array[i];
                    j++;
                }
                for (int i = 0; i < front; i++) {
                    arrayNew[j] = array[i];
                    j++;
                }
                arrayNew[j] = value;
                back = j;
                front = 0;
                array = arrayNew;
                size++;
            }
        }
    }

    @Override
    public T dequeue() throws Exception {
        if (size == 0) {
            throw new Exception("there is no element inside the queue");
        }
        T result = array[front];
        array[front] = null;
        if (front + 1 < array.length) {
            front++;
        } else {
            front = 0;
        }
        size--;
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        array = (T[]) new Object[5];
        size = 0;
    }

    @Override
    public String toString() {
        String result = "[";
        if (size == 0) {
            result = "Queue is empty";
        } else {
            if (front < back) {
                result = result + array[front];
                for (int i = front + 1; i <= back; i++) {
                    result = result + ", " + array[i];
                }
                result = result + "]";
            } else {
                result = result + array[front];
                for (int i = front + 1; i < array.length; i++) {
                    result = result + ", " + array[i];
                }
                for (int i = 0; i <= back; i++) {
                    result = result + ", " + array[i];
                }
                result = result + "]";
            }
        }
        return result;
    }
}
