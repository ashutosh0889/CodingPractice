package com.ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Ashutosh
 */
public class SubArray {
    
  public int[] maxNonNegSubArray(int []arr){
      int len = arr.length;
      int sum=0;
      for(int i=0; i<len; i++){
          int current_count=0;
          while(i<len && arr[i]>=0){
              current_count++;
              i++;
          }
         sum = Math.max(sum, current_count);
      }
  return null;
  }
  public List<Integer> maxNonNegSubArray(List<Integer> A){
      int maxSum = 0;
      int newSum = 0;
      List<Integer> maxArray = new ArrayList<Integer>();
      List<Integer> newArray = new ArrayList<Integer>();
      
      for(int i : A){
          if(i >= 0 ){
              newSum += i;
              newArray.add(i);
          }else{
              newSum = 0;
              newArray = new ArrayList<Integer>();
          }
          if(maxSum < newSum || maxSum == newSum || maxArray.size() < newArray.size()){
              maxSum = newSum;
              maxArray = newArray;
          }
      }
  return maxArray;
  }
  public int getRepeatingEle(int[] arr){
      for(int i=0; i<arr.length; i++){
          if(arr[Math.abs(arr[i])] >= 0)
              arr[Math.abs(arr[i])]= -arr[Math.abs(arr[i])];
          else
              return Math.abs(arr[i]);
      }
    return -1;
  } 
}

class TestSubArray{
    public static void main(String[] args) {
         int arr[] = {1, 0, 4, 0, 1, -1,
                        -1, 0, 0, 1, 0};
         SubArray sa = new SubArray();
         sa.maxNonNegSubArray(arr);
         List l = new ArrayList();
         for(int i : arr)
             l.add(i);
         sa.maxNonNegSubArray(l);
          int arr1[] = {1, 2, 3, 1, 3, 6, 6};
          System.out.println("Repeated Ele:: "+sa.getRepeatingEle(arr));
    }
}