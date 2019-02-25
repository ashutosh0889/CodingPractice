package com.ds.arrays;

/**
 *
 * @author ashutosh
 */
public class RotateByNOptimize {

    /**
     * The Reversal Algorithm Reverse A to get ArB, where Ar is reverse of A.
     * Reverse B to get ArBr, where Br is reverse of B. Reverse all to get
     * (ArBr) r = BA.
     *
     */

    private void reverse(int[] arr, int start, int end) {
        int temp = arr[start];
        for (int i = start; i < end; i++) {
            arr[i] = arr[i + 1];
        }
        arr[end] = temp;
    }

    public void reversalArr(int[] arr, int d) {
        int len = arr.length;
        reverse(arr, 0, d);
        reverse(arr, d , len-1);
        reverse(arr, 0, len-1);
    }

    public void print(int[] arr) {
        for (int k : arr) {
            System.out.print("  " + k);
        }
        System.out.println("\n");
    }
}

class RotateByNOptimizeTest {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        RotateByNOptimize rno = new RotateByNOptimize();
        System.out.println("Before Rotating");
        rno.print(arr);
        rno.reversalArr(arr, 2);
        System.out.println("After Rotating");
        rno.print(arr);
    }
}
