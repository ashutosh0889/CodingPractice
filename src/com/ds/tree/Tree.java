package com.ds.tree;

/**
 *
 * @author ashutosh
 */
public interface Tree<T> {
    public void insertNode(T data);
    public void deleteNode(T data);
    public void travesal();
    public T getMaxValue();
    public T getMinValue();
    
}
