package org.example.dpStrings;

public class LongestCommonSubsequence {

    public static void main(String[] args){
        String s1 = "abcde";
        String s2 = "cde";

        int n = s1.length();
        int m = s2.length();

        Integer lcsString = f(n-1,m-1,s1,s2);
        System.out.println(lcsString);

        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }

        Integer lcsStringMemo = fmemo(n-1,m-1,s1,s2,dp);
        System.out.println(lcsStringMemo);

        Integer lcsStringMemoIndexShift = fmemoShift(n-1,m-1,s1,s2,dp);
        System.out.println(lcsStringMemoIndexShift);

        Integer lcsStringTab = fmemoTab(n,m,s1,s2,dp);
        System.out.println(lcsStringTab);

        /**
         * Also same for Longest Palindromic Subsequence(LPS)
         */


        /**
         * min insertions to make string palindrome = str.length() - LPS
         */

        /**
         * deletions/insertions to make string A to B = A.length() + B.length() - 2*LCS
         */

/**
 * DP 26
 */
//        printlcs
    }

    private static Integer fmemoTab(int n, int m, String s1, String s2, int[][] dp) {

        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }

        for(int j=0;j<=m;j++){
            dp[0][j] = 0;
        }


        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }

    private static Integer fmemoShift(int i, int j, String s1, String s2, int[][] dp) {

        if(i==0 || j==0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        if(s1.charAt(i-1)==s2.charAt(j-1)){
            return dp[i][j] = 1 + f(i-1,j-1,s1,s2);
        }

        return dp[i][j] = Math.max(f(i-1,j,s1,s2),f(i,j-1,s1,s2));
    }

    private static Integer fmemo(int i, int j, String s1, String s2, int[][] dp) {

        if(i<0 || j<0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] = 1 + f(i-1,j-1,s1,s2);
        }

        return dp[i][j] = Math.max(f(i-1,j,s1,s2),f(i,j-1,s1,s2));
    }

    private static Integer f(int i, int j, String s1, String s2) {

        if(i<0 || j<0) return 0;

        if(s1.charAt(i)==s2.charAt(j)) return 1 + f(i-1,j-1,s1,s2);

        return Math.max(f(i-1,j,s1,s2),f(i,j-1,s1,s2));
    }
}
