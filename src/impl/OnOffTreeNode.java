package impl;

public class OnOffTreeNode<T> {


    private T value;

    private OnOffTreeNode<T> left;
    private OnOffTreeNode<T> right;

    private boolean active;

    /**
     * Construct a tree node with the given value,
     * and null children links
     *
     * @param val to set on the node
     */
    public OnOffTreeNode(T val) {
        value = val;
        active = true;
        left = null;
        right = null;
    }

    /**
     * @return the value
     */
    public T getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * @return the left
     */
    public OnOffTreeNode<T> getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(OnOffTreeNode<T> left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public OnOffTreeNode<T> getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(OnOffTreeNode<T> right) {
        this.right = right;
    }

    public boolean isActive() {
        return this.active;
    }

    public void switchOff() {
        this.active = false;
    }

    public void switchOn() {
        this.active = true;
    }

    /**
     * @return the string representation of the value
     */
    @Override
    public String toString() {
        return value.toString();
    }
}
