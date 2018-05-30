package com.ds.miscellaneous;

/**
 *
 * @author Ashutosh
 */
public class fibonacci {
    public static int fibo(int n){
        if(n <= 1)
            return n;
        return fibo(n-1)+fibo(n-2);
    }
    public static void main(String []args) {
        for(int i=0; i<10; i++)
            System.out.print(" "+ fibo(i));
    }
}
