package com.ds.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ashutosh
 */
public class pairInSortedRotatedArr {
       public boolean isPairInArrHash(int []arr, int sum){
           Set set = new HashSet();
           for(int pairFirstElement: arr){
               int pairSecElement = sum - pairFirstElement;
               if(set.contains(pairSecElement))
                   return true;
               else
                   set.add(pairFirstElement);
           }
           return false;
       }
       
       public boolean isPairInArr(int []arr, int sum){
           int len = arr.length;
           int i;
           for(i=0; i < len; i++){
               if(arr[i] > arr[i+1])
                   break;
           }
           //index of minimum element in arr
           int l = (i+1)%len;
           //pivote element index
           int d = i;
           //looping till l & d are not meet
           while(l != d){
               if(arr[l] + arr[d] == sum)
                   return true;
               //sum of pair is less move to higher value sum
               if(arr[l] + arr[d] < sum)
                   l = (l+1)%len;
               else
                   d = (len+d - 1)%len;
           }
           return false;
       }
}

class pairInStortedRotatedArrTest{
    public static void main(String[] args) {
        int arr[] = {11, 15, 6, 7, 9, 10}; 
        int sum = 16;
        pairInSortedRotatedArr p1 = new pairInSortedRotatedArr();
        
        System.out.println("Without Hashing...");
        System.out.println("Pair in Array ? "+ p1.isPairInArr(arr, sum));
        
        System.out.println("Using Hashing...");
        System.out.println("Pair in Array ? "+ p1.isPairInArrHash(arr, sum));
    }
}
