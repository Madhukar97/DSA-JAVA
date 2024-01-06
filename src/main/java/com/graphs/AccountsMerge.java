package com.graphs;

import java.util.*;

//721. Accounts Merge
//https://leetcode.com/problems/accounts-merge/description/
public class AccountsMerge {
    class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            int n=accounts.size();
            DisjointSet djs = new DisjointSet(n);
            Map<String, Integer> map = new HashMap<>();

            for(int i=0;i<n;i++){
                for(int j=1;j<accounts.get(i).size();j++){
                    String key = accounts.get(i).get(j);
                    if(!map.containsKey(key)) map.put(key, i);
                    else {
                        djs.unionBySize(i, map.get(key));
                    }
                }
            }

            List<List<String>> mergedMail = new ArrayList<>();
            for(int i=0;i<accounts.size();i++){
                mergedMail.add(new ArrayList<>());
            }

            for(String key : map.keySet()){
                mergedMail.get(djs.findUltimateParent(map.get(key))).add(key);
            }

            List<List<String>> ans = new ArrayList<>();
            for(int i=0;i<n;i++){
                if(mergedMail.get(i).size() > 0){
                    ans.add(new ArrayList<>());
                    ans.get(ans.size()-1).add(accounts.get(i).get(0));
                    Collections.sort(mergedMail.get(i));
                    for(String mail : mergedMail.get(i)) ans.get(ans.size()-1).add(mail);
                }
            }

            return ans;
        }

        public class DisjointSet{
            int[] parent;
            int[] size;

            public DisjointSet(int n){
                parent = new int[n+1];
                size = new int[n+1];
                for(int i=0;i<=n;i++){
                    parent[i]=i;
                    size[i]=1;
                }
            }

            public int findUltimateParent(int node){
                if(node == parent[node]) return node;

                int up = findUltimateParent(parent[node]);
                parent[node] = up;
                return up;
            }

            public void unionBySize(int u, int v){
                int upU = findUltimateParent(u);
                int upV = findUltimateParent(v);
                if(upU == upV) return;
                if(size[upU] < size[upV]){
                    parent[upU] = upV;
                    size[upV]+=size[upU];
                }else{
                    parent[upV]=upU;
                    size[upU]+=size[upV];
                }
            }

            public boolean detectCycle(int u, int v){
                return findUltimateParent(u)==findUltimateParent(v);
            }
        }
    }
}
