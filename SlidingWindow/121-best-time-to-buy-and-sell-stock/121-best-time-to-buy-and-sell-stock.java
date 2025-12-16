class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return -1;
        }

        int b = 0;
        // int bestBuy = -1;
        // int bestSell = -1;
        int maxP = 0;

        for (int s = 1; s < prices.length; s++) {
            if (prices[s] > prices[b]) {
                while (b < s) {
                    int profit = prices[s] - prices[b];
                    if (profit > maxP) {
                        maxP = profit;
                        // bestBuy = b;
                    }
                    b++;
                }
            }
        }

        int s = prices.length - 1;
        for (b = s - 1; b >= 0; b--) {
            if (prices[s] > prices[b]) {
                while (b < s) {
                    int profit = prices[s] - prices[b];
                    if (profit > maxP) {
                        maxP = profit;
                        // bestBuy = b;
                    }
                    s--;
                }
            }
        }

        return maxP;
    }
}