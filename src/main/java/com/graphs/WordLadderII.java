package com.graphs;

import java.util.*;

//126. Word Ladder II
//leetcode.com/problems/word-ladder-ii/description/
//Word Ladder II
//https://www.geeksforgeeks.org/problems/word-ladder-ii/1
public class WordLadderII {
    //Shortest path using BFS
    //Failing at 19/36 test case on leetcode
    class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            int n=beginWord.length();
            Set<String> set = new HashSet<>();
            for(String str : wordList) set.add(str);

            Queue<List<String>> q = new LinkedList<>();
            List<String> firstSeq = new ArrayList<>();
            firstSeq.add(beginWord);
            q.add(firstSeq);

            List<List<String>> ans = new ArrayList<>();

            while(!q.isEmpty()){
                List<String> currSeq = q.poll();
                String currWord = currSeq.get(currSeq.size()-1);

                if(endWord.equals(currWord)) {
                    if(ans.size()==0) ans.add(currSeq);
                    else if(ans.get(ans.size()-1).size() == currSeq.size()) ans.add(currSeq);
                }

                //do transformations
                for(int i=0;i<n;i++){
                    for(char ch='a';ch<='z';ch++){
                        StringBuilder replacedString = new StringBuilder();
                        replacedString.append(currWord.substring(0,i)).append(ch);
                        if(i<n-1) replacedString.append(currWord.substring(i+1,n));
                        if(set.contains(replacedString.toString()) && !currSeq.contains(replacedString.toString())){
                            currSeq.add(replacedString.toString());
                            q.add(new ArrayList<>(currSeq));
                            currSeq.remove(currSeq.size()-1);
                        }
                    }
                }
            }
            return ans;
        }
    }

    //Most optimal sol by storing the used words in a level
    //Passing all test case on GFG but Failing at 32/36 test case on leetcode
    class Solution2 {
        public ArrayList<ArrayList<String>> findSequences(String beginWord, String endWord, String[] wordList) {
            int n=beginWord.length();
            Set<String> set = new HashSet<>();
            for(String str : wordList) set.add(str);

            Queue<ArrayList<String>> q = new LinkedList<>();
            ArrayList<String> firstSeq = new ArrayList<>();
            firstSeq.add(beginWord);
            q.add(firstSeq);

            ArrayList<ArrayList<String>> ans = new ArrayList<>();
            List<String> usedLevelWords = new ArrayList<>();
            usedLevelWords.add(beginWord);

            while(!q.isEmpty()){
                int size = q.size();

                for(int c=0;c<size;c++){
                    ArrayList<String> currSeq = q.poll();
                    String currWord = currSeq.get(currSeq.size()-1);

                    if(ans.size() > 0 && ans.get(ans.size()-1).size() < currSeq.size()) break;

                    if(endWord.equals(currWord)) {
                        if(ans.size()==0) ans.add(currSeq);
                        else if(ans.get(ans.size()-1).size() == currSeq.size()) ans.add(currSeq);
                    }

                    //do transformations
                    for(int i=0;i<n;i++){
                        for(char ch='a';ch<='z';ch++){
                            StringBuilder replacedString = new StringBuilder();
                            replacedString.append(currWord.substring(0,i)).append(ch);
                            if(i<n-1) replacedString.append(currWord.substring(i+1,n));
                            if(set.contains(replacedString.toString())){
                                usedLevelWords.add(replacedString.toString());
                                currSeq.add(replacedString.toString());
                                q.add(new ArrayList<>(currSeq));
                                currSeq.remove(currSeq.size()-1);
                            }
                        }
                    }
                }
                for(String str : usedLevelWords) set.remove(str);
            }
            return ans;
        }
    }
}
