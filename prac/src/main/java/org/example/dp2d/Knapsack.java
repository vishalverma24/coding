package org.example.dp2d;

public class Knapsack {

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
        int maxValueRec = findMaxValueRec(weight, value, n - 1, maxWeight);
        System.out.println(maxValueRec);

        int maxValueMemo = findMaxValueMemo(weight, value, n - 1, maxWeight, dp);
        System.out.println(maxValueMemo);

        int maxValueTab = findMaxValueTab(weight, value, n, maxWeight, dp);
        System.out.println(maxValueTab);

    }

    private static int findMaxValueTab(int[] weight, int[] value, int n, int maxWeight, int[][] dp) {

        for (int wt = weight[0]; wt <= maxWeight; wt++) {
            dp[0][wt] = value[0];
        }

        for (int i = 1; i < n; i++) {
            for (int wt = weight[0]; wt <= maxWeight; wt++) {
                int notTake = dp[i - 1][maxWeight];

                int take = Integer.MIN_VALUE;

                if (weight[i] <= wt) {
                    take = value[i] + dp[i - 1][wt - weight[i]];
                }
            }
        }

        return dp[n - 1][maxWeight];
    }

    private static int findMaxValueMemo(int[] weight, int[] value, int i, int maxWeight, int[][] dp) {

        if (i == 0) {
            if (weight[0] <= maxWeight) {
                return value[0];
            } else {
                return 0;
            }
        }

        if (dp[i][maxWeight] != -1) return dp[i][maxWeight];

        int notTake = findMaxValueRec(weight, value, i - 1, maxWeight);

        int take = Integer.MIN_VALUE;

        if (weight[i] <= maxWeight) {
            take = value[i] + findMaxValueRec(weight, value, i - 1, maxWeight - weight[i]);
        }

        return dp[i][maxWeight] = Math.max(notTake, take);
    }

    private static int findMaxValueRec(int[] weight, int[] value, int i, int maxWeight) {

        if (i == 0) {
            if (weight[0] <= maxWeight) {
                return value[0];
            } else {
                return 0;
            }
        }

        int notTake = findMaxValueRec(weight, value, i - 1, maxWeight);

        int take = Integer.MIN_VALUE;

        if (weight[i] <= maxWeight) {
            take = value[i] + findMaxValueRec(weight, value, i - 1, maxWeight - weight[i]);
        }

        return Math.max(notTake, take);
    }


}
