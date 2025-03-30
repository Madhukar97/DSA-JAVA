package com.greedy;

import java.util.*;

//735. Asteroid Collision
//https://leetcode.com/problems/asteroid-collision/description/
public class AsteroidCollision {
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            List<Integer> ans = new ArrayList<>();
            List<Integer> asts = new ArrayList<>();
            for(int a : asteroids) asts.add(a);
            while(asts.size() > 0){
                for(int i=0;i<asts.size();i++){
                    int curr = asts.get(i);
                    if(ans.size() == 0) {
                        ans.add(curr);
                    }else{
                        int prev = ans.get(ans.size()-1);
                        if((prev > 0 && curr > 0) || (prev<0 && curr<0)) {
                            ans.add(curr);
                            continue;
                        }else if(prev>0 && curr<0 && prev == curr*(-1)) ans.remove(ans.size()-1);
                        else if(prev < 0 && curr > 0) ans.add(curr);
                        else if(Math.abs(prev) > Math.abs(curr)) {
                            continue;
                        }else {
                            ans.remove(ans.size()-1);
                            ans.add(curr);
                        }
                    }
                }
                if(ans.size() == asts.size()) break;
                asts = ans;
                ans = new ArrayList<>();
            }
            int[] res = new int[ans.size()];
            for(int i=0;i<ans.size();i++) res[i] = ans.get(i);
            return res;
        }
    }
}
