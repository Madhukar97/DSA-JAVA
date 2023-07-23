package com.arrays;

//941. Valid Mountain Array
//https://leetcode.com/problems/valid-mountain-array/description/
public class ValidMountainArray {
    //Normal Iteration sol with Time Complexity = O(n*n)
    public boolean validMountainArray(int[] arr) {
        if(arr.length<=2)return false;
        for(int i=1;i<arr.length-1;i++){
            boolean left = checkLeft(arr, i);
            boolean right = checkRight(arr, i);
            boolean valid = left && right;
            // System.out.println(arr[i] + ", Mountain :: " + left + ", right :: " + right);
            if(valid) return true;
        }
        return false;
    }

    public boolean checkLeft(int[] arr, int i){
        while(i >0){
            if(arr[i-1] < arr[i]) i--;
            else return false;
        }
        return true;
    }

    public boolean checkRight(int[] arr, int i){
        while(i < arr.length-1){
            if(arr[i] > arr[i+1]) i++;
            else return false;
        }
        return true;
    }
    //Normal Iteration sol with Time Complexity = O(n)
    public boolean validMountainArraySolution2(int[] arr) {
        if(arr.length<=2)return false;
        if(arr[0]>=arr[1] || arr[arr.length-2]<=arr[arr.length-1]) return false;
        int flag = 1;

        for(int i=1;i<arr.length-1;i++){
            // System.out.println("NUM ::  " + arr[i]);
            if(arr[i-1] == arr[i]) return false;
            if(flag==1 && arr[i-1] < arr[i]){
                continue;
            }else if(flag==1 && arr[i-1] > arr[i]){
                flag=-1;
            }else if(flag == -1 && arr[i-1] > arr[i]){
                continue;
            }else return false;
        }
        return true;
    }
    //Best Iteration sol with Time Complexity = O(n)
    public boolean validMountainArrayMostOptimizedSolution3(int[] arr) {
        if(arr.length<=2)return false;
        if(arr[0]>=arr[1] || arr[arr.length-2]<=arr[arr.length-1]) return false;

        int peakInd = 0;
        int maxi=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i] > maxi) {
                maxi=arr[i];
                peakInd=i;
            }
        }

        int l=peakInd;
        while(l > 0){
            if(arr[l-1] >= arr[l]) return false;
            l--;
        }

        int r=peakInd;
        while(r < arr.length-1){
            if(arr[r] <= arr[r+1]) return false;
            r++;
        }
        return true;
    }
}
