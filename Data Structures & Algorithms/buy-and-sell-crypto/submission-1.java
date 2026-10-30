class Solution {
    public int maxProfit(int[] prices) {
        int min = 101;//outside arr range
        int[] minArr = new int[prices.length];
        for(int i = 0;i<prices.length;i++){
            min = Math.min(min,prices[i]);
            minArr[i] = min;
        }
        int max = -1; //outside range
        int[] maxArr = new int[prices.length];
        for(int i = prices.length-1;i>-1;i--){
            max = Math.max(max,prices[i]);
            maxArr[i] = max;
        }

        int maxProfit = 0;

        for(int j = 0;j<minArr.length;j++){
            maxProfit = Math.max(maxProfit,maxArr[j] - minArr[j]);
        }
        return maxProfit;
    }
}
