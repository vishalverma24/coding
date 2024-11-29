package org.example.dp2d;

public class FallingPathSum {

    public static void main(String args[]){
        int[][] arr = {{1,2,3},{4,5,4},{20,5,9}};

        int n = arr.length;
        int m = arr[0].length;

        //Rec
        int maxSumRec = 0;

        for(int j=0;j<m;j++){
            maxSumRec = Math.max(maxSumRec,findMaxSumRec(arr,n-1,j,m));
        }
        System.out.println(maxSumRec);

        int[][] dp = new int [n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }

        int maxSumMemo = 0;
        //Memo
        for(int j=0;j<m;j++){
            maxSumMemo = Math.max(maxSumMemo,findMaxSumMemo(arr,n-1,j,m,dp));
        }
        System.out.println(maxSumMemo);

        //Tab
        int maxSumTab = findMaxSumTab(arr,n,m,dp);
        System.out.println(maxSumTab);
    }

    private static int findMaxSumTab(int[][] arr, int n, int m, int[][] dp) {
        for(int j=0;j<m;j++){
            dp[0][j] = arr[0][j];
        }

        int up = -1000;
        int left = -1000;
        int right = -1000;

        for(int i=1;i<n;i++){
            for (int j=0;j<m;j++){
                up = arr[i][j] + dp[i-1][j];
                if(j>1) left = arr[i][j] + dp[i-1][j-1];
                if(j<m-1)right = arr[i][j] + dp[i-1][j+1];

                dp[i][j] = Math.max(up,Math.max(left,right));
            }
        }

        int maxi = 0;
        for(int j=0;j<m;j++){
            maxi = Math.max(maxi,dp[n-1][j]);
        }

        return maxi;
    }

    private static int findMaxSumMemo(int[][] arr, int i, int j, int m, int[][] dp) {

        if(i==0) return arr[0][j];

        if(j<0 || j>=m) return Integer.MIN_VALUE;

        if(dp[i][j]!=-1) return dp[i][j];
        int up = -100;
        int left = -100;
        int right = -100;

        up = arr[i][j] + findMaxSumRec(arr,i-1,j,m);
        if(j>0) left = arr[i][j] + findMaxSumRec(arr,i-1,j-1,m);
        if(j<m-1)right = arr[i][j] + findMaxSumRec(arr,i-1,j+1,m);


        return dp[i][j] = Math.max(up,Math.max(left,right));

    }

    private static int findMaxSumRec(int[][] arr, int i, int j,int m) {

        if(i==0) return arr[0][j];

        if(j<0 || j>=m) return Integer.MIN_VALUE;

        int up = -100;
        int left = -100;
        int right = -100;

        up = arr[i][j] + findMaxSumRec(arr,i-1,j,m);
        if(j>0) left = arr[i][j] + findMaxSumRec(arr,i-1,j-1,m);
        if(j<m-1)right = arr[i][j] + findMaxSumRec(arr,i-1,j+1,m);


        return Math.max(up,Math.max(left,right));
    }
}
