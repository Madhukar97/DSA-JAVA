package com.math;

//374. Guess Number Higher or Lower
//https://leetcode.com/problems/guess-number-higher-or-lower/
public class GuessNumberHigherorLower {
    public static void main(String[] args) {

    }
    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            return recFunc(1, n);
        }
        public int recFunc(int s, int e) {
            int mid = s+(e-s)/2;
            int val = guess(mid);
            if (val == 0) return mid;
            if ( val == -1 ) return recFunc(s, mid-1);
            else return recFunc(mid+1, e);
        }
    }
    //dummy class

    private class GuessGame {
        int guess(int n) {
            return -1;
        }
    }
}
