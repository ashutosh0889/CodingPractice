package com.ds.linklist.doubly;

/**
 *
 * @author ashutosh
 */
public class DoublyLinkList<T> {

    Node< T> root;

    public void insert(T data) {
        if (root == null) {
            root = new Node<T>(data);
        } else {
            Node<T> newNode = new Node<T>(data);
            Node<T> current = root;
            while (current.next != null) {
                current = current.next;
            }
            newNode.prev = current;
            current.next = newNode;
        }
    }

    public void insertAfter(T data) {
        if (root == null) {
            root = new Node<T>(data);
        } else {
            Node<T> newNode = new Node<T>(data);
            Node<T> current = root;
            while (current.prev != null) {
                current = current.prev;
            }
            newNode.next = current;
            current.prev = newNode;
            root = newNode;
        }
    }

    public void insertAt(int index, T data) {
        if (size() >= index) {
            Node<T> newNode = new Node<T>(data);
            Node<T> current = root, prev = null;
            while (index > 0) {
                index--;
                prev = current;
                current = current.next;
            }
            if (prev == null) {
                newNode.next = current;
                current.prev = newNode;
                root = newNode;
            } else {
                prev.next = newNode;
                newNode.prev = prev;
                newNode.next = current;
                current.prev = newNode;
            }
        }
    }

    public int size() {
        return sizeRec(root);
    }

    private int sizeRec(Node<T> head) {
        if (head == null) {
            return 0;
        } else {
            return 1 + sizeRec(head.next);
        }
    }

    public void printList() {
        Node<T> current = root;
        while (current != null) {
            System.out.print(current.data + "    ");
            current = current.next;
        }
        System.out.println("\n");
    }

    public void deleteNode(T data) {
        if (root == null || data == null) {
            return;
        }
        Node<T> current = root, prev = null;
        while (current != null && !current.data.equals(data)) {
            prev = current;
            current = current.next;
        }
        if (prev == null) {
            root = current.next;
        } else {
            prev.next = current.next;
            current.next.prev = prev;
        }
    }

    /***
     * Time Complexity: O(n)
     */
    public void reverse(){
        if(root == null)
            return;
        Node<T> current = root, temp = null;
        while(current != null){
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if(temp != null)
            root = temp.prev;
    }
    
}

class DoublyLinkListTest {

    public static void main(String[] args) {
        DoublyLinkList<Integer> dll = new DoublyLinkList<>();
        dll.insert(10);
        dll.insert(20);
        dll.insert(30);
        dll.insert(40);
        dll.insertAfter(50);
        dll.insertAfter(60);
        dll.insertAt(2, 100);
        dll.printList();
        dll.deleteNode(100);
        dll.printList();
        
        dll.reverse();
        dll.printList();
    }
}
