package org.example.dp2d;

public class CountPartitionWithDiff {

    public static void main(String args[]){

        /*
        Base case changes if arr contains 0;
         */
        int[] arr = {1,2,3,1};

        int diff = 3;

        //s1-s2=diff
        //(total-diff)/2=s2

        int totalSum=0;
        for(int i=0;i<arr.length;i++){
            totalSum = totalSum + arr[i];
        }

        System.out.println("totalSum : " + totalSum);
        System.out.println("differnece : " + diff);

        int[][] dp = new int[arr.length][totalSum+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }

        if(totalSum-diff>0 && (totalSum-diff)%2==0){
            int countSubsetTab = countSubsetPresentTargetTab(arr,(totalSum-diff)/2,arr.length);
            System.out.println(countSubsetTab);
        } else {
            System.out.println(0);
        }

    }

    private static int countSubsetPresentTargetTab(int[] num, int k, int n) {

        int[][] dp = new int[n][k + 1];

        //base cases changed

        if(num[0]==0){
            dp[0][0] = 2;
        } else{
            dp[0][0] = 1;
        }

        if (num[0]!=0 && num[0] <= k) {
            dp[0][num[0]] = 1;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= k; target++) {
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

        /*
        this causes problrms as not take starting 0's
         */
//        if(target == 0) return 1;

        if(i ==0){
            if(target==0 && arr[0]==0) return 2;
            if(target==0 || target==arr[0]) return 1;
            return 0;
        }

        /*
        changed above
         */
//        if(i == 0) return arr[0] == target?1:0;

        if(dp[i][target]!=-1) return dp[i][target];

        int notPick = countSubsetPresentTargetMemo(arr,target,i-1,dp);
        int pick = 0;

        if(target>=arr[i]){
            pick = countSubsetPresentTargetMemo(arr,target - arr[i],i-1,dp);
        }

        return dp[i][target] = pick + notPick;
    }
}
