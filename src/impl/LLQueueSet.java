package impl;

import adt.Queue;
import adt.Set;

public class LLQueueSet<T> implements Set<T> {

    private Queue<T> container = new LinkedListQueue<>();
    private int size;

    public LLQueueSet() {
        container.clear();
        size = container.getSize();
    }

    @Override
    public void add(T value) {
        if (!contains(value)) {
            container.enqueue(value);
            size = container.getSize();
        }
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            try {
                T tempValue = container.dequeue();
                container.enqueue(tempValue);
                if (value.equals(tempValue)) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean remove(T value) {
        if (contains(value)) {
            for (int i = 0; i < size; i++) {
                try {
                    T tempValue = container.dequeue();
                    if (!value.equals(tempValue)) {
                        container.enqueue(tempValue);
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            size = container.getSize();
            return true;
        }
        return false;
    }

    @Override
    public T removeAny() throws Exception {
        T result = container.dequeue();
        size = container.getSize();
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        container.clear();
        size = container.getSize();
    }

    public String toString() {
        String result;
        if (size == 0) {
            result = "Set is empty";
        } else {
            result = "[ ";
            try {
                for (int i = 1; i < container.getSize(); i++) {
                    T tempValue = container.dequeue();
                    container.enqueue(tempValue);
                    result = result + tempValue + ", ";
                }
                T tempValue = container.dequeue();
                container.enqueue(tempValue);
                result = result + tempValue + "]";

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
}
