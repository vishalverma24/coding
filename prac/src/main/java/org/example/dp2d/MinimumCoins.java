package org.example.dp2d;

import java.util.Arrays;

public class MinimumCoins {

    public static void main(String[] args){

        int[] coins = {1,2,3};
        int amount = 4;

        int[][] dp = new int[coins.length][amount + 1];


        int minCoinsRec = minCoinsNeedRec(coins,amount,coins.length-1);
        System.out.println(minCoinsRec);

        for (int row[] : dp){
            Arrays.fill(row, 0);
        }

        int minCoinsMemo = minimumElementsUtil(coins,amount,coins.length-1,dp);
        System.out.println(minCoinsMemo);


        int minCoinsTab = minimumCoinsTab(coins,amount,dp);
        System.out.println(minCoinsTab);

        for (int row[] : dp){
            Arrays.fill(row, -1);
        }

        /*
        minimum coins 2
         */
        int count = countWaysCoins(coins,amount,dp);
        System.out.println(count);
    }

    private static int countWaysCoins(int[] coins, int amount, int[][] dp) {
        for(int target=0;target<=amount;target++){
            dp[0][target]=target%coins[0]==0?1:0;
        }

        for(int i=1;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                int notTake = dp[i - 1][j];
                int take =0;

                if(coins[i]<=j){
                    take = dp[i][j-coins[i]];
                }

                dp[i][j] = take + notTake;
            }
        }

        return dp[coins.length-1][amount];

    }
    private static int minimumCoinsTab(int[] coins, int amount, int[][] dp) {
        for(int target=0;target<=amount;target++){
            dp[0][target]=target%coins[0]==0?target/coins[0]:(int) Math.pow(10, 9);
        }

        for(int i=1;i<coins.length-1;i++){
            for(int j=0;j<=amount;j++){
                int notTake = dp[i - 1][j];
                int take =  (int) Math.pow(10, 9);

                if(coins[i]<=j){
                    take = 1 + dp[i][j-coins[i]];
                }

                dp[i][j]=Math.min(notTake,take);
            }
        }

        return dp[coins.length-1][amount];

    }

    private static int minCoinsNeedRec(int[] coins, int amount, int i) {

        if(i==0){
            if((amount%coins[0])==0){
                return amount/coins[0];
            }else{
                return  (int) Math.pow(10, 9);
            }
        }

        int notTake = minCoinsNeedRec(coins, amount, i - 1);
        int take =  (int) Math.pow(10, 9);

        if(coins[i]<=amount){
            take = 1 + minCoinsNeedRec(coins,amount-coins[i],i);
        }

        return Math.min(take,notTake);
    }

    private static int minimumElementsUtil(int[] arr, int T, int ind, int[][] dp) {
        // Base case: If the current index is 0
        if (ind == 0) {
            // If T is divisible by the first element of the array, return the quotient
            if (T % arr[0] == 0){
                return T / arr[0];
            } else{
                // If not, return a large value to indicate it's not possible
                return (int) Math.pow(10, 9);
                }
        }

        // If the result for this subproblem has already been calculated, return it
        if (dp[ind][T] != -1){
            return dp[ind][T];
        }

        // Calculate the minimum number of elements needed without taking the current element
        int notTaken = minimumElementsUtil(arr, T,ind - 1, dp);

        // Initialize the minimum number of elements needed taking the current element
        int taken = (int) Math.pow(10, 9);

        // If the current element is less than or equal to T, calculate the minimum taking it
        if (arr[ind] <= T)
            taken = 1 + minimumElementsUtil(arr, T - arr[ind],ind, dp);

        // Store the minimum result in the dp array and return it
        return dp[ind][T] = Math.min(notTaken, taken);
    }
}
