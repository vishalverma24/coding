package org.example.dp;

import java.util.ArrayList;
import java.util.List;

public class FrogJumpEnergy {

    public static void main(String args[])
    {
        ArrayList<Integer> heights = new ArrayList<>(List.of(10,20,30,10));

//        dp for memo
//        int[] dp = new int[heights.size() + 1];

        int n = heights.size();
        int[] dp = new int[n];

        for(int i=0;i<heights.size();i++){
            dp[i] = -1;
        }


//        memo
        int minEnergy = frogJumpMemo(heights.size()-1,heights,dp);
        System.out.println(minEnergy);


//        tabu
        int minEn = frogJumpTab(heights,dp);
        System.out.println(minEn);


        //space optimization
        int minEE = frogJumpOpt(heights);
        System.out.println(minEE);
    }

    private static int frogJumpOpt(ArrayList<Integer> heights) {

        int prev = 0;
        int prev2 = 0;
        int curr = 0;

        for(int i=1;i<heights.size();i++){
            int fs = prev + Math.abs(heights.get(i) - heights.get(i-1));
            int ss = Integer.MAX_VALUE;

            if(i>1){
                ss = prev2 + Math.abs(heights.get(i) - heights.get(i-2));
            }

            curr = Math.min(fs,ss);
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

    private static int frogJumpTab(ArrayList<Integer> heights, int[] dp) {

        dp[0] = 0;
        for(int i=1;i<heights.size();i++){
            int fs = dp[i-1] + Math.abs(heights.get(i) - heights.get(i-1));
            int ss = Integer.MAX_VALUE;

            if(i>1){
                ss = dp[i-2] + Math.abs(heights.get(i) - heights.get(i-2));
            }

            dp[i] = Math.min(fs,ss);
        }

        return dp[heights.size()-1];
    }

    private static int frogJumpMemo(int i, ArrayList<Integer> heights, int[] dp) {

        if(i==0) return 0;

        if(dp[i]!=-1) return dp[i];

        int left = frogJumpMemo(i-1,heights,dp) + Math.abs(heights.get(i) - heights.get(i-1));

        int right = Integer.MAX_VALUE;

        if(i>1){
            right = frogJumpMemo(i-2,heights,dp) + Math.abs(heights.get(i) - heights.get(i-2));
        }

        return dp[i] = Math.min(left,right);
    }
}
