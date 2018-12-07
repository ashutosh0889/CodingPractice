package com.ds.arrays;

public class HourGlass {
static int R = 6; 
static int C = 6; 
/***
 * In a arrrix total number of hour glass is (R-2)*(C-2)
 * @param [][]arr
 * @return Returns maximum sum of hour glass in [][]arr 
 */
static int findMaxSum(int [][]arr) { 
    if (R < 3 || C < 3) 
        return -1; 
  
    // Here loop runs (R-2)*(C-2)  
    // times considering different 
    // top left cells of hour glasses. 
    int max_sum = Integer.MIN_VALUE; 
    for (int i = 0; i < R - 2; i++) 
    { 
        for (int j = 0; j < C - 2; j++) 
        { 
            // Considering arr[i][j] as top  
            // left cell of hour glass. 
            int sum = (arr[i][j] + arr[i][j + 1] +  
                       arr[i][j + 2]) + (arr[i + 1][j + 1]) +  
                       (arr[i + 2][j] + arr[i + 2][j + 1] +  
                       arr[i + 2][j + 2]); 
  
            // If previous sum is less then  
            // current sum then update 
            // new sum in max_sum 
            max_sum = Math.max(max_sum, sum); 
        } 
    } 
    return max_sum; 
} 
     static public void main (String[] args){ 
        int [][]arr = {{1, 2, 3, 0, 0, 1}, 
                       {0, 0, 0, 0, 0, 1}, 
                       {2, 1, 4, 0, 0, 2}, 
                       {0, 0, 0, 0, 0, 1}, 
                       {1, 1, 0, 1, 0, 1},
                       {1, 5, 0, 8, 1, 1}}; 
        int res = findMaxSum(arr); 
        if (res == -1) 
            System.out.println("Not possible"); 
        else
            System.out.println("Maximum sum of hour glass = "
                                + res); 
    }
}

