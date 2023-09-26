package com.striver.sde.sheet;

import java.util.ArrayList;
import java.util.List;

//118. Pascal's Triangle
//https://leetcode.com/problems/pascals-triangle/description/
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> r1 = new ArrayList<>();
        r1.add(1);
        ans.add(r1);

        for(int r=2;r<=numRows;r++){
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j=1;j<r-1;j++){
                row.add(ans.get(ans.size()-1).get(j-1) + ans.get(ans.size()-1).get(j));
            }
            row.add(1);
            ans.add(row);
        }
        return ans;
    }
}
