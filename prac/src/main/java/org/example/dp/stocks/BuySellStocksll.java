package org.example.dp.stocks;

public class BuySellStocksll {
    public static void main(String[] args) {

        int[] prices = {2, 4, 5, 7, 3, 6};

        /**
         * Make maximum profit. Can buy sell multiple. Buy first. Buy Sell alternate(Sell before next buy)
         */

        int n = prices.length;
        int buy = 1; // 1 is true

        int maxProfitRec = findMaxProfitRec(0, n, prices, buy);

        System.out.println(maxProfitRec);

        int[][] dp = new int[n][2];

        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }

        int maxProfitMemo = findMaxProfitMemo(0, n, prices, buy, dp);
        System.out.println(maxProfitMemo);


        int[][] dpTab = new int[n+1][2];

        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                dpTab[i][j]=0;
            }
        }

        int maxProfitTab = findMaxProfitTab(prices,dpTab,n);
        System.out.println(maxProfitTab);
    }

    private static int findMaxProfitTab(int[] prices, int[][] dp, int n) {
        dp[n][0] = 0;
        dp[n][1]=0;

        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){

                if (buy == 1) {
                    int bought = -prices[i] + dp[i + 1][0];
                    int notBought = dp[i + 1][ 1];
                    dp[i][buy] = Math.max(bought, notBought);
                } else {
                    int sell = prices[i] + dp[i + 1][1];
                    int notSell = dp[i + 1][0];
                    dp[i][buy] = Math.max(sell, notSell);
                }
            }
        }

        return dp[0][1];
    }

    private static int findMaxProfitMemo(int i, int n, int[] prices, int buy, int[][] dp) {
        if (i == n) {
            return 0;
        }

        if(dp[i][buy]!=-1) return dp[i][buy];

        if (buy == 1) {
            int bought = -prices[i] + findMaxProfitMemo(i + 1, n, prices, 0,dp);
            int notBought = findMaxProfitMemo(i + 1, n, prices, 1,dp);
            dp[i][buy] = Math.max(bought, notBought);
        } else {
            int sell = prices[i] + findMaxProfitMemo(i + 1, n, prices, 1,dp);
            int notSell = findMaxProfitMemo(i + 1, n, prices, 0,dp);
            dp[i][buy] = Math.max(sell, notSell);
        }

        return dp[i][buy];
    }

    private static int findMaxProfitRec(int i, int n, int[] prices, int buy) {

        if (i == n) {
            return 0;
        }

        int profit = 0;

        if (buy == 1) {
            int bought = -prices[i] + findMaxProfitRec(i + 1, n, prices, 0);
            int notBought = findMaxProfitRec(i + 1, n, prices, 1);
            profit = Math.max(bought, notBought);
        } else {
            int sell = prices[i] + findMaxProfitRec(i + 1, n, prices, 1);
            int notSell = findMaxProfitRec(i + 1, n, prices, 0);
            profit = Math.max(sell, notSell);
        }

        return profit;

    }


}
