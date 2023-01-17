package impl;

import adt.Set;

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
            return true;
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
                if(node.getLeft()==null && node.getRight()==null) {
                    node = null;
                }
            }
        }
        return node;
    }

    @Override
    public T removeAny() throws Exception {
        if (size==0) {
            throw new Exception("Empty set, nothing to remove");
        }
        else {

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
        }
        else {
        return toStringHelper(node.getLeft()) + " {" + node.getValue() + "} " + toStringHelper(node.getRight());}
    }
}
