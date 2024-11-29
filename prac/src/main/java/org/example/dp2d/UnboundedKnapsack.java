package org.example.dp2d;

public class UnboundedKnapsack {

    public static void main(String[] args) {
        int[] weight = {2, 4, 6};
        int[] value = {5, 11, 13};
        int n = 3;
        int maxWeight = 10;

        int[][] dp = new int[n][maxWeight + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                dp[i][j] = -1;
            }
        }

        int maxValueUnboundedRec = findMaxValueRecUnbounded(weight,value,n-1,maxWeight);
        System.out.println(maxValueUnboundedRec);

        int maxValueUnbTab = findMaxValueUnbTab(weight,value,maxWeight,dp);
        System.out.println(maxValueUnbTab);
    }


    private static int findMaxValueUnbTab(int[] weight, int[] value, int maxWeight, int[][] dp) {

        for(int w=0;w<=maxWeight;w++){
            dp[0][w] = (w/weight[0])*value[0];
        }

        for(int i=1;i<weight.length;i++){
            for(int j=0;j<=maxWeight;j++){
                int notTake = dp[i - 1][j];

                int take = Integer.MIN_VALUE;

                if (weight[i] <= j) {
                    take = value[i] + dp[i][j - weight[i]];
                }

                dp[i][j] = Math.max(take,notTake);
            }
        }

        return dp[weight.length-1][maxWeight];
    }


    private static int findMaxValueRecUnbounded(int[] weight, int[] profits, int i, int W) {

        if (i == 0) {
            return (W/weight[0])*profits[0];
        }

        int notTake = findMaxValueRecUnbounded(weight, profits, i - 1, W);

        int take = Integer.MIN_VALUE;

        if (weight[i] <= W) {
            take = profits[i] + findMaxValueRecUnbounded(weight, profits, i, W - weight[i]);
        }

        return Math.max(notTake, take);

    }
}
