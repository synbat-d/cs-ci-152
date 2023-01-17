package impl;

import adt.Set;

import java.util.EmptyStackException;

public class BST2Set<T extends Comparable> implements Set<T> {
    private OnOffTreeNode<T> root;
    private int size;

    public BST2Set() {
        root = null;
        size = 0;
    }

    @Override
    public void add(T value) {
        root = addHelper(root, value);
    }

    private OnOffTreeNode<T> addHelper(OnOffTreeNode<T> node, T value) {
        if (node == null) {
            size++;
            return new OnOffTreeNode<>(value);
        }
        if (node.getValue().compareTo(value) > 0) {
            node.setLeft(addHelper(node.getLeft(), value));
        } else if (node.getValue().compareTo(value) < 0) {
            node.setRight(addHelper(node.getRight(), value));
        } else {
            if (!node.isActive()) {
                node.switchOn();
                size++;
            }
        }
        return node;
    }

    @Override
    public boolean contains(T value) {
        return containsHelper(root, value);
    }

    private boolean containsHelper(OnOffTreeNode<T> node, T value) {
        if (node == null) {
            return false;
        }
        if (node.getValue().compareTo(value) > 0) {
            return containsHelper(node.getLeft(), value);
        } else if (node.getValue().compareTo(value) < 0) {
            return containsHelper(node.getRight(), value);
        } else {
            if (!node.isActive()) {
                return false;
            } else {
                return true;
            }
        }
    }

    @Override
    public boolean remove(T value) {
        if (!contains(value)) {
            return false;
        } else {
            root = removeHelper(root, value);
            size--;
            root = WasteManager(root);
            return true;
        }
    }

    @Override
    public T removeAny() throws Exception {
        if (size == 0) {
            throw new Exception("Empty Set, nothing to remove");
        }
        T result = minValue(root);
        if (remove(result)) {
            return result;
        } else {
            throw new Exception("something went wrong because of minValue() function in BST2Set class, because remove function gives false");
        }
    }

    private OnOffTreeNode<T> removeHelper(OnOffTreeNode<T> node, T value) {
        if (node == null) {
            return node;
        }
        if (node.getValue().compareTo(value) > 0) {
            node.setLeft(removeHelper(node.getLeft(), value));
        } else if (node.getValue().compareTo(value) < 0) {
            node.setRight(removeHelper(node.getRight(), value));
        } else {
            if (node.isActive()) {
                if (node.getLeft() == null && node.getRight() == null) {
                    node = null;
                } else if (node.getLeft() == null && node.getRight() != null) {
                    node = node.getRight();
                } else if (node.getLeft() != null && node.getRight() == null) {
                    node = node.getLeft();
                } else {
                    node.switchOff();
                }
            }
        }
        return node;
    }

    private T minValue(OnOffTreeNode<T> node) {
        if (node.getLeft() == null) {
            return node.getValue();
        }
        return minValue(node.getLeft());
    }

    private OnOffTreeNode<T> WasteManager(OnOffTreeNode<T> node) {
        if (node == null) {
            return null;
        }
        if (!node.isActive()) {
            if (node.getRight() == null && node.getLeft() == null) {
                node = null;
            } else if (node.getRight() == null && node.getLeft() != null) {
                node = node.getLeft();
            } else if (node.getRight() != null && node.getLeft() == null) {
                node = node.getRight();
            } else {
                node.setLeft(WasteManager(node.getLeft()));
            }
            return node;
        } else {
            if (node.getLeft() == null && node.getRight() != null) {
                node.setRight(WasteManager(node.getRight()));
            } else if (node.getLeft() != null && node.getRight() == null) {
                node.setLeft(WasteManager(node.getLeft()));
            } else if (node.getLeft() == null && node.getRight() == null) {
                node = node;
            } else {
                node.setLeft(WasteManager(node.getLeft()));
            }
            return node;
        }
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

    public String toStringHelper(OnOffTreeNode<T> node) {
        if (node == null) {
            return "";
        } else if (!node.isActive()) {
            return toStringHelper(node.getLeft()) + "" + toStringHelper(node.getRight());
        } else {
            return toStringHelper(node.getLeft()) + " {" + node.getValue() + "} " + toStringHelper(node.getRight());
        }
    }
}
