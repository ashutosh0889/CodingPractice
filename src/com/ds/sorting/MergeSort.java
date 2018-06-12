package com.ds.sorting;

/**
 *
 * @author Ashutosh
 */
public class MergeSort {
    public void mergeSort(int []arr,int minIndex,int maxIndex){
        if(minIndex < maxIndex){
        int mid = (minIndex+maxIndex)/2;
        
        mergeSort(arr,minIndex,mid);
        mergeSort(arr,mid+1,maxIndex);
        
        merge(arr,minIndex,mid,maxIndex);
        }
    }
    private void merge(int []arr,int minIndex,int mid,int maxIndex){
        int n1 = mid-minIndex+1;
        int n2 = maxIndex-mid;
        
        int []left = new int[n1];
        int []right = new int[n2];
        
        for(int i=0; i<n1; i++)
            left[i]=arr[minIndex+i];
        for(int j=0; j<n2; j++)
            right[j]=arr[mid+1+j];
        
        int i=0;int j=0;
        
        
        int k=minIndex;
        
        while(i < n1 && j < n2){
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            }else{
                arr[k]=right[j];
                j++;
            }
            k++;
        }
        
        while(i<n1){
            arr[k]=left[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=right[j];
            j++;
            k++;
        }
    } 
}

class MergeSortTest{
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void main(String[] args) {
         int arr[] = {12, 11, 13, 5, 6, 7};
         MergeSort ms = new MergeSort();
         
         System.out.println("Given Array");
         printArray(arr);
         
         ms.mergeSort(arr, 0, arr.length-1);
         
        System.out.println("\nSorted array");
        printArray(arr);
    }
}