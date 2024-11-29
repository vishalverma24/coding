package org.example.dpStrings;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "cde";

        int n = s1.length();
        int m = s2.length();


        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        Integer lcsSubstring = fs(n, m, s1, s2,dp);
        System.out.println(lcsSubstring);

    }

    private static Integer fs(int n, int m, String s1, String s2, int[][] dp) {

        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }

        for(int j=0;j<=m;j++){
            dp[0][j] = 0;
        }

        int ans = 0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    ans = Math.max(ans,dp[i][j]);
                } else{
                    dp[i][j] = 0;
                }
            }
        }

        return ans;
    }
}
