package org.example.dp.stocks;

public class BuySellStocks {
    public static void main(String[] args){

        int[] prices = {2,4,5,7,3,6};

        /**
         * Make maximum profit. Can buy sell once. Buy first.
         */

        int n = prices.length;
        int minimum = prices[0];
        int profit = 0;

        for(int i=1;i<n;i++){
            int cost = prices[i] - minimum;
            profit = Math.max(profit,cost);
            minimum = Math.min(minimum,prices[i]);
        }

        System.out.println(profit);
    }
}
