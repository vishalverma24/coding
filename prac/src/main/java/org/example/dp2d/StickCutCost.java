package org.example.dp2d;

public class StickCutCost {

    public static void main(String[] args) {

        int[] cuts = {1,3,4,5};
        int n = 7;

//        answer = 16
//        re-arrange cuts to get min cost. Cost is length of stick to cut

        int[][] dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        int minRec = findMinValueRec(cuts,n-1,n);
        System.out.println(minRec);

        int minTab = findMinValue(cuts,n,dp);
        System.out.println(minTab);
    }

    private static int findMinValue(int[] cuts, int n, int[][] dp) {
        return 0;
    }

    private static int findMinValueRec(int[] cuts, int i, int n) {
        return 0;
    }
}
