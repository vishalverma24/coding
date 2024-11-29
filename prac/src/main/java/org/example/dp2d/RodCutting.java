package org.example.dp2d;

public class RodCutting {


    public static void main(String[] args) {

        int[] value = {4,2,18,19,23};
        int n = 5;

        int[][] dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        int maxValueUnboundedRec = findMaxValueRecUnbounded(value,n-1,n);
        System.out.println(maxValueUnboundedRec);

        int maxValueUnbTab = findMaxValueUnbTab(value,n,dp);
        System.out.println(maxValueUnbTab);
    }

    private static int findMaxValueUnbTab(int[] value, int n, int[][] dp) {

        for(int i=0;i<=n;i++){
            dp[0][i] = i*value[0];
        }

        for(int i=1;i<value.length;i++){
            for(int j=0;j<=n;j++){
                int notTake = dp[i - 1][j];

                int take = Integer.MIN_VALUE;

                int rodLength = i+1;
                if (rodLength <= j) {
                    take = value[i] + dp[i][j - rodLength];
                }

                dp[i][j] = Math.max(take,notTake);
            }
        }

        return dp[n-1][n];
    }


    private static int findMaxValueRecUnbounded(int[] value, int i, int N) {

        if (i == 0) {
            return N*value[0];
        }

        int notTake = findMaxValueRecUnbounded(value, i - 1, N);

        int take = Integer.MIN_VALUE;

        int rodLength = i+1;
        if (rodLength <= N) {
            take = value[i] + findMaxValueRecUnbounded(value, i, N - rodLength);
        }

        return Math.max(notTake, take);

    }
}
