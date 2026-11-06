class Solution {
    public int maxProfit(int[] prices) {
        int minLeft = prices[0];
        int maxProfit = 0;
        for(int right = 0;right<prices.length;right++){
            maxProfit = Math.max(maxProfit,prices[right] - minLeft);
            minLeft = Math.min(minLeft,prices[right]);
        }

        return maxProfit;
    }
}
