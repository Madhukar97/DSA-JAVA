package com.heaps;

import java.util.*;

//2512. Reward Top K Students
//https://leetcode.com/problems/reward-top-k-students/description/?envType=list&envId=px62zgu1
public class RewardTopKStudents {
    //Optimal sol using maxHeap and HashMap
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Map<String, Integer> marksMap = new HashMap<>();
        for(String s : positive_feedback) marksMap.putIfAbsent(s, 3);
        for(String s : negative_feedback) marksMap.putIfAbsent(s, -1);

        PriorityQueue<Student> maxHeap = new PriorityQueue<>((s1,s2)->{
            int diff = s2.points-s1.points;
            if(diff < 0) return -1;
            else if(diff > 0) return 1;
            int idDiff = s1.id-s2.id;
            if(idDiff < 0) return -1;
            return 1;
        });

        for(int i=0;i<student_id.length;i++){
            int id = student_id[i];
            String[] rep = report[i].split(" ");
            int points = 0;
            for(String s : rep){
                points+=marksMap.getOrDefault(s, 0);
            }
            // System.out.println("Student ID : " + id + ", Points : " + points);
            maxHeap.add(new Student(id, points));
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<k;i++){
            ans.add(maxHeap.poll().id);
        }
        return ans;
    }

    public class Student{
        int id;
        int points;

        public Student(int id, int p){
            this.id=id;
            this.points=p;
        }
    }
}
