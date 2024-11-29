package org.example.dp;

import java.util.ArrayList;
import java.util.List;

public class MaximumSumNonAdjacent {

    public static void main(String args[])
    {
        ArrayList<Integer> arr = new ArrayList<>(List.of(2,1,4,9));
        int n = arr.size();

        int[] dp = new int[n];

        for(int i=0;i<n;i++){
            dp[i] = -1;
        }
        //memo
        int sum = findSumMemo(arr,n-1,dp);
        System.out.println(sum);


        //tab
        int sumTab = findSumTab(arr,n,dp);
        System.out.println(sumTab);

        //tab with Space Opt
        int sumOpt = findSumOpt(arr,n,dp);
        System.out.println(sumTab);
    }

    private static int findSumOpt(ArrayList<Integer> arr, int n, int[] dp) {

        int prev = arr.get(0);
        int prev2=0;

        for(int i=0;i<=n-1;i++){

            int pick = arr.get(i);
            if(i>1){
                pick += prev2;
            }

            int noPick = prev;

            int curr = Math.max(pick,noPick);

            prev2 = prev;
            prev= curr;
        }

        return prev;
    }

    private static int findSumTab(ArrayList<Integer> arr, int n, int[] dp) {

        dp[0] = arr.get(0);

        for(int i=1;i<=n-1;i++){

            int pick = arr.get(i);
            if(i>1){
                pick += dp[i-2];
            }

            int noPick = dp[i-1];

            dp[i] = Math.max(pick,noPick);
        }

        return dp[n-1];
    }

    private static int findSumMemo(ArrayList<Integer> arr, int ind, int[] dp) {

        if(ind == 0) return arr.get(ind);

        if(ind<0) return 0;

        if(dp[ind]!=-1) return  dp[ind];

        int pick = arr.get(ind) + findSumMemo(arr,ind-2,dp);

        int noPick = findSumMemo(arr,ind-1,dp);

        return dp[ind] = Math.max(pick,noPick);

    }
}
