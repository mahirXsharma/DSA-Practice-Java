class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int profit = 0;
        for(int num : prices){
            if(num < buy) buy = num;
            if(num > buy){
                int currProfit = num - buy;
                profit = Math.max(profit, currProfit);
            }
        }
        return profit;
    }
}