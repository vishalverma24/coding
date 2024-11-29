package org.example.dp2d;

public class PartitionSubsetMinimumDiff {

    public static void main(String args[]){

        int[] arr = {2,4,6,8};

        int totalSum=0;
        for(int i=0;i<arr.length;i++){
            totalSum = totalSum + arr[i];
        }

        int target = totalSum;

        boolean[][] dp = new boolean[arr.length][totalSum+1];
        boolean isPresent = isTargetPresent(arr,target,arr.length,dp);

        for(int i=0;i< dp.length;i++){
            for(int j=0;j<=totalSum;j++){
                System.out.print(dp[i][j] + ", ");
            }
            System.out.println();
        }

        int minDiff = minSubSetDiff(arr,target,dp,arr.length);
        System.out.println(minDiff);
    }

    private static int minSubSetDiff(int[] arr, int target, boolean[][] dp, int n) {
        int mini = Integer.MAX_VALUE;

        for(int s1=0;s1<=target/2;s1++){
            if(dp[n - 1][s1]){
                mini = Math.min(mini,Math.abs((target-s1)-s1));
            }
        }

        return mini;
    }

    private static boolean isTargetPresent(int[] arr, int k, int n, boolean[][] dp) {


        // Initialize the first row of the DP table
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Initialize the first column of the DP table
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        // Fill in the DP table using bottom-up approach
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                // Calculate if the current target can be achieved without taking the current element
                boolean notTaken = dp[ind - 1][target];

                // Calculate if the current target can be achieved by taking the current element
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }

                // Store the result in the DP table
                dp[ind][target] = notTaken || taken;
            }
        }

        // The final result is stored in the bottom-right cell of the DP table
        return dp[n - 1][k];

    }
}
