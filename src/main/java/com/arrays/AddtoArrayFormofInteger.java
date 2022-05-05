package com.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//989. Add to Array-Form of Integer
//https://leetcode.com/problems/add-to-array-form-of-integer/
public class AddtoArrayFormofInteger {
    public static void main(String[] args) {

    }
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        int l=num.length-1;
        int temp = 0;
        while(l >= 0 ) {
            if(k>=0 && temp == 0) {
                int sum = num[l]+k%10;
                k/=10;
                if(sum > 9) {
                    temp =1;
                    ans.add(sum%10);
                }else ans.add(sum);
            }
            else if(k>=0 && temp ==1) {
                int sum = num[l]+k%10+temp;
                k/=10;
                if(sum > 9) {
                    temp =1;
                    ans.add(sum%10);
                }else{
                    ans.add(sum);
                    temp = 0;
                }
            }
            else {
                int sum = num[l]+temp;
                k/=10;
                if(sum > 9) {
                    temp =1;
                    ans.add(sum%10);
                }else{
                    ans.add(sum);
                    temp = 0;
                }
            }
            l--;
        }
        while(k>0) {
            int sum=k%10+temp;
            if(sum > 9) {
                temp =1;
                ans.add(sum%10);
            }else{
                ans.add(sum);
                temp = 0;
            }
            k/=10;
        }
        if(temp == 1) ans.add(1);
        Collections.reverse(ans);
        return ans;
    }
}
