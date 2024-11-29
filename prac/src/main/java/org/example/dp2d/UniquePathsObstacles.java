package org.example.dp2d;

public class UniquePathsObstacles {


    public static void main(String args[]){
        int[][] arr = {{0,0,0},{0,-1,0},{0,0,0}};

        int m = arr.length;
        int n = arr[0].length;

        int[][] dp = new int [m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }

        //recursion
        int uniquePathRec = findUniqueRec(m-1,n-1,arr);
        System.out.println(uniquePathRec);

        //memo
        int uniquePathDpMemo = findUniqueMemo(m-1,n-1,dp,arr);
        System.out.println(uniquePathDpMemo);

        //Tab
        int uniquePathTab = findUniqueTab(m,n,dp,arr);
        System.out.println(uniquePathTab);

    }

    private static int findUniqueTab(int m, int n, int[][] dp, int[][] arr) {

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==-1){
                    dp[i][j] = 0;
                } else if(i==0 && j==0){
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

    private static int findUniqueMemo(int i, int j, int[][] dp, int[][] arr) {

        if(i==0 && j==0) return 1;

        if(i<0 || j<0) return 0;

        if(arr[i][j]==-1) return 0;


        if(dp[i][j]!=-1) return dp[i][j];

        int up = findUniqueMemo(i-1,j,dp, arr);
        int left = findUniqueMemo(i, j-1,dp, arr);

        return dp[i][j] = up + left;
    }

    private static int findUniqueRec(int i, int j, int[][] arr) {

        if(i==0 && j==0) return 1;

        if(i<0 || j<0) return 0;

        if(arr[i][j]==-1) return 0;

        int up = findUniqueRec(i-1,j, arr);
        int left = findUniqueRec(i, j-1, arr);

        return up + left;
    }
}
