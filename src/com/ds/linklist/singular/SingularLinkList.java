package com.ds.linklist.singular;

/**
 *
 * @author ashutosh
 */
public class SingularLinkList<T> {

    Node root;

    public void insert(T data) {
        if (root == null) {
            root = new Node(data);
        } else {
            Node current = root;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(data);
        }
    }

    public void insertAfter(T data) {
        Node node = new Node(data);

        if (root == null) {
            root = node;
        } else {
            node.next = root;
            root = node;
        }
    }

    public void delete(T data) {
        if (data == null || root == null) {
            return;
        } else {
            Node current = root, prev = null;
            if (current != null && current.data.equals(data)) {
                root = current.next;
            } else {
                while (current != null && !current.data.equals(data)) {
                    prev = current;
                    current = current.next;
                }
                prev.next = current.next;
            }

        }
    }

    public void printList() {
        Node current = root;
        while (current != null) {
            System.out.print(current.data + "    ");
            current = current.next;
        }
    }
}

class TestSingularLinkList {

    public static void main(String[] args) {
        SingularLinkList s1 = new SingularLinkList();
        s1.insertAfter(10);
        s1.insertAfter(20);
        s1.insertAfter(30);
        s1.delete(30);
        s1.printList();
    }
}
