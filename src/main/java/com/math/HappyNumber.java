package com.math;

//202. Happy Number
// google question
//https://leetcode.com/problems/happy-number/
public class HappyNumber {
    public static void main(String[] args) {
        HappyNumber obj = new HappyNumber();
        System.out.println(obj.isHappy(19));
    }
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        }
        while(fast != slow);
        if(fast == 1)  return true;
        return false;
    }

    static int findSquare(int n) {
        int ans = 0;
        while( n > 0 ) {
            int remainder = n%10;
            ans+=remainder*remainder;
            n=n/10;
        }
        return ans;
    }
}
