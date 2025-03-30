package com.greedy;

//860. Lemonade Change
//https://leetcode.com/problems/lemonade-change/description/
public class LemonadeChange {
    class Solution {
        public boolean lemonadeChange(int[] bills) {
            int[] chg = new int[3];
            for(int bill : bills){
                // System.out.println("bill : " + bill + ", chg : " + Arrays.toString(chg));
                if(bill == 5) chg[0]++;
                else if( bill == 10) {
                    if(chg[0] > 0) {
                        chg[0]--;
                        chg[1]++;
                    }else return false;
                }else {
                    if(chg[0] > 0 && chg[1] > 0) {
                        chg[0]--;
                        chg[1]--;
                    }else if(chg[0] > 2) chg[0]-=3;
                    else return false;
                    chg[2]++;
                }
            }
            return true;
        }
    }

    //sol 2
    public boolean lemonadeChange(int[] bills) {
        for (int i = 0, fives = 0, tens = 0; i < bills.length; i++) {
            if (bills[i] == 5) fives++;
            else if (bills[i] == 10) {
                --fives;
                tens++;
            }
            else if(tens > 0){
                tens--;
                fives--;
            }else fives-=3;
            if (fives < 0) return false;
        }
        return true;
    }
}
