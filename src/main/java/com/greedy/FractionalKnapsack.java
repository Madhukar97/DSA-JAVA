package com.greedy;

import java.util.Arrays;

//Fractional Knapsack
//https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
//https://www.codingninjas.com/studio/problems/fractional-knapsack_975286?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
public class FractionalKnapsack {
    class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }
    double fractionalKnapsack(int W, Item arr[], int n)
    {
        double capacity=W;
        Arrays.sort(arr, (i1, i2)->{
            double r2=(double)i2.value/(double)i2.weight;
            double r1=(double)i1.value/(double)i1.weight;
            if(r2 > r1) return 1;
            else if(r2 < r1) return -1;
            else return 0;

        });

        double ans=0;
        for(int i=0;i<n && capacity > 0;i++){
            if(arr[i].weight <= capacity) {
                ans+=arr[i].value;
                capacity-=arr[i].weight;

            }
            else{
                ans+=capacity*(double)arr[i].value/(double)arr[i].weight;
                capacity=0;
            }
        }
        return ans;
    }
}
