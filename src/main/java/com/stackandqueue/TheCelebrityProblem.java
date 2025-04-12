package com.stackandqueue;

// The Celebrity Problem
//https://www.naukri.com/code360/problems/the-celebrity-problem_982769?leftPanelTabValue=PROBLEM
public class TheCelebrityProblem {
    public class Solution {
        public static int findCelebrity(int n) {
            // Write your code here.
            int top=0;
            int bottom=n-1;
            while(top < bottom){
                if(Runner.knows(top,bottom)) top++;
                else if(Runner.knows(bottom, top)) bottom--;
                else {
                    top++;
                    bottom--;
                }
            }

            if(top > bottom) return -1;
            for(int j=0;j<n;j++) if(Runner.knows(top,j) || (j!=top && !Runner.knows(j, top))) return -1;
            return top;
        }
    }
    /*
        This is signature of helper function 'knows'.
        You should not implement it, or speculate about its implementation.

        boolean knows(int A, int B);
        Function 'knows(A, B)' will returns "true" if the person having
        id 'A' know the person having id 'B' in the party, "false" otherwise.
        Use it as Runner.knows(A, B);
    */
    class  Runner {
        public static boolean knows(int A, int B) {return true;}
    }
}
