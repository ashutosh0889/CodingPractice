package com.ds.arrays;

/**
 *
 * @author ashutosh
 */
public class RotateByNOptimize {
    static void leftRotate(int arr[], int n, int d){ 
        /* To get the starting point of  
        rotated array */
        int mod = d % n; 
      
        // Prints the rotated array from  
        // start position 
        for(int i = 0; i < n; ++i) 
        System.out.print(arr[(i + mod) % n] + " ");  
          
        System.out.println(); 
    } 
     public static void main (String[] args){ 
            int arr[] = { 1, 3, 5, 7, 9 }; 
            int n = arr.length;  
  
            int k = 2; 
            leftRotate(arr, n, k); 
  
            k = 3; 
            leftRotate(arr, n, k); 
  
            k = 4; 
            leftRotate(arr, n, k); 
    } 
}
