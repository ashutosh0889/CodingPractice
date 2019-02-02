package com.ds.linklist.singular;

import jdk.nashorn.internal.objects.NativeArray;

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

    private int sizeRec(Node head) {
        if (head == null) {
            return 0;
        } else {
            return sizeRec(head.next) + 1;
        }

    }

    public int size() {
        return sizeRec(root);
    }

    private void searchRec(Node head, T data, int i) {
        if (data == null || head == null) {
            return;
        }
        if (head.data.equals(data)) {
            System.out.println("Found at " + i + "\n");
        } else {
            i = i + 1;
            searchRec(head.next, data, i);
        }
    }

    public void search(T data) {
        searchRec(root, data, 0);
    }

    public Node nthNodeFormLast(int i) {
        Node current = root, next = root;
        if (this.size() >= i) {
            for (int k = 0; k < i; k++) {
                next = next.next;
            }
            while (next != null) {
                current = current.next;
                next = next.next;
            }
            return current;
        } else {
            System.out.println("IndexOutOfBound");
            return null;
        }
    }

    public Node middle() {
        if (root != null) {
            Node current = root, next = root;
            while (next != null && next.next != null) {
                current = current.next;
                next = next.next.next;
            }
            return current;
        }
        System.out.println("List is Empty!!");
        return null;
    }

    public void reverse() {
        Node current = root, prev = null, next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        root = prev;
    }

    /**
     * METHOD 1 (Use a Stack) A simple solution is to use a stack of list
     * nodes. This mainly involves three steps. 1) Traverse the given list from
     * head to tail and push every visited node to stack. 2) Traverse the list
     * again. For every visited node, pop a node from stack and compare data of
     * popped node with currently visited node. 3) If all nodes matched, then
     * return true, else false.
     *
     * Time complexity of above method is O(n), but it requires O(n) extra
     * space. Following methods solve this with constant extra space.
     *
     *
     * METHOD 2 (By reversing the list) This method takes O(n) time and O(1)
     * extra space. 1) Get the middle of the linked list. 2) Reverse the second
     * half of the linked list. 3) Check if the first half and second half are
     * identical. 4) Construct the original linked list by reversing the second
     * half again and attaching it back to the first half
     */
    boolean isPalindrome() {
        Node current=root, next=root, prevofnext=null,middle=null, secondHalf=null;
     if(current != null && current.next != null){   
        while (next != null && next.next != null) {
                next = next.next.next;
                prevofnext = current;
                current = current.next;
            }
       /* next would become NULL when there are even elements  
               in the list and not NULL for odd elements. We need to skip   
               the middle node for odd case and store it somewhere so that 
               we can restore the original list */
            if(next != null){
                middle = current;
                current = current.next;
            }
            secondHalf = current;
            prevofnext.next = null;
            reverse();
            boolean result = compareLists(root, secondHalf); 
            reverse();
            if (middle != null) { 
                // If there was a mid node (odd size case) which                                                          
                // was not part of either first half or second half. 
                prevofnext.next = middle; 
                middle.next = secondHalf; 
            } else
                prevofnext.next = secondHalf;
            return result;
    }
        return false;
    }

    public void printList() {
        Node current = root;
        while (current != null) {
            System.out.print(current.data + "    ");
            current = current.next;
        }
        System.out.println("\n");
    }
    
    public void reversePrintList(Node head){
        if(head == null)
            return;
        reversePrintList(head.next);
        System.out.println(head.data);
    }

    private boolean compareLists(Node head1, Node head2) {
        Node temp1=head1;
        Node temp2=head2;
        
        while(temp1 != null && temp2!=null){
            if(temp1.data.equals(temp2.data)){
                temp1 = temp1.next;
                temp2 = temp2.next;
            }else{
                return false;
            }
        }
        /* Both are empty reurn 1*/
        if (temp1 == null && temp2 == null) 
            return true; 
        return false;
    }
    
    public int countNodesinLoop(){
    Node current = root, next = root;
    
    while(next != null && next.next != null){
        current = current.next;
        next = next.next.next;
        if(current.data.equals(next.data))
            return countNodes(current);
    }
    return 0;
}

    private int countNodes(Node node) {
        Node temp = node;
        int count = 0;
        while(!temp.data.equals(node.data))
            count++;
        return count;
    }
}

class TestSingularLinkList {

    public static void main(String[] args) {
        SingularLinkList s1 = new SingularLinkList();
        SingularLinkList s2 = new SingularLinkList();
        s1.insert(10);
        s1.insert(20);
        s1.insert(30);
        s1.insert(60);
        s1.insertAfter(50);
        s1.printList();

        s1.delete(60);
        System.out.println("After Deleting 30");
        s1.printList();

        System.out.println("Size of the List is " + s1.size() + "\n");
        System.out.println("Searching element 10");
        s1.search(10);

        int n = 4;
        System.out.println(n + "th Element form the last is " + s1.nthNodeFormLast(n).data + "\n");
        
         s1.insert(60);
        System.out.println("Middle Element of the list is " + s1.middle().data);
        
        s1.reverse();
        System.out.println("Reversed List is ");
        s1.printList();
        
//        s1.root.next.next.next.next.next = s1.root.next; 
//        System.out.println("No of Nodes in Loop " +s1.countNodesinLoop());
//        s1.printList();
        
        char str[] = {'a', 'b', 'a', 'c', 'a', 'b', 'a'}; 
        for(char c : str){
            s2.insert(c);
        }
        System.out.println("Is List is Palindrome ? "+ s2.isPalindrome());
    }
}
