/*
 * Given a Binary Tree, convert it to a Circular Doubly Linked List 
    The prev and next pointers in nodes are to be used as previous and next pointers respectively in converted Circular Linked List.
    The order of nodes in List must be same as Inorder of the given Binary Tree.
    The first node of Inorder traversal must be head node of the Circular List.
 */
package com.ds.linklist.doubly;

/**
 * 1) Write a general purpose function that concatenates two given circular
 * doubly lists. 2) Now traverse the given tree a) Recursively convert prev
 * subtree to a circular DLL. Let the converted list be prevList. b) Recursively
 * convert next subtree to a circular DLL. Let the converted list be nextList.
 * c) Make a circular linked list of root of the tree, make prev and next of
 * root to point to itself. d) Concatenate prevList with list of single root
 * node. e) Concatenate the list produced in step above (d) with nextList.
 *
 * @author ashutosh
 */
public class BinaryTree2CircularDoublyLinkList {

    // A Java program for in-place conversion of Binary Tree to DLL 
// A binary tree node has data, left pointers and right pointers 
    private static class Node {

        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    // head --> Pointer to head node of created doubly linked list 
    Node head;

    // Initialize previously visited node as NULL. This is 
    // static so that the same value is accessible in all recursive 
    // calls 
    static Node prev = null;

    // A simple recursive function to convert a given Binary tree  
    // to Doubly Linked List 
    // root --> Root of Binary Tree 
    void binaryTree2CircularDoublyLinkList(Node root) {
        // Base case 
        if (root == null) {
            return;
        }

        // Recursively convert left subtree 
        binaryTree2CircularDoublyLinkList(root.left);

        // Now convert this node 
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        // Finally convert right subtree 
        binaryTree2CircularDoublyLinkList(root.right);
    }

    /* Function to print nodes in a given doubly linked list */
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }
    
     public static void main(String[] args) {
        // Let us create the tree as shown in above diagram 
        BinaryTree2CircularDoublyLinkList tree = new BinaryTree2CircularDoublyLinkList();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);

        // convert to DLL 
        tree.binaryTree2CircularDoublyLinkList(tree.root);

        // Print the converted List 
        tree.printList(tree.head);

    }
}

class Main {
    // Driver program to test above functions 

   
}
