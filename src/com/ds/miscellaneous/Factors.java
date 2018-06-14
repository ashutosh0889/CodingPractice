package com.ds.miscellaneous;

/**
 *
 * @author Ashutosh
 */
public class Factors {
    public void primeFactors(int n){
        if(n%2 == 0){
            System.out.println(2 +" ");
            n /= 2;
        }
    }
    public void allFectors(int n){
        primeFactors(n);
        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for(int i=3; i<Math.sqrt(n); i+=2){
            System.out.println(i+" ");
            n /= i;
        }
        if(n > 2)
            System.out.println(n+" ");
    }
    
    /***
     *  153 = 1*1*1 + 5*5*5 + 3*3*3  
        =  1 + 125 + 27
        =  153        
        Therefore, 153 is an Armstrong number.
     */
    public void armstrongNumber(int min, int max){
        for (int i = min + 1; i < max; ++i){
            // number of digits calculation
            int x = i;
            int n = 0;
            while(x!=0){
                x /= 10;
                ++n;
            }
            x = i;
            int pow_sum = 0;
            while(x!=0){
                int digit = x % 10;
                pow_sum += Math.pow(digit, n);
                x /= 10;
            }
            if(pow_sum == i)
                System.out.println(i + " ");
        }
        
    }
}

class FactorsTest{
    public static void main(String[] args) {
        Factors f = new Factors();
        System.out.println("Factors of "+ 10000);
        f.allFectors(10000);
        
        System.out.println("Armstrong numbers in 1 to 500");
        f.armstrongNumber(100, 400);
    }
}
