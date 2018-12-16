package com.ds.tree;

/**
 *
 * @author ashutosh
 */
public class Node<T> {
    private T data;
    private Node<T> leftChild;
    private Node<T> rightChild;

    public Node(T data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return the leftChild
     */
    public Node<T> getLeftChild() {
        return leftChild;
    }

    /**
     * @param leftChild the leftChild to set
     */
    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * @return the rightChild
     */
    public Node<T> getRightChild() {
        return rightChild;
    }

    /**
     * @param rightChild the rightChild to set
     */
    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }
}
