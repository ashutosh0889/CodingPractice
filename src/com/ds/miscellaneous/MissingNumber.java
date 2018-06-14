package com.ds.miscellaneous;

/**
 * Number Must be in 0 to Nth Range.
 * Time Complexity : O(n) For Both method
 * @author Ashutosh
 */
public class MissingNumber {
    /***
     *  1. Get the sum of numbers 
            total = n*(n+1)/2
        2 Subtract all the numbers from sum and
            you will get the missing number.
     */
    public int getMissingNumUsingSum(int arr[])
    {
        int n = arr.length;
        int i, total;
        total  = (n+1)*(n+2)/2;   
        for ( i = 0; i< n; i++)
           total -= arr[i];
        return total;
    }
    /***
        1) XOR all the array elements, let the result of XOR be X1.
        2) XOR all numbers from 1 to n, let XOR be X2.
        3) XOR of X1 and X2 gives the missing number.
     */
    public int getMissingNumUsingXOR(int arr[]){
        int n = arr.length;
        int x1 = arr[0];
        int x2 = 1;
        
        for(int i=1; i<arr.length; i++)
            x1 = x1 ^ arr[i];
        for(int i=2; i<=arr.length+1; i++)
            x2 = x2 ^ i;
        
    return (x1 ^ x2);
    }
}

class MissingNumberTest{
    public static void main(String args[])
    {
        MissingNumber mn = new MissingNumber();
        int arr[] = {1,2,4,5,6};
        
        System.out.println("Missing Numbers is:: "+ mn.getMissingNumUsingXOR(arr));   
    }
}