package impl;

import adt.Set;
import adt.Stack;

public class LLStackSet<T> implements Set<T> {
    private Stack<T> container = new LinkedListStack<>();
    private int size;

    public LLStackSet() {
        container.clear();
        size = container.getSize();
    }

    @Override
    public void add(T value) {
        if (!contains(value)) {
            container.push(value);
            size = container.getSize();
        }
    }

    @Override
    public boolean contains(T value) {
        Stack<T> newtempStack = new LinkedListStack<>();
        for (int i = 0; i < size; i++) {
            try {
                T tempValue = container.pop();
                newtempStack.push(tempValue);
                if (value.equals(tempValue)) {
                    int newSize = newtempStack.getSize();
                    for (int j = 0; j < newSize; j++) {
                        container.push(newtempStack.pop());
                    }
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        container = newtempStack;
        return false;
    }

    @Override
    public boolean remove(T value) {
        if (contains(value)) {
            Stack<T> newtempStack = new LinkedListStack<>();
            for (int i = 0; i < size; i++) {
                try {
                    T tempValue = container.pop();
                    if (!value.equals(tempValue)) {
                        newtempStack.push(tempValue);
                    } else {
                        if (newtempStack.getSize() != 0) {
                            int newSize = newtempStack.getSize();
                            for (int j = 0; j < newSize; j++) {
                                container.push(newtempStack.pop());
                            }
                        }
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
        T result = container.pop();
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
                Stack<T> newtempStack = new LinkedListStack<>();
                int newSize = container.getSize();
                for (int i = 1; i < newSize; i++) {
                    T tempValue = container.pop();
                    newtempStack.push(tempValue);
                    result = result + tempValue + ", ";
                }
                T tempValue = container.pop();
                newtempStack.push(tempValue);
                result = result + tempValue + "]";
                container = newtempStack;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
}
