package org.example.recursion;

import java.util.*;

public class CombinationSumTwo {


    public static void main(String args[])
    {
        ArrayList<Integer> cand = new ArrayList<>(List.of(10,1,6,7,2,1,5));

        int target = 7;

        List<List<Integer>> comb2 = combinationSum2(cand,target);
        System.out.println(comb2);
    }

    private static List<List<Integer>> combinationSum2(ArrayList<Integer> cand, int target) {
        Collections.sort(cand);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        findUniqueCombinations(0,cand,target,ans,ds);
        return ans;
    }

    private static void findUniqueCombinations(int ind, ArrayList<Integer> cand, int target, List<List<Integer>> ans, List<Integer> ds) {

        if(target==0){
            List<Integer> dsCopy = new ArrayList<>(ds);
            ans.add(dsCopy);
            return;
        }

        for(int i = ind;i<cand.size();i++){
            if(i>ind && Objects.equals(cand.get(i), cand.get(i - 1))){
                continue;
            }
            if(cand.get(i)>target){
                break;
            }
            ds.add(cand.get(i));
            findUniqueCombinations(i+1,cand,target- cand.get(i),ans,ds);
            ds.removeLast();
        }
    }
}
