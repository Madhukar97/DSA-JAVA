package com.graphs;

import java.util.*;

//127. Word Ladder
//leetcode.com/problems/word-ladder/description/
public class WordLadder {
    //Shortest path using BFS with Set, Queue and Word{str, sequence} class
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            int n=beginWord.length();
            Set<String> set = new HashSet<>();
            for(String str : wordList) set.add(str);

            Queue<Word> q = new LinkedList<>();
            q.add(new Word(beginWord, 1));
            set.remove(beginWord);

            while(!q.isEmpty()){
                Word word = q.poll();
                String currWord = word.string;
                int currSeq = word.seq;

                if(endWord.equals(currWord)) return currSeq;

                for(int i=0;i<n;i++){
                    for(char ch='a'; ch<='z'; ch++){
                        StringBuilder replacedString = new StringBuilder();
                        replacedString.append(currWord.substring(0,i)).append(ch);
                        if(i<n-1) replacedString.append(currWord.substring(i+1,n));
                        if(set.contains(replacedString.toString())){
                            set.remove(replacedString.toString());
                            q.add(new Word(replacedString.toString(), currSeq+1));
                        }
                    }
                }
            }
            return 0;
        }

        public class Word{
            String string;
            int seq;

            public Word(String s, int n){
                string=s;
                seq=n;
            }
        }
    }
}
