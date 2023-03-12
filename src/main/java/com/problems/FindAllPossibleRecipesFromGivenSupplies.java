package com.problems;

import java.util.*;

//https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/submissions/913776998/
public class FindAllPossibleRecipesFromGivenSupplies {
    public static void main(String[] args) {
//        String[] recipes = {"bread","sandwich","burger"};
//        List<String> ingredient1 = new ArrayList<>();
//        ingredient1.add("yeast");
//        ingredient1.add("flour");
//        List<String> ingredient2 = new ArrayList<>();
//        ingredient2.add("bread");
//        ingredient2.add("meat");
//        List<String> ingredient3 = new ArrayList<>();
//        ingredient3.add("sandwich");
//        ingredient3.add("meat");
//        ingredient3.add("bread");
//        List<List<String>> ingredients = new ArrayList<>();
//        ingredients.add(ingredient1);
//        ingredients.add(ingredient2);
//        ingredients.add(ingredient3);
//        String[] supplies = {"yeast","flour","meat"};

        //input 2 should return empty list as ans
        String[] recipes = {"bread"};
        List<String> ingredient1 = new ArrayList<>();
        ingredient1.add("yeast");
        ingredient1.add("flour");
        List<List<String>> ingredients = new ArrayList<>();
        ingredients.add(ingredient1);
        String[] supplies = {"yeast"};
        System.out.println(findAllRecipes(recipes, ingredients,supplies));
    }

    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> ans = new ArrayList<>();

        HashSet<String> suppliesSet = new HashSet<>();
        for(String sup : supplies){
            suppliesSet.add(sup);
        }

        HashSet<String> recipesSet = new HashSet<>();
        for(String rec : recipes){
            recipesSet.add(rec);
        }

        boolean[] dp = new boolean[recipes.length];

        while(recipesSet.size()>0){
            int count=0;
            for(int i=0; i<recipes.length; i++){
                if(dp[i]) continue;
                if(findRecipe(ingredients.get(i), suppliesSet)){
                    suppliesSet.add(recipes[i]);
                    dp[i] = true;
                    count++;
                    ans.add(recipes[i]);
                    System.out.println("Recipe done :: " + recipes[i]);
                    recipesSet.remove(recipes[i]);
                }
            }
            if(count == 0) break;
        }
        return ans;
    }

    public static boolean findRecipe(List<String> ingredients, HashSet<String> suppliesSet){
        for(String ing : ingredients){
            if(!suppliesSet.contains(ing)) return false;
            //System.out.println(ing +  " supply is not present");
        }
        return true;
    }
}
