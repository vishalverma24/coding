package org.example.dp2d;

public class SunbSetEqualsTarget {

    public static void main(String args[]){
        int[] arr = {1,2,5,3,4};
        int target = 15;

        boolean[][] dp = new boolean[arr.length][target+1];

//        Boolean isSubSetPresetForTargetRec = isSubSetTarget(arr,target,arr.length-1);
//        System.out.println(isSubSetPresetForTargetRec);
//
//        Boolean isSubSetPresetForTargetMemo = isSubSetTargetMemo(arr,target,arr.length-1,dp);
//        System.out.println(isSubSetPresetForTargetMemo);

        Boolean isSubSetPresetForTargetTab = isSubSetTargetTab(arr,target,arr.length,dp);
        System.out.println(isSubSetPresetForTargetTab);

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j] + ", ");
            }
            System.out.println();
        }
    }

    private static Boolean isSubSetTargetTab(int[] arr, int k, int n, boolean[][] dp) {

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                boolean notTaken = dp[ind - 1][target];
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }
                dp[ind][target] = notTaken || taken;
            }
        }

        return dp[n - 1][k];

    }

    private static boolean isSubSetTargetMemo(int[] arr, int target, int ind, boolean[][] dp) {

        if(target == 0) return true;
        if(ind == 0) return arr[0] == target;

        if(dp[ind][target]) return dp[ind][target];
        Boolean notPick = isSubSetTargetMemo(arr,target,ind-1,dp);
        Boolean pick = false;

        if(target>=arr[ind]){
            pick = isSubSetTargetMemo(arr,target - arr[ind],ind-1,dp);
        }

        return dp[ind][target] = (pick || notPick);
    }

    private static Boolean isSubSetTarget(int[] arr, int target, int ind) {

        if(target == 0) return true;
        if(ind == 0) return arr[0] == target;

        Boolean notPick = isSubSetTarget(arr,target,ind-1);
        Boolean pick = false;

        if(target>=arr[ind]){
            pick = isSubSetTarget(arr,target - arr[ind],ind-1);
        }

        return (pick || notPick);
    }

}
