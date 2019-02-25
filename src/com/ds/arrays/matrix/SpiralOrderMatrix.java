package com.ds.arrays.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ashutosh
 */
public class SpiralOrderMatrix{
    public void spiralOrder(int [][]arr,int m,int n){
    int t = 0 ; int b = m-1; int l = 0; int r = n-1;
    int dir=0;
        while(t<=b && l<=r){
        switch (dir) {
            case 0:
                for(int i=l; i<= r; i++)
                    System.out.print(" "+ arr[t][i]+" ");
                t++;
                dir = 1;
                break;
            case 1:
                for(int i=t; i<=b; i++)
                    System.out.print(" "+arr[i][r]+" ");
                r--;
                dir = 2;
                break;
            case 2:
                for(int i=r; i>=l; i--)
                    System.out.print(" "+arr[b][i]+" ");
                b--;
                dir = 3;
                break;
            case 3:
                for(int i=b; i>=t; i--)
                    System.out.print(" "+arr[i][l]+" ");
                l++;
                dir = 0;
                break;
            default:
                break;
        }
        }
    }
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        int m = A.size();
        int n = A.get(0).size();
        int t = 0; int b = m-1; int l = 0; int r = n-1;
        int dir = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while(t <=b && l<= r){
            switch(dir){
                case 0:
                  for(int i=l; i<= r; i++)
                      result.add(A.get(t).get(i));
                  t++;
                  dir = 1;
                  break;
                case 1:
                  for(int i=t; i<= b; i++)
                      result.add(A.get(i).get(r));
                  r--;
                  dir = 2;
                  break;
                case 2:
                    for(int i=r; i>= l; i--)
                      result.add(A.get(b).get(i));
                    b--;
                    dir = 3;
                    break;
                case 3:
                    for(int i=b; i>= t; i--)
                      result.add(A.get(i).get(l));
                    l++;
                    dir = 0;
                    break;
            }
        }
      return result;  
    }
    public ArrayList<ArrayList<Integer>> generateMatrix(int m){
        int n = m*m;
        ArrayList<Integer> temp = new ArrayList<>(m);
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for(int i=1; i<=n; i++){
            temp.add(i);
            if(temp.size() == m){
                A.add((ArrayList<Integer>)temp.clone());
                temp.clear();
            }   
        }
    return A;
    }
    public ArrayList<ArrayList<Integer>> generateSpiralOrderMatrix(int n){
        int t = 0; int b = n-1; int l = 0; int r = n-1;
        int dir = 0;
        int k=1;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>(n);
        for(int e=0; e<n; e++){
            temp.add(0);
        }
        for(int i=0; i<n; i++){
            result.add((ArrayList<Integer>)temp.clone());
        }
        while(k <= n*n){
            switch(dir){
                case 0:
                    for(int i=l; i<=r; i++){
                        result.get(t).set(i,k);
                        k++;
                    }
                    t++;
                    dir = 1;
                    break;
                case 1:
                    for(int i=t; i<=b; i++){
                        result.get(i).set(r,k);
                        k++;
                    }
                    r--;
                    dir = 2;
                    break;
                case 2:
                    for(int i=r; i>=l; i--){
                        result.get(b).set(i,k);
                        k++;
                    }
                    b--;
                    dir = 3;
                    break;
                case 3:
                    for(int i=b; i>=t; i--){
                        result.get(i).set(l,k);
                        k++;
                    }
                    l++;
                    dir = 0;
                    break;
            }
        }
    return result;
    }
    public int[][] generateMatrix1(int n) {
    int[][] result = new int[n][n];
 
    int k=1; 
    int top=0;
    int bottom=n-1;
    int left=0;
    int right=n-1;
 
    while(k<=n*n){
        for(int i=left; i<=right; i++){
            result[top][i]=k;
            k++;
        }    
        top++;
 
        for(int i=top; i<=bottom; i++){
            result[i][right]=k;
            k++;
        }
        right--;
 
        for(int i=right; i>=left; i--){
            result[bottom][i]=k;
            k++;
        }
        bottom--;
 
        for(int i=bottom; i>=top; i--){
            result[i][left] = k;
            k++;
        }
        left++;
    }
 
    return result;
}
}

class TestSpiralOrderMatrix{
    public static void main(String[] args) {
        int [][]arr = {
        { 1, 2, 3 },
        { 4, 5, 6 },
        { 7, 8, 9 }
        };
        SpiralOrderMatrix som = new SpiralOrderMatrix();
        som.spiralOrder(arr, 3, 3);
        System.out.println("\nSpiral Order Matrix Using ArrayList...");
//        System.out.println(som.generateMatrix1(3));
//        List<ArrayList<Integer>> A = som.generateMatrix(3);
//        System.out.println(som.spiralOrder(A));
//        System.out.println("\nGenerating Spiral Order Matrix....");
        System.out.print(som.generateSpiralOrderMatrix(3));
    }

}



