package com.intervals;

import java.util.*;

//855. Exam Room
//https://leetcode.com/problems/exam-room/description/
public class ExamRoom {
    private TreeSet<int[]> seatSet = new TreeSet<>(
            (a, b) -> {
                int distanceA = calculateDistance(a);
                int distanceB = calculateDistance(b);
                // Compare by distance, then by starting index if distances are equal
                return distanceA == distanceB ? a[0] - b[0] : distanceB - distanceA;
            }
    );
    // Maps to track the nearest occupied seat to the left and right of each seat
    private Map<Integer, Integer> leftNeighbour = new HashMap<>();
    private Map<Integer, Integer> rightNeighbour = new HashMap<>();
    private int seatCount;

    public ExamRoom(int n) {
        this.seatCount = n;
        // Initialize with a dummy seat segment representing the whole row
        add(new int[] {-1, seatCount});
    }

    public int seat() {
        // Get the seat segment representing the largest distance between seated students
        int[] segment = seatSet.first();
        int seatPosition = (segment[0] + segment[1]) / 2;
        // Handle cases where we need to seat at the start or the end
        if (segment[0] == -1) {
            seatPosition = 0;
        } else if (segment[1] == seatCount) {
            seatPosition = seatCount - 1;
        }
        // Remove the current segment and add new segments reflecting the new student being seated
        remove(segment);
        add(new int[] {segment[0], seatPosition});
        add(new int[] {seatPosition, segment[1]});
        return seatPosition;
    }

    public void leave(int p) {
        // Find the immediate neighbours of the leaving student
        int leftIndex = leftNeighbour.get(p);
        int rightIndex = rightNeighbour.get(p);
        // Remove the segments created by the leaving student
        remove(new int[] {leftIndex, p});
        remove(new int[] {p, rightIndex});
        // Create a new segment reflecting the gap left by the student
        add(new int[] {leftIndex, rightIndex});
    }

    private int calculateDistance(int[] segment) {
        int l = segment[0], r = segment[1];
        // For seats at the beginning or end, use the whole distance minus one
        if (l == -1 || r == seatCount) {
            return r - l - 1;
        } else {
            // Else, use the half the distance between l and r
            return (r - l) / 2;
        }
    }

    private void add(int[] segment) {
        seatSet.add(segment);
        leftNeighbour.put(segment[1], segment[0]);
        rightNeighbour.put(segment[0], segment[1]);
    }

    private void remove(int[] segment) {
        seatSet.remove(segment);
        leftNeighbour.remove(segment[1]);
        rightNeighbour.remove(segment[0]);
    }
}
