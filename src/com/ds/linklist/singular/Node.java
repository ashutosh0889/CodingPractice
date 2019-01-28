package com.ds.linklist.singular;

/**
 *
 * @author ashutosh
 */
public class Node<T> {
    T data;
    Node next;
    
    Node(T data){
        this.data = data;
        this.next = null;
    }
}
