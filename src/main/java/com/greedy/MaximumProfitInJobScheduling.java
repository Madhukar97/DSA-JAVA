package com.greedy;

import java.util.*;

//1235. Maximum Profit in Job Scheduling
//https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/
public class MaximumProfitInJobScheduling {
    // Weighted-Job Scheduling problem

    // Brute Force using recursion, giving TLE on 18/35 tests
    class Solution {
        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            List<Job> jobs = new ArrayList<>();
            int n=startTime.length;
            for(int i=0;i<n;i++) jobs.add(new Job(startTime[i], endTime[i], profit[i]));
            jobs.sort((m1,m2) -> m1.end-m2.end);

            return rec(n-1, jobs);
        }

        private int rec(int index, List<Job> jobs){
            if(index == 0) return jobs.get(index).profit;

            // exclude job
            int excludeProfit = rec(index-1, jobs);

            // include job
            int includeProfit = jobs.get(index).profit;
            // find index of latest non-conflicting job
            int j = findNonConflictingJob(index, jobs);
            if(j != -1) includeProfit += rec(j, jobs);
            return Math.max(excludeProfit, includeProfit);
        }

        private int findNonConflictingJob(int curr, List<Job> jobs){
            for(int j=curr-1;j>=0;j--){
                if(jobs.get(j).end <= jobs.get(curr).start) return j;
            }
            return -1;
        }

        public class Job{
            int start;
            int end;
            int profit;
            public Job(int s, int e, int p){
                start=s;
                end=e;
                profit=p;
            }
        }
    }

    // Memoization also giving TLE on 30/35 Tests
    class Solution2 {
        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            List<Job> jobs = new ArrayList<>();
            int n=startTime.length;
            for(int i=0;i<n;i++) jobs.add(new Job(startTime[i], endTime[i], profit[i]));
            jobs.sort((m1,m2) -> m1.end-m2.end);
            Integer[] maxProfits = new Integer[n];

            return rec(n-1, jobs, maxProfits);
        }

        private int rec(int index, List<Job> jobs, Integer[] maxProfits){
            if(index == 0) return jobs.get(index).profit;
            if(maxProfits[index] != null) return maxProfits[index];

            // exclude job
            int excludeProfit = rec(index-1, jobs, maxProfits);

            // include job
            int includeProfit = jobs.get(index).profit;
            // find index of latest non-conflicting job
            int j = findNonConflictingJob(index, jobs);
            if(j != -1) includeProfit += rec(j, jobs, maxProfits);
            return maxProfits[index] = Math.max(excludeProfit, includeProfit);
        }

        private int findNonConflictingJob(int curr, List<Job> jobs){
            for(int j=curr-1;j>=0;j--){
                if(jobs.get(j).end <= jobs.get(curr).start) return j;
            }
            return -1;
        }

        public class Job{
            int start;
            int end;
            int profit;
            public Job(int s, int e, int p){
                start=s;
                end=e;
                profit=p;
            }
        }
    }

    // Memoization and BinarySearch sol working
    class Solution3 {
        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            List<Job> jobs = new ArrayList<>();
            int n=startTime.length;
            for(int i=0;i<n;i++) jobs.add(new Job(startTime[i], endTime[i], profit[i]));
            jobs.sort((m1,m2) -> m1.end-m2.end);
            Integer[] maxProfits = new Integer[n];
            return rec(n-1, jobs, maxProfits);
        }

        private int rec(int index, List<Job> jobs, Integer[] maxProfits){
            if(index == 0) return jobs.get(index).profit;
            if(maxProfits[index] != null) return maxProfits[index];

            // exclude job
            int excludeProfit = rec(index-1, jobs, maxProfits);

            // include job
            int includeProfit = jobs.get(index).profit;
            // find index of latest non-conflicting job
            int j = findNonConflictingJob(index, jobs);
            if(j != -1) includeProfit += rec(j, jobs, maxProfits);
            return maxProfits[index] = Math.max(excludeProfit, includeProfit);
        }

        private int findNonConflictingJob(int curr, List<Job> jobs){
            int s=0;
            int e=curr-1;
            int index=-1;

            while(s <= e){
                int mid = s+(e-s)/2;
                if(jobs.get(mid).end <= jobs.get(curr).start){
                    index=mid;
                    s=mid+1;
                }else e=mid-1;
            }
            return index;
        }

        public class Job{
            int start;
            int end;
            int profit;
            public Job(int s, int e, int p){
                start=s;
                end=e;
                profit=p;
            }
        }
    }
}
