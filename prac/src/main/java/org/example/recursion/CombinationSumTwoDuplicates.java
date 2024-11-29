package org.example.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationSumTwoDuplicates {
    public static void main(String args[])
    {
        ArrayList<Integer> cand = new ArrayList<>(List.of(10,1,2,7,6,1,5));

        int target = 8;

        List<List<Integer>> comb2 = combinationSum2Dup(cand,target);
        System.out.println(comb2);
    }

    private static List<List<Integer>> combinationSum2Dup(ArrayList<Integer> cand, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        findComb(0,cand,target,ans,ds);
        return ans;
    }

    private static void findComb(int i, ArrayList<Integer> cand, int target, List<List<Integer>> ans, List<Integer> ds) {

        if(i==cand.size()){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(cand.get(i)<=target){
            ds.add(cand.get(i));
            findComb(i+1,cand,target-cand.get(i),ans,ds);
            ds.removeLast();
        }

        findComb(i+1,cand,target,ans,ds);
    }
}
