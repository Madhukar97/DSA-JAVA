package com.greedy;
import java.util.*;
//Job Sequencing Problem
//https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1#
//https://www.codingninjas.com/studio/problems/job-sequencing-problem_1169460?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
public class JobSequencingProblem {
    class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr, (j1,j2)->j2.profit-j1.profit);

        int lastDeadline=0;
        for(int i=0;i<n;i++){
            lastDeadline=Math.max(lastDeadline, arr[i].deadline);
        }

        int[] jobs = new int[lastDeadline+1];
        Arrays.fill(jobs,-1);

        int count=0;
        int profit=0;
        for(Job job : arr){
            int ind = 0;
            while(job.deadline-ind >= 1){
                if(jobs[job.deadline-ind] == -1){
                    jobs[job.deadline-ind] = job.id;
                    count++;
                    profit+=job.profit;
                    break;
                }else{
                    ind++;
                }
            }
        }
        return new int[]{count,profit};
    }
}
