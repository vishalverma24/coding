package org.example.dp2d;

import java.util.Arrays;

public class GridUniquePaths {

    public static void main(String args[]){
        int[][] arr = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};

//        int[][] arr = {{2,2},{2,2}};

        int m = arr.length;
        int n = arr[0].length;

        int[][] dp = new int [m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }

        //recursion
        int uniquePathRec = findUniqueRec(m-1,n-1);
        System.out.println(uniquePathRec);

        //memo
        int uniquePathDpMemo = findUniqueMemo(m-1,n-1,dp);
        System.out.println(uniquePathDpMemo);

        //Tab
        int uniquePathTab = findUniqueTab(m,n,dp);
        System.out.println(uniquePathTab);

        //Space Opt
//        int uniquePathOpt = findUniqueOpt(m,n);

    }

    private static int findUniqueTab(int m, int n, int[][] dp) {

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(i==0 && j==0){
                    dp[i][j] = 1;
                } else{
                    int up = 0;
                    int left = 0;
                    if(i>0){
                        up = dp[i-1][j];
                    }
                    if(j>0){
                        left = dp[i][j-1];
                    }
                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m-1][n-1];
    }

    private static int findUniqueMemo(int i, int j, int[][] dp) {

        if(i==0 && j==0) return 1;

        if(i<0 || j<0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int up = findUniqueMemo(i-1,j,dp);
        int left = findUniqueMemo(i, j-1,dp);

        return dp[i][j] = up + left;
    }

    private static int findUniqueRec(int i, int j) {

        if(i==0 && j==0) return 1;

        if(i<0 || j<0) return 0;

        int up = findUniqueRec(i-1,j);
        int left = findUniqueRec(i, j-1);

        return up + left;
    }
}
