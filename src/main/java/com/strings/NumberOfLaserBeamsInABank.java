package com.strings;

//2125. Number of Laser Beams in a Bank
//https://leetcode.com/problems/number-of-laser-beams-in-a-bank/description/
public class NumberOfLaserBeamsInABank {
    //Optimal sol 1 with TC O(n*m) and SC = O(n)
    public int numberOfBeams(String[] bank) {
        int[] count = new int[bank.length];
        int index=0;
        for(String s : bank){
            int device = 0;
            for(int j=0;j<s.length();j++) if(s.charAt(j) == '1') device++;
            count[index++] = device;
        }

        int i=0;
        int j=1;
        int ans=0;
        while(j < bank.length){
            if(i==j) {
                j++;
                continue;
            }

            if(count[j] == 0){
                j++;
                continue;
            }

            if(count[i] == 0){
                i++;
                continue;
            }

            ans+=count[i]*count[j];
            i=j;
            j++;
        }
        return ans;
    }

    //Optimal sol 2 with TC O(n*m) and SC = O(1)
    public int numberOfBeamsSol2(String[] bank) {
        int prevLazer =0;
        int ans =0;
        for(String s:bank){
            int curLazer = 0;
            for(char c: s.toCharArray()){
                if(c=='1'){
                    curLazer++;
                }
            }
            if(curLazer >0){
                ans += (curLazer * prevLazer);
                prevLazer = curLazer;
            }
        }
        return ans;
    }

}
