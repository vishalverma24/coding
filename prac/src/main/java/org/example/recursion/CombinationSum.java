package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String args[])
    {
        ArrayList<Integer> cand = new ArrayList<>(List.of(4,3,2,3,6));

        int target = 7;

        combinationSum(cand,7);

    }

    private static void combinationSum(ArrayList<Integer> cand, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        findCombinations(0,cand,target,ans,ds);

        System.out.println(ans);
    }

    private static void findCombinations(int i, ArrayList<Integer> cand, int target, List<List<Integer>> ans, List<Integer> ds) {

        if(i == cand.size()){
            if(target == 0){
//                ans.add(ds);
                /*
                new ArrayList<>(ds) so that changes in ds doesn't affect the ans
                */
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(cand.get(i) <= target){
            ds.add(cand.get(i));
            findCombinations(i,cand,target-cand.get(i),ans,ds);
            ds.removeLast();
        }

        findCombinations(i+1,cand,target,ans,ds);
    }
}
