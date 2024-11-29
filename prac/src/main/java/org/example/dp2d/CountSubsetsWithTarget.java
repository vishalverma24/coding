package org.example.dp2d;

public class CountSubsetsWithTarget {

    public static void main(String args[]){

        int[] arr = {2,4,6,8,12};

        int k = 20;

        int[][] dp = new int[arr.length][k+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }

        int countSubsetRec = countSubsetPresentTargetRec(arr,k,arr.length-1);
        System.out.println(countSubsetRec);

        int countSubsetMemo = countSubsetPresentTargetMemo(arr,k,arr.length-1,dp);
        System.out.println(countSubsetMemo);

        int countSubsetTab = countSubsetPresentTargetTab(arr,k,arr.length);
        System.out.println(countSubsetTab);

    }

    private static int countSubsetPresentTargetTab(int[] num, int k, int n) {

        int[][] dp = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        if (num[0] <= k) {
            dp[0][num[0]] = 1;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                int notTaken = dp[ind - 1][target];
                int taken = 0;
                if (num[ind] <= target) {
                    taken = dp[ind - 1][target - num[ind]];
                }
                dp[ind][target] = notTaken + taken;
            }
        }

        return dp[n-1][k];
    }

    private static int countSubsetPresentTargetMemo(int[] arr, int target, int i, int[][] dp) {

        if(target == 0) return 1;
        if(i == 0) return arr[0] == target?1:0;

        if(dp[i][target]!=-1) return dp[i][target];

        int notPick = countSubsetPresentTargetMemo(arr,target,i-1,dp);
        int pick = 0;

        if(target>=arr[i]){
            pick = countSubsetPresentTargetMemo(arr,target - arr[i],i-1,dp);
        }

        return dp[i][target] = pick + notPick;
    }

    private static int countSubsetPresentTargetRec(int[] arr, int target, int i) {

        if(target == 0) return 1;
        if(i == 0) return arr[0] == target?1:0;

        int notPick = countSubsetPresentTargetRec(arr,target,i-1);
        int pick = 0;

        if(target>=arr[i]){
            pick = countSubsetPresentTargetRec(arr,target - arr[i],i-1);
        }

        return (pick + notPick);
    }
}
