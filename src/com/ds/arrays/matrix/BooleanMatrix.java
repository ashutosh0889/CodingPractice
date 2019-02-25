package com.ds.arrays.matrix;

import java.util.Arrays;

/**
 *
 * @author Ashutosh
 */
public class BooleanMatrix {
    public static void modifyMatrix(int [][]arr,int m,int n){
        int []row = new int[m];
        int []col = new int[n];
        Arrays.fill(row, 0);
        Arrays.fill(col, 0);
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]==1){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(row[i]==1 || col[j]==1){
                    arr[i][j]=1;
                }
            }
        }
        
    }
    
    /* A utility function to print a 2D matrix */
    public static void printMatrix(int arr[ ][ ], int m, int n){
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                   System.out.print(" "+arr[i][j]+" "); 
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args){
        int mat[ ][ ] = { {1, 0, 0, 1},
                          {0, 0, 1, 0},
                          {0, 0, 0, 0},};
                     
                System.out.println("Matrix Intially");
                 
                printMatrix(mat, 3, 4);
             
                modifyMatrix(mat, 3, 4);
                System.out.println("Matrix after modification n");
                printMatrix(mat, 3, 4);
    }
}
