package com.ds.arrays.rotation;

import java.util.stream.IntStream;

/**
 Examples::
 
Input: arr[] = {1, 20, 2, 10}
Output: 72
We can 72 by rotating array twice.
{2, 10, 1, 20}
20*3 + 1*2 + 10*1 + 2*0 = 72

Input: arr[] = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
Output: 330
We can 330 by rotating array 9 times.
{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
0*1 + 1*2 + 2*3 ... 9*10 = 330
 *
 * @author ashutosh
 */
public class MaxSumOfArrByRotate {
    //brute force solution
    //Time Complexity O(n2)
    public void maxSumOfArrByRotate(int []arr){
        int maxIndex = findMaxIndex(arr);
        int rotation = arr.length - maxIndex;
        int r = arr.length - maxIndex -1;
        int sum =0;
        for(int i=maxIndex; i > -1; i--){
            sum = sum + arr[i]*rotation;
            rotation--;
        }
        for(int k=arr.length-1; k > maxIndex; k--){
            sum = sum + arr[k]*rotation;
            rotation--;
        }
        System.out.println("We can "+sum+" by rotating array "+r+" times.");
    }
    
    private int findMaxIndex(int [] arr) { 
     int max = arr[0]; 
     int maxIdx = 0; 
     for(int i = 1; i < arr.length; i++) { 
          if(arr[i] > max) { 
             max = arr[i]; 
             maxIdx = i; 
          } 
     } 
     return maxIdx; 
}
}
class MaxSumOfArrByRotateTest{
    public static void main(String[] args) {
        int arr[] = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int arr[] = {1, 20, 2, 10};
        MaxSumOfArrByRotate ms = new MaxSumOfArrByRotate();
        ms.maxSumOfArrByRotate(arr);
    }
}