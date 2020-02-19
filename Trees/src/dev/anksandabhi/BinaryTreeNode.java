package dev.anksandabhi;

public class BinaryTreeNode<T extends Comparable> implements Comparable {
    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "value=" + value +
                '}';
    }

    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }


    private BinaryTreeNode<T> left;
    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }


    private BinaryTreeNode<T> right;
    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }


    @Override
    public boolean equals(Object o) {
        return this.value.equals(((BinaryTreeNode<T>) o).getValue());
    }

    @Override
    public int compareTo(Object o) {
        return this.value.compareTo(((BinaryTreeNode<T>) o).getValue());
    }
}
