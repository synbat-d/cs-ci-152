package impl;

import adt.Stack;

public class ArrayStack<T> implements Stack<T> {
    private T[] array;
    private int size;

    public ArrayStack() {
        array = (T[]) new Object[5];
        size = 0;
    }

    @Override
    public void push(T value) {
        if (size < array.length) {
            array[size] = value;
            size++;
        } else {
            T[] arrayNew = (T[]) new Object[size * 2];
            for (int i = 0; i < size; i++) {
                arrayNew[i] = array[i];
            }
            arrayNew[size] = value;
            array = arrayNew;
            size++;
        }
    }

    @Override
    public T pop() throws Exception {
        if (size == 0) {
            throw new Exception("Stack is empty");
        }
        T result = array[size - 1];
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
            result = result + array[0];
            for (int i = 1; i < size; i++) {
                result = result + ", " + array[i];
            }
            result = result + "]";
        }
        return result;
    }
}
