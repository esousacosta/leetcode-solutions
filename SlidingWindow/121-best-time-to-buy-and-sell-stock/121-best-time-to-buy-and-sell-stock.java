class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1)
            return 0;

        int maxP = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxP = Math.max(maxP, price - minPrice);
            }
        }

        return maxP;
    }
}