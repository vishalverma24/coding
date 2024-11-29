package org.example.dp;

import java.util.Arrays;

public class ClimibingStairsCost {

    public static void main(String args[]) {

//        int[] cost ={10,1,5,6,7};
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        int n = cost.length;

//        recursion
        int fiboRec = findMinCostRec(n, cost);
        System.out.println(fiboRec);

        int[] dp = new int[n + 2];
        Arrays.fill(dp, -1);

        //Memoziation
        int fiboMemo = findMinCostMemo(n,cost,dp);
        System.out.println(fiboMemo);

        Arrays.fill(dp,-1);

        //Tabulation
        int fiboTab = findMinCostTab(n,cost,dp);
        System.out.println(fiboTab);


    }

    private static int findMinCostTab(int n, int[] cost, int[] dp) {
        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<=cost.length;i++){
            int one = cost[i-1] + dp[i-1];
            int two = cost[i-2] + dp[i-2];

            dp[i] = Math.min(one,two);
        }

        return dp[n];

    }

    private static int findMinCostMemo(int n, int[] cost, int[] dp) {
        if (n == 0 || n==1) return 0;

        if(dp[n]!=-1) return dp[n];

        int one = cost[n - 1] + findMinCostMemo(n - 1, cost,dp);

        int two = cost[n - 2] + findMinCostMemo(n - 2, cost,dp);

        return dp[n] = Math.min(one, two);
    }

    private static int findMinCostRec(int n, int[] cost) {
        if (n == 0 || n==1) return 0;

        int one = cost[n - 1] + findMinCostRec(n - 1, cost);

        int two = cost[n - 2] + findMinCostRec(n - 2, cost);

        return Math.min(one, two);
    }
}
