package com.striver.sde.sheet;

//287. Find the Duplicate Number
//https://leetcode.com/problems/find-the-duplicate-number/description/
public class FindTheDuplicateNumber {
    //Optimal sol using Linked-List Floyed's Tortoise algo(Fast and slow pointer method) with time O(n) and space O(1)
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];

        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int slow2 = 0;
        while(slow2 != slow){
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow;
    }

    //Optimal sol 2 updating the array with -ve values to detect the repetition
    public int findDuplicate2(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            if(nums[Math.abs(nums[i])] < 0) {
                return Math.abs(nums[i]);
            }
            else nums[Math.abs(nums[i])]*=-1;
        }
        return -1;
    }
}
