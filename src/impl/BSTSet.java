package impl;

import adt.Set;

public class BSTSet<T extends Comparable> implements Set<T> {
    private TreeNode<T> root;
    private int size;

    public BSTSet() {
        root = null;
        size = 0;
    }

    @Override
    public void add(T value) {
        root = addHelper(root, value);
    }

    private TreeNode<T> addHelper(TreeNode<T> node, T value) {
        if (node == null) {
            size++;
            return new TreeNode<>(value);
        } else {
            if (node.getValue().compareTo(value) > 0) {
                node.setLeft(addHelper(node.getLeft(), value));
            } else if (node.getValue().compareTo(value) < 0) {
                node.setRight(addHelper(node.getRight(), value));
            }
            return node;
        }
    }

    @Override
    public boolean contains(T value) {
        return checkNodes(root, value);
    }

    private boolean checkNodes(TreeNode<T> temp, T value) {
        if (temp == null) {
            return false;
        }
        if (temp.getValue().compareTo(value) == 0) {
            return true;
        } else if (temp.getValue().compareTo(value) > 0) {
            return checkNodes(temp.getLeft(), value);
        } else {
            return checkNodes(temp.getRight(), value);
        }

    }

    @Override
    public boolean remove(T value) {
        if (!contains(value)) {
            return false;
        } else {
            root = removeHelper(root, value);
            size--;
            return true;
        }
    }

    private TreeNode<T> removeHelper(TreeNode<T> node, T value) {
        if (node == null) {
            return node;
        }
        if (node.getValue().compareTo(value) > 0) {
            node.setLeft(removeHelper(node.getLeft(), value));
        } else if (node.getValue().compareTo(value) < 0) {
            node.setRight(removeHelper(node.getRight(), value));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }
            node.setValue(minValue(node.getRight()));
            node.setRight(removeHelper(node.getRight(), node.getValue()));
        }
        return node;
    }

    private T minValue(TreeNode<T> node) {
        if (node.getLeft() == null) {
            return node.getValue();
        }
        return minValue(node.getLeft());
    }

    @Override
    public T removeAny() throws Exception {
        if (size == 0) {
            throw new Exception("Set is empty, nothing to remove");
        }
        size--;
        T result = minValue(root);
        root = removeHelper(root, result);
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "Set is empty";
        }
        return toStringHelper(root);
    }

    public String toStringHelper(TreeNode<T> node) {
        if (node == null) {
            return "";
        }
        return toStringHelper(node.getLeft()) + " {" + node.getValue() + "} " + toStringHelper(node.getRight());
    }
}
