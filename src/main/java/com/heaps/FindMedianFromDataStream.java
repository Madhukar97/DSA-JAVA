package com.heaps;

import java.util.*;

//295. Find Median from Data Stream
//https://leetcode.com/problems/find-median-from-data-stream/description/
public class FindMedianFromDataStream {
    //1. Using ArrayList (TLE - 17/21 passed):
    class MedianFinder {
        List<Double> list;

        public MedianFinder() {
            this.list = new ArrayList<>();
        }

        public void addNum(int num) {
            list.add(Double.parseDouble(""+num));
        }

        public double findMedian() {
            // System.out.println("List : " + list.toString());
            Collections.sort(list);
            if(list.size() == 0) return 0;
            else if(list.size() %2 == 1) return list.get(list.size()/2);
            else return (list.get(list.size()/2)+list.get(list.size()/2-1))/2;
        }
    }
}
