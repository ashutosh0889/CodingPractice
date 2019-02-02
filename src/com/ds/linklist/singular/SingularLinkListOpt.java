package com.ds.linklist.singular;

import java.util.HashSet;

/**
 *
 * @author ashutosh
 */
public class SingularLinkListOpt<T extends Comparable<T>> {
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
    
    public void printList() {
        Node current = root;
        while (current != null) {
            System.out.print(current.data + "    ");
            current = current.next;
        }
        System.out.println("\n");
    }
    
    //Remove duplicates from a sorted linked list
    public void removeDuplicates(){
    Node current = root;
    while(current != null && current.next != null){
        if(current.data.equals(current.next.data)){
            current.next = current.next.next;
        }else{
            current = current.next;
        }
    }
    }
    
     /* Function to remove duplicates from a 
       unsorted linked list */
    public void removeDuplicatesUN() { 
        // Hash to store seen values 
        HashSet<T> hs = new HashSet<>(); 
      
        /* Pick elements one by one */
        Node current = root; 
        Node prev = null; 
        while (current != null) { 
            T curval = (T) current.data; 
              
             // If current value is seen before 
            if (hs.contains(curval)) { 
                prev.next = current.next; 
            } else { 
                hs.add(curval); 
                prev = current; 
            } 
            current = current.next; 
        } 
    }
    

    /* Function to swap Nodes x and y in linked list by 
       changing links */
    public void swapNodes(int x, int y) 
    { 
        // Nothing to do if x and y are same 
        if (x == y) return; 
  
        // Search for x (keep track of prevX and CurrX) 
        Node prevX = null, currX = root; 
        while (currX != null && !currX.data.equals(x)) 
        { 
            prevX = currX; 
            currX = currX.next; 
        } 
  
        // Search for y (keep track of prevY and currY) 
        Node prevY = null, currY = root; 
        while (currY != null && !currY.data.equals(y)) 
        { 
            prevY = currY; 
            currY = currY.next; 
        } 
  
        // If either x or y is not present, nothing to do 
        if (currX == null || currY == null) 
            return; 
  
        // If x is not head of linked list 
        if (prevX != null) 
            prevX.next = currY; 
        else //make y the new head 
            root = currY; 
  
        // If y is not head of linked list 
        if (prevY != null) 
            prevY.next = currX; 
        else // make x the new head 
            root = currX; 
  
        // Swap next pointers 
        Node temp = currX.next; 
        currX.next = currY.next; 
        currY.next = temp; 
    } 
    /***
     * if the linked list is 1->2->3->4->5->6 then the function should change it to 2->1->4->3->6->5.
     */
    void pairWiseSwap() { 
        Node current = root; 
  
        /* Traverse only till there are atleast 2 nodes left */
        while (current != null && current.next != null) { 
  
            /* Swap the data */
            T k = (T)current.data; 
            current.data = current.next.data; 
            current.next.data = k; 
            current = current.next.next; 
         } 
    } 
    
    public void moveToFront(){
        Node current = root, prev=null;
        
        while(current.next != null){
            prev = current;
            current = current.next;
        }
        Node temp = root;
        root = current;
        current.next = temp.next;
        temp.next = null;
        prev.next = temp;
        
    }
    
    //Merge two sorted linked lists
    public Node mergeLists(Node headA, Node headB){
        Node dummy = new Node(0);
        Node tail = dummy;
        while(true){
            if(headA == null){
                tail.next = headB;
                break;
            }
            if(headB == null){
                tail.next = headA;
                break;
            }
            if(((T)headA.data).compareTo((T)headB.data) < 0){
                tail.next = headA;
                headA = headA.next;
            }else{
                tail.next = headB;
                headB = headB.next;
            }
            tail = tail.next;
        }
    return dummy.next;
    }
    
    private int sizeRec(Node head) {
        if (head == null) {
            return 0;
        } else {
            return sizeRec(head.next) + 1;
        }

    }
    
    //Intersection point of two sorted linked lists
    public T getInterSectionPoint(Node headA, Node headB){
        int c1 = this.sizeRec(headA);
        int c2 = this.sizeRec(headB);
        if(c1 > c2){
            int d = c1 - c2;
            return getInterSectionPoint(d,headA,headB);
        }else{
            int d = c2 - c1;
            return getInterSectionPoint(d,headA,headB);
        }
    }
    
     private T getInterSectionPoint(int d,Node headA, Node headB){
         Node temp1 = headA;
         Node temp2 = headB;
         
         for (int i = 0; i < d; i++) { 
            if (temp1 == null) { 
                return null; 
            } 
            temp1 = temp1.next; 
        } 
         while(temp1 != null && temp2 != null){
             if(((T)temp1.data).compareTo((T)temp2.data) == 0){
                 return (T) temp1.data;
             }else{
                 temp1 = temp1.next;
                 temp2 = temp2.next;
             }
         }
     return null;
     }
}



class TestSingularLinkListOpt {

    public static void main(String[] args) {
        SingularLinkListOpt s1 = new SingularLinkListOpt();
        s1.insert(10);
        s1.insert(20);
        s1.insert(30);
        s1.insert(50);
        s1.insert(10);
        
         System.out.println("Before removing dublicates.");
        s1.printList();
        
        s1.removeDuplicatesUN();
        System.out.println("After removing dublicates.");
        s1.printList();
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("Before swaping nodes.");
        s1.printList();
        s1.swapNodes(10, 50);
        System.out.println("After swaping nodes.");
        s1.printList();
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        
        SingularLinkListOpt s2 = new SingularLinkListOpt();
        s2.insert(5); 
        s2.insert(4); 
        s2.insert(3); 
        s2.insert(2); 
        s2.insert(1); 
        System.out.println("Before Pairwise swap...");
        s2.printList();
        
        s2.pairWiseSwap();
        System.out.println("After Pairwise swap...");
        s2.printList();
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("Swaping last element to front");
        s2.moveToFront();
        s2.printList();
        
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        SingularLinkListOpt s3 = new SingularLinkListOpt();
        SingularLinkListOpt s4 = new SingularLinkListOpt();
        SingularLinkListOpt s5 = new SingularLinkListOpt();
        
        s3.insert(1);
        s3.insert(3);
        s3.insert(5);
        s4.insert(2);
        s4.insert(4);
        s4.insert(6);
        System.out.println("Before Merging Lists.");
        s3.printList();
        s4.printList();
        s5.root = s5.mergeLists(s3.root, s4.root);
        System.out.println("After Merging Lists");
        s5.printList();
        
        System.out.println("Intersection point of these sorted lists "+ s5.getInterSectionPoint(s5.root, s4.root));
    }
}
