package com.arrays;

//50. Pow(x, n)
//https://leetcode.com/problems/powx-n/description/
public class PowXN {
    //SOl
    public double myPow(double x, int n) {
        double ans=1;
        double num= x;
        long pow=Math.abs((long)n);

        while(pow > 0){
            if(pow %2 == 0){
                num=num*num;
                pow=pow/2;
            }else{
                ans=ans*num;
                pow=pow-1;
            }
        }
        if(n < 0) return 1/ans;
        return ans;
    }
}
