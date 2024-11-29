package org.example.dp2d;

public class Triangle {

    public static void main(String args[]) {

        int[][] arr = {{2}, {4, 5}, {7, 5, 9}};

        int n = arr.length;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        int[][] tab = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tab[i][j] = 0;
            }
        }


        //Same as min Path with conditions
        int minSum = findMinSumTriangleMinPath(arr, n,dp);
        System.out.println(minSum);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        //Rec
        int minSumRec = findMinSumTriRec(arr,0, 0, n);
        System.out.println(minSumRec);

        //Memo
        int minSumMemo = findMinSumTriMemo(arr,0, 0, n,dp);
        System.out.println(minSumMemo);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        //Tab
        int minSumTab = findMinSumTriTab(arr, n,dp);
        System.out.println(minSumTab);
    }

    private static int findMinSumTriTab(int[][] arr, int n, int[][] dp) {

        for(int j=0;j<n;j++){
            dp[n-1][j]=arr[n-1][j];
        }

        for(int i=n-2;i>=0;i--){
            for(int j = i;j>=0;j--){
                int down = arr[i][j] + dp[i+1][j];
                int diagnol = arr[i][j] + dp[i+1][j+1];

                dp[i][j]=Math.min(down,diagnol);
            }
        }

        return dp[0][0];
    }

    private static int findMinSumTriMemo(int[][] arr, int i, int j, int n, int[][] dp) {

        if(i==n-1) return arr[n-1][j];

        if(dp[i][j]!=-1) return dp[i][j];

        int down = arr[i][j] + findMinSumTriMemo(arr,i+1, j,n,dp);
        int daignol = arr[i][j] + findMinSumTriMemo(arr,i+1,j+1,n,dp);

        int diff = Math.min(down,daignol);
        return dp[i][j] = diff;
    }

    private static int findMinSumTriRec(int[][] arr, int i, int j, int n) {

        if(i==n-1) return arr[n-1][j];

        int down = arr[i][j] + findMinSumTriRec(arr,i+1, j,n);
        int daignol = arr[i][j] + findMinSumTriRec(arr,i+1,j+1,n);

        return Math.min(down,daignol);
    }

    private static int findMinSumTriangleMinPath(int[][] arr, int n, int[][] dp) {

        for(int i=0;i<n;i++){
            for(int j=0;j<arr[i].length;j++){
                if(i==0 && j==0){
                    dp[0][0]= arr[0][0];
                }else{
                    int diagnol = Integer.MAX_VALUE;
                    int left=Integer.MAX_VALUE;
                    int up = Integer.MAX_VALUE;

                    if(i>0 && i>=j+1) up = arr[i][j] + dp[i-1][j];
                    if(j>0) left = arr[i][j] + dp[i][j-1];
                    if(j>0 && i>0) diagnol = arr[i][j] + dp[i-1][j-1];

                    int diff = Math.min(left,diagnol);
                    if(i==n-1 && j>0){
                        int diff2 = Math.min(diff,up);
                        dp[i][j] = Math.min(diff2,dp[i][j-1]);
                    } else{
                        dp[i][j] = Math.min(diff,up);
                    }
                }
            }
        }

        return dp[n-1][n-1];
    }
}
