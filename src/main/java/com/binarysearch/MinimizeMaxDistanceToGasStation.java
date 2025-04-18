package com.binarysearch;

import java.util.PriorityQueue;

// Minimize Max Distance to Gas Station
// https://www.codingninjas.com/studio/problems/minimise-max-distance_7541449?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
public class MinimizeMaxDistanceToGasStation {
    public static double MinimiseMaxDistance(int []arr, int K){
        int[] dist = new int[arr.length-1];

        PriorityQueue<double[]> pq = new PriorityQueue<>((a1, a2)->{
            double diff = a2[0]-a1[0];
            if(diff == 0) return 0;
            else if(diff < 0) return -1;
            else return 1;
        });

        for(int j=0;j<arr.length-1;j++){
            double consecutiveDist = (arr[j+1] - arr[j])/(double)(dist[j]+1);
            // System.out.println("Index " + j +", consecutiveDist : " + consecutiveDist);
            pq.add(new double[]{consecutiveDist, j});
        }

        for(int i=0;i<K;i++){

            double[] node = pq.poll();
            int targetIndex = (int)node[1];
            dist[targetIndex]++;
            double newConsecutiveDist = (arr[targetIndex+1] - arr[targetIndex])/(double)(dist[targetIndex]+1);
            // System.out.println("targetIndex " + targetIndex +", newConsecutiveDist : " + newConsecutiveDist);
            pq.add(new double[]{newConsecutiveDist, targetIndex});
        }
        // System.out.println("dist ; " + Arrays.toString(dist));
        double maxDist=-1;
        for(int i=0;i<arr.length-1;i++){
            double consDist = (arr[i+1] - arr[i])/(double)(dist[i]+1);
            maxDist = Math.max(maxDist, consDist);
        }
        return maxDist;
    }

    // Revision 5
    public class Solution {
        public static double MinimiseMaxDistance(int []arr, int K){
            int n=arr.length;
            int[] sections = new int[n-1];
            PriorityQueue<Section> pq = new PriorityQueue<>((s1,s2) -> {
                double d1 = s1.dist;
                double d2 = s2.dist;
                if(d1 == d2) return 0;
                if(d2 > d1) return 1;
                else return -1;
            });
            for(int i=0;i<sections.length;i++){
                pq.add(new Section(i, arr[i+1]-arr[i]));
            }
            for(int i=0;i<K;i++){
                Section curr = pq.poll();
                sections[curr.index]++;
                curr.dist = (double)(arr[curr.index+1]-arr[curr.index])/(double)(sections[curr.index]+1);
                pq.add(curr);
            }
            double maxDist = 0;
            for(int i=0;i<n-1;i++){
                maxDist = Math.max((double)(arr[i+1]-arr[i])/(double)(sections[i]+1), maxDist);
            }
            return maxDist;
        }
        static class Section{
            int index;
            double dist;
            public Section(int i, double d){
                index=i;
                dist=d;
            }
        }
    }
}
