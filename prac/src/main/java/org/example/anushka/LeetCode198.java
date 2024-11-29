package org.example.anushka;

import java.util.Arrays;

public class LeetCode198 {

    public static void main(String[] args){
        int[] nums = {2,17,9,3,1};
        int n= nums.length;
        int prize=findCost(n-1, nums);
        System.out.println(prize);

        int[] dp= new int[n+1];
        Arrays.fill(dp, -1);

        int priceMemo = findCostMemo(n,nums,dp);
//        System.out.println(priceMemo);

        int priceTab = findCostTab(nums,dp);
        System.out.println(priceTab);
    }

    private static int findCostTab(int[] nums, int[] dp) {
        dp[0] = nums[0];

        for(int i=1;i<nums.length;i++){
            int pick=nums[i];
            if(i>1) pick += dp[i-2];
            int noPick = dp[i-1];
            dp[i] = Math.max(pick, noPick);
        }

        return dp[nums.length-1];
    }

    private static int findCostMemo(int n, int[] nums, int[] dp) {
        return 0;
    }

    public static int findCost(int n, int[] nums) {
       if (n == 0) {
           return nums[0];
       }
       if(n<0)
       {
           return 0;
       }

       int pick = nums[n] + findCost(n-2,nums);
       int noPick = findCost(n - 1, nums);

       return Math.max(pick, noPick);

    }

}
