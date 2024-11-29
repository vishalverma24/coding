package org.example.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FrogJumpKdistance {

    public static void main(String args[])
    {
        ArrayList<Integer> height = new ArrayList<>(List.of(10,20,30,10));

        int n = height.size();
        int k = 2;
        System.out.println(solve(n, height, k));
    }

    private static int solve(int n, ArrayList<Integer> height, int k) {
        int[] dp = new int[n]; // Initialize a memoization array to store calculated results
        Arrays.fill(dp, -1);
        return solveUtil(n, height, dp, k);
    }

    private static int solveUtil(int n, ArrayList<Integer> height, int[] dp, int k) {
        dp[0] = 0;

        // Loop through the array to fill in the dp array
        for (int i = 1; i < n; i++) {
            int mmSteps = Integer.MAX_VALUE;

            // Loop to try all possible jumps from '1' to 'k'
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(height.get(i) - height.get(i - j));
                    mmSteps = Math.min(jump, mmSteps);
                }
            }
            dp[i] = mmSteps;
        }
        return dp[n - 1];
    }
}
