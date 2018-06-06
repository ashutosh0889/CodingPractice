package com.ds.sorting;

/**
 *
 * @author Ashutosh
 */
public class QuickSort {
    
    public void quickSort(int []arr,int minIndex,int maxIndex){
        if(minIndex < maxIndex){
        int partition = partitionIndex(arr,minIndex,maxIndex);
        quickSort(arr,minIndex,partition-1);
        quickSort(arr,partition+1,maxIndex);
        }
    }
    private int partitionIndex(int[] arr, int minIndex, int maxIndex) {
        
            int pivot = arr[maxIndex];
            int i = minIndex-1;
            for(int j=minIndex; j<maxIndex; j++){
                if(arr[j] <= pivot){
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            int temp = arr[i+1];
                arr[i+1] = arr[maxIndex];
                arr[maxIndex] = temp;
        return i+1;
    }
    public void print(int []arr){
        for(int i=0; i<arr.length; i++)
            System.out.print(" "+arr[i]+" ");
    }
}

class QuickSortTest{
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int arr[] = {10, 7, 8, 9, 1, 5};
        qs.quickSort(arr, 0, arr.length-1);
        qs.print(arr);
    }
}