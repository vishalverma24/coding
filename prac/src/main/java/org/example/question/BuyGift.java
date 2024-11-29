package org.example.question;

public class BuyGift {
    public static void main(String[] args){


        /**
         * Buy gift(price list Given on days), find the max amount of gifts that can be bought, you can save 1 rupee per day
         */

        int[] prices = {3,2,3,1,2};

        int n = prices.length;
        int perDaySave = 1;
        int maxMoneySaved = n*perDaySave;

        int maxGifts = findMaxGiftsRec(n-1,maxMoneySaved,prices,perDaySave);
        System.out.println(maxGifts);

        int[][] dp = new int[n][maxMoneySaved + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= maxMoneySaved; j++) {
                dp[i][j] = -1;
            }
        }

        int maxGift = findMaxGiftMemo(n-1,maxMoneySaved,prices,perDaySave,dp);
        System.out.println(maxGift);

        int[][] dpTab = new int[n][maxMoneySaved + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= maxMoneySaved; j++) {
                dpTab[i][j] = -1;
            }
        }

        int maxGiftTab = findMaxGiftTab(n,maxMoneySaved,prices,perDaySave,dp);
        System.out.println(maxGiftTab);
    }

    private static int findMaxGiftTab(int n, int maxMoneySaved, int[] prices, int perDaySave, int[][] dp) {

        for(int money=prices[0];money<maxMoneySaved;money++){
            dp[0][money] = 1;
        }

        for(int money=0;money<prices[0];money++){
            dp[0][money] = 0;
        }

        for(int i=1;i<n;i++){
            for(int money = 1;money<=maxMoneySaved;money++){
                int buy = 0;
                int notBuy = 0;

                if(money>=prices[i]){
                    buy = 1 + dp[i-1][money-prices[i]];
                }

                notBuy = dp[i-1][money];

            }
        }

        return dp[n-1][maxMoneySaved];

    }

    private static int findMaxGiftMemo(int i, int money, int[] prices, int perDaySave, int[][] dp) {

        if(money<=0){
            return 0;
        }

        if(i==0){
            return prices[0]>perDaySave?0:1;
        }

        if(dp[i][money]!=-1) return dp[i][money];

        int buy = 0;
        int notBuy = 0;

        if(money>=prices[i]){
            buy = 1 + findMaxGiftsRec(i - 1, money - prices[i], prices,perDaySave);
        }

        notBuy = findMaxGiftsRec(i-1,money,prices,perDaySave);

        return dp[i][money] = Math.max(buy,notBuy);

    }

    private static int findMaxGiftsRec(int i, int money, int[] prices, int perDaySave) {

        if(money<=0){
            return 0;
        }

        if(i==0){
            return prices[0]>perDaySave?0:1;
        }

        int buy = 0;
        int notBuy = 0;

        if(money>=prices[i]){
            buy = 1 + findMaxGiftsRec(i - 1, money - prices[i], prices,perDaySave);
        }

        notBuy = findMaxGiftsRec(i-1,money,prices,perDaySave);

        return Math.max(buy,notBuy);

    }
}
