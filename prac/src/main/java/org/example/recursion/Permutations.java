package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String args[])
    {

        List<Integer> nums = List.of(1,2,3);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.size()];
        permutate(nums,ans,ds,freq);
        System.out.println(ans);
    }

    private static void permutate(List<Integer> nums, List<List<Integer>> ans, List<Integer> ds, boolean[] freq) {

        if(ds.size()==nums.size()){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0;i<nums.size();i++){
            if(!freq[i]){
                freq[i] = true;
                ds.add(nums.get(i));
                permutate(nums,ans,ds,freq);
                ds.removeLast();
                freq[i] = false;
            }
        }
    }

}
