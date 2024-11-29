package org.example.anushka;

import java.util.*;

public class Anushka {

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 2;

        int ans = searchInsert(nums,target);
        System.out.println(ans);
    }

    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n-1;

        return findIndex(l,r,nums,target);
    }

    public static int findIndex(int l, int r, int[] nums, int target){

        if(l>r){
            return l;
        }

        int m = (l+r)/2;

        if(target==nums[m]){
            return m;
        } else if(target<nums[m]){
            return findIndex(l,m-1,nums,target);
        } else{
            return findIndex(m+1,r,nums,target);
        }
    }
}
