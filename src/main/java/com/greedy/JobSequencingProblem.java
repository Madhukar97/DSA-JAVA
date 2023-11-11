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

    //Revision 2
    //Function to find the maximum profit and the number of jobs done.
    int[] JobSchedulingSol2(Job arr[], int n)
    {
        int maxDeadLine = 0;
        for(Job job : arr) maxDeadLine = Math.max(maxDeadLine, job.deadline);

        int[] jobSeq = new int[maxDeadLine+1];
        Arrays.fill(jobSeq, -1);
        Arrays.sort(arr, (j1,j2)-> j2.profit-j1.profit);

        int profit=0, noOfJobs=0;

        for(int i=0;i<arr.length;i++){
            for(int j=arr[i].deadline;j>0;j--){
                if(jobSeq[j] == -1 ){
                    jobSeq[j] = arr[i].id;
                    profit+=arr[i].profit;
                    noOfJobs+=1;
                    break;
                }
            }
        }
        return new int[]{noOfJobs, profit};
    }

    //Revision 3
    int[] JobSchedulingR3(Job arr[], int n){
        int[] jobs = new int[n];
        Arrays.sort(arr, (j1,j2)->j2.profit-j1.profit);
        int count = 0;
        int profit=0;

        for(Job j : arr){
            int pointer=j.deadline-1;
            while(pointer >=0){
                if(jobs[pointer] == 0){
                    jobs[pointer] = j.id;
                    count++;
                    profit+=j.profit;
                    break;
                }
                pointer--;
            }
        }
        return new int[]{count,profit};
    }
}
