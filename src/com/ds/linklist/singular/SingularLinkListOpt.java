package com.ds.linklist.singular;

import java.util.HashSet;

/**
 *
 * @author ashutosh
 */
public class SingularLinkListOpt<T extends Comparable<T>> {
    Node head;

    public void insert(T data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(data);
        }
    }
    
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "    ");
            current = current.next;
        }
        System.out.println("\n");
    }
    
    //Remove duplicates from a sorted linked list
    public void removeDuplicates(){
    Node<T> current = head;
    while(current != null){
        Node<T> temp =  current;
        while(current.data.equals(temp.data)){
                temp = temp.next;
        }
        current.next = temp;
        current = current.next;
    }
    }
    //
    public void removeAllDuplicatedNodes(){
        
        /* create a dummy node that acts like a fake 
          head of list pointing to the original head*/
        Node<T> dummy = new Node(0); 
  
        /* dummy node points to the original head*/
        dummy.next = head; 
        Node<T> prev = dummy; 
        Node<T> current = head; 
  
        while (current != null) 
        { 
            /* Until the current and previous values 
               are same, keep updating current */
            while (current.next != null && prev.next.data.equals(current.next.data)) 
                current = current.next; 
  
            /* if current has unique value i.e current 
                is not updated, Move the prev pointer 
                to next node*/
            if (prev.next == current) 
                prev = prev.next; 
  
            /* when current is updated to the last 
               duplicate value of that segment, make 
               prev the next of current*/
            else
                prev.next = current.next; 
  
            current = current.next; 
        } 
  
        /* update original head to the next of dummy 
           node */
        head = dummy.next; 
    }
     /* Function to remove duplicates from a 
       unsorted linked list */
    public void removeDuplicatesUN() { 
        // Hash to store seen values 
        HashSet<T> hs = new HashSet<>(); 
      
        /* Pick elements one by one */
        Node current = head; 
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
        Node prevX = null, currX = head; 
        while (currX != null && !currX.data.equals(x)) 
        { 
            prevX = currX; 
            currX = currX.next; 
        } 
  
        // Search for y (keep track of prevY and currY) 
        Node prevY = null, currY = head; 
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
            head = currY; 
  
        // If y is not head of linked list 
        if (prevY != null) 
            prevY.next = currX; 
        else // make x the new head 
            head = currX; 
  
        // Swap next pointers 
        Node temp = currX.next; 
        currX.next = currY.next; 
        currY.next = temp; 
    } 
    /***
     * if the linked list is 1->2->3->4->5->6 then the function should change it to 2->1->4->3->6->5.
     */
    void pairWiseSwap() { 
        Node current = head; 
  
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
        Node current = head, prev=null;
        
        while(current.next != null){
            prev = current;
            current = current.next;
        }
        Node temp = head;
        prev.next = null;
        current.next = temp;
        head = current;        
    }
    
    private void moveToLast(Node<T> pre,Node<T> current){
        if(pre == null){
            head = current.next;
            current.next = null;
            Node<T> temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = current;
        }else{
            Node temp = current.next;
           pre.next = current.next;
           current.next = null;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = current;
        }
    }
    
    //Segregate even and odd nodes in a Linked List
    public void segregateList(){
        Node<T>  current = head, pre=null;
        while(current != null){
            if(!(Integer.parseInt(current.data.toString()) % 2 == 0))
                moveToLast(pre,current);
            else{
                pre = current;
                current = current.next;
            }
        }
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
    //merging two sorted link list using recursion 
    public Node sortedMerge(Node<T> headA, Node<T> headB) { 
        if(headA == null) return headB; 
        if(headB == null) return headA; 
          
        if(((T)headA.data).compareTo((T)headB.data) < 0) { 
            headA.next = sortedMerge(headA.next, headB); 
            return headA; 
        } else { 
            headB.next = sortedMerge(headA, headB.next); 
            return headB; 
        } 
          
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
        s5.head = s5.sortedMerge(s3.head, s4.head);
        System.out.println("After Merging Lists");
        s5.printList();
        System.out.println("Intersection point of these sorted lists "+ s5.getInterSectionPoint(s5.head, s4.head));
       // s5.segregateList();
        s5.printList();
    }
}
