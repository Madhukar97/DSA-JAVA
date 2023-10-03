package com.arrays;

//493. Reverse Pairs
//https://leetcode.com/problems/reverse-pairs/description/
public class ReversePairs {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }

    public int mergeSort(int[] nums, int start, int end){
        if(start >= end) return 0;
        int mid=start+(end-start)/2;
        int count=0;
        count+=mergeSort(nums, start, mid);
        count+=mergeSort(nums, mid+1, end);
        count+=countReversePairs(nums, start, mid, end);
        merge(nums, start, mid, end);
        return count;
    }

    public int countReversePairs(int[] nums, int start, int mid, int end){
        int i=start;
        int j=mid+1;
        int count=0;
        // System.out.println(Arrays.toString(nums)+ ", S = " + start + ", M = " + mid + ", E = " + end);

        while(i<=mid){
            while(j <= end && nums[i] > (long)2*nums[j]){
                j++;
            }
            count=count+j-(mid+1);
            i++;
        }
        // System.out.println("count = " + count);
        return count;
    }

    public void merge(int[] nums, int start, int mid, int end){
        int[] temp = new int[end-start+1];
        int p1=start;
        int p2=mid+1;
        int i=0;

        while(p1 <= mid && p2 <= end){
            if(nums[p1] < nums[p2]){
                temp[i] = nums[p1];
                p1++;
            }else{
                temp[i] = nums[p2];
                p2++;
            }
            i++;
        }

        while(p1 <= mid){
            temp[i] = nums[p1];
            p1++;
            i++;
        }

        while(p2 <= end){
            temp[i] = nums[p2];
            p2++;
            i++;
        }

        for(int k=start;k<=end;k++){
            nums[k] = temp[k-start];
        }

    }
}
