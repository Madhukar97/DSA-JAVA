package com.graphs;

import java.util.*;

//126. Word Ladder II
//leetcode.com/problems/word-ladder-ii/description/
public class WordLadderII {
    //Shortest path using BFS
    //Failing at 32/36 test case on leetcode
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
}
