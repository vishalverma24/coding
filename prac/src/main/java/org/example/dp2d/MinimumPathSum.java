package org.example.dp2d;

public class MinimumPathSum {

    public static void main(String args[]){

        int[][] arr = {{1,2,3},{4,5,4},{7,5,9}};

        int n = arr.length;
        int m = arr[0].length;

        //Rec
        int minSumRec = findMinSum(arr,n-1,m-1);
        System.out.println(minSumRec);

        int[][] dp = new int [n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }

        //memo
        int minSumMemo = findMinSumMemo(arr,n-1,m-1,dp);
        System.out.println(minSumMemo);


        //Tab
        int minSumTab = findMinSumTab(arr,n,m,dp);
        System.out.println(minSumTab);
    }

    private static int findMinSumTab(int[][] arr, int n, int m, int[][] dp) {

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    dp[0][0]= arr[0][0];
                }else{
                    int up = Integer.MAX_VALUE;
                    int left=Integer.MAX_VALUE;
                    if(i>0) up = arr[i][j] + dp[i-1][j];
                    if(j>0) left = arr[i][j] + dp[i][j-1];

                    dp[i][j] = Math.min(up,left);
                }
            }
        }

        return dp[n-1][m-1];
    }

    private static int findMinSumMemo(int[][] arr, int i, int j, int[][] dp) {

        if(i==0 && j==0) return arr[0][0];

        if(i<0 || j<0) return Integer.MAX_VALUE;

        if(dp[i][j]!=-1) return dp[i][j];

        int up=Integer.MAX_VALUE;
        int left=Integer.MAX_VALUE;

        if(i>0) up = arr[i][j] +  findMinSum(arr,i-1,j);
        if(j>0) left = arr[i][j] + findMinSum(arr,i,j-1);


        return dp[i][j] = Math.min(up,left);
    }

    private static int findMinSum(int[][] arr, int i, int j) {

        if(i==0 && j==0) return arr[0][0];

        if(i<0 || j<0) return Integer.MAX_VALUE;

        int up=Integer.MAX_VALUE;
        int left=Integer.MAX_VALUE;

        if(i>0) up = arr[i][j] +  findMinSum(arr,i-1,j);
        if(j>0) left = arr[i][j] + findMinSum(arr,i,j-1);


        return Math.min(up,left);

    }
}
