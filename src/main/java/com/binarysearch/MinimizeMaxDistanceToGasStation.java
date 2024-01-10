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
}
