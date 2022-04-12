package com.problems;

//1342. Number of Steps to Reduce a Number to Zero
//https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
public class NoOfStepsToReduceNumToZero {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
    }

    public static int numberOfSteps(int num) {
        return noOfSteps(num, 0);
    }
    static int noOfSteps(int n, int steps) {
        if( n == 0 ) return steps;
        if(n%2==0) return noOfSteps(n/2, steps+1);
        else return noOfSteps(n-1, steps+1);
    }
}
