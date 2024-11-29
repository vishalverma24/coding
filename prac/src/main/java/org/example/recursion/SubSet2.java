package org.example.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubSet2 {

    public static void main(String args[])
    {

        int[] nums = {1,2,2};
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        findUniq(0,nums,ans,ds);
        System.out.println(ans);
    }

    private static void findUniq(int ind, int[] nums, List<List<Integer>> ans, List<Integer> ds) {

        if(!ans.contains(ds)){
            ans.add(new ArrayList<>(ds));
        }


        for(int i=ind; i<nums.length;i++){

            ds.add(nums[i]);
            findUniq(i+1,nums,ans,ds);
            ds.removeLast();
        }

    }


}
