package com.arrays;

import java.util.ArrayList;

//Missing and repeating numbers
//https://www.codingninjas.com/studio/problems/873366?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTabValue=PROBLEM
public class FindMissingAndRepeatingNumbers {
    //Better sol use Hashing

    //Optimal sol using 2 passes
    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        int missing = -1;
        int repeating = -1;

        // First pass: Mark elements as negative to identify the repeating element
        for(int i=0;i<n;i++){
            int correctIndex = Math.abs(arr.get(i))-1;
            if(arr.get(correctIndex) > 0) arr.set(correctIndex, -1*arr.get(correctIndex));
            else{
                repeating = Math.abs(arr.get(i));
            }
        }

        // Second pass: Find the missing element
        for(int i=0;i<n;i++){
            if(arr.get(i) > 0) missing = i+1;
        }
        return new int[]{missing,repeating};
    }

    //Revision 2
    //optimal sol using -ve multiplication
    public static int[] missingAndRepeating2(ArrayList<Integer> arr, int n) {
        int[] ans = new int[2];
        for(int i : arr){
            int abs = Math.abs(i);
            if(arr.get(abs-1) > 0) arr.set(abs-1, arr.get(abs-1)*-1);
            else{
                ans[1] = abs;
            }
        }

        for(int i=0;i<arr.size();i++){
            if(arr.get(i) > 0) ans[0] = i+1;
        }
        return ans;
    }
}
