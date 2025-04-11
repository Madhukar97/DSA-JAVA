package com.graphs;
import java.util.*;

//Alien dictionary
//https://www.naukri.com/code360/problems/alien-dictionary_630423?leftPanelTabValue=PROBLEM
public class AlienDictionary {
    public class Solution {
        public static String getAlienLanguage(String []dictionary, int k) {
            // Write your code here.
            int n = dictionary.length;
            List<char[]> edges = new ArrayList<>();

            for(int i=0;i<n-1;i++){
                String word1 = dictionary[i];
                String word2 = dictionary[i+1];

                for(int j=0;j<Math.min(word1.length(), word2.length());j++){
                    if(word1.charAt(j) == word2.charAt(j)) continue;
                    else{
                        edges.add(new char[]{word1.charAt(j), word2.charAt(j)});
                        break;
                    }
                }
            }
            // for(char[] edge : edges)  System.out.println("Edge : " + Arrays.toString(edge));

            int[] indegree = new int[k];

            List<List<Integer>> adj = new ArrayList<>();
            for(int i=0;i<k;i++) adj.add(new ArrayList<>());
            for(char[] edge : edges) {
                int u = edge[0]-'a';
                int v = edge[1]-'a';
                adj.get(u).add(v);
                indegree[v]++;
            }

            Queue<Integer> q = new LinkedList<>();
            for(int i=0;i<k;i++) if(indegree[i] == 0) q.add(i);
            List<Integer> toposort = new ArrayList<>();

            while(!q.isEmpty()){
                int node = q.poll();
                toposort.add(node);

                for(int neigh : adj.get(node)){
                    indegree[neigh]--;
                    if(indegree[neigh] == 0) q.add(neigh);
                }
            }

            String ans = "";
            for(int i=0;i<k;i++) ans+= (char)(toposort.get(i) + 'a');
            // System.out.println("ANS : " + ans);
            return ans;
        }
    }
}
