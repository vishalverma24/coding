package org.example.dp;

import java.util.Arrays;

public class ClimbingStairs {

    /*
    To reach the last stair, last step could be n-1 or n-2, hence fibonacci
     */

    public static void main(String args[]){

        int n=10;

        int[] dp = new int[n+1];

        int fiboRec = findFiboRec(n);
        System.out.println(fiboRec);

        Arrays.fill(dp,-1);

        int fiboMemo = findFiboMemo(n,dp);
        System.out.println(fiboMemo);

        Arrays.fill(dp,-1);

        int fiboTab = findFiboTab(n,dp);
        System.out.println(fiboTab);

    }

    private static int findFiboTab(int n, int[] dp) {

        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
    private static int findFiboMemo(int n, int[] dp) {

        if(n ==0 || n==1) return 1;

        if(dp[n]!=-1) return dp[n];

        dp[n] = findFiboMemo(n-1,dp) + findFiboMemo(n-2,dp);

        return dp[n];
    }

    private static int findFiboRec(int n) {

        if(n ==0 || n==1) return 1;

        return findFiboRec(n-1) + findFiboRec(n-2);
    }
}
