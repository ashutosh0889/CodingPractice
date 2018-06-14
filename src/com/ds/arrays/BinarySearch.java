package com.ds.arrays;

import com.ds.sorting.MergeSort;
import com.ds.sorting.QuickSort;

/**
 * Time Complexity: In Worst Case O(mLogm + nLogm) if we use MergeSort And O(n2) is we use QuickSort
 * @author Ashutosh
 */
public class BinarySearch {
    public int binarySearch(int []arr,int minIndex,int maxIndex, int x){
        if(minIndex <= maxIndex){
            int mid = (minIndex+maxIndex)/2;
            if(( mid == 0 || x > arr[mid-1]) && (arr[mid] == x))
                return mid;
            else if(x > arr[mid])
                return binarySearch(arr,mid+1,maxIndex,x);
            else if(x < arr[mid])
                return binarySearch(arr, minIndex, mid-1, x);
        }
    return -1;
    }
    
    public boolean isSubSet(int []arr1,int []arr2){
        int m = arr1.length;
        int n = arr2.length;
        new MergeSort().mergeSort(arr1, 0, arr1.length-1);
        for(int i=0; i<n; i++)
            if(binarySearch(arr1, 0, m-1, arr2[i]) == -1)
                return false;
        
        return true;
    }
}

class BinarySearchTest{
    public static void main(String[] args) {
        int arr1[] = {11, 1, 13, 21, 3, 7};
        int arr2[] = {11, 3, 7, 1};
        BinarySearch bs = new BinarySearch();
        if(bs.isSubSet(arr1, arr2))
          System.out.print("arr2[] is subset of arr1[] ");
        else
          System.out.print("arr2[] is not a subset of arr1[]");  
    }
}
