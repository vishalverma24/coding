package org.example.dp2d;

public class PlusMinusTarget {

    public static void main(String[] args){

        int target = 3;

        int[] arr = {1,2,3,1};

        /*
        Not this way,
        Use count subsets == target
         */
        int count = countWaysRec(arr,target,arr.length-1);
        System.out.println(count);

        int totalSum=0;
        for(int i=0;i<arr.length;i++){
            totalSum = totalSum + arr[i];
        }

        int countRec = countWaysRecursion(arr,(totalSum-target)/2,arr.length-1);
        System.out.println(countRec);

        int countTab = countWaysTab(arr,(totalSum-target)/2,arr.length);
        System.out.println(countTab);
    }

    private static int countWaysTab(int[] num, int k, int n) {
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

    private static int countWaysRecursion(int[] arr, int target, int i) {

        if(target == 0) return 1;
        if(i == 0) return arr[0] == target?1:0;

        int notPick = countWaysRecursion(arr,target,i-1);
        int pick = 0;

        if(target>=arr[i]){
            pick = countWaysRecursion(arr,target - arr[i],i-1);
        }

        return (pick + notPick);

    }

    private static int countWaysRec(int[] arr, int target, int i) {

        if(i==0){
            if(target==arr[i] || target+arr[i]==0){
                return 1;
            } else{
                return 0;
            }
        }

        int plus = countWaysRec(arr,target - arr[i],i-1);
        int minus = countWaysRec(arr,target + arr[i], i-1);

        return plus + minus;
    }
}
