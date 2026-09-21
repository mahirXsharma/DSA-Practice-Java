class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        // int dp[][] = new int[n+1][2];
        int aheadNo = 0, aheadYes = 0; 
        // for(int row[] : dp) Arrays.fill(row, -1);
        // return dfs(prices, fee, 0, 0, dp);

        // TABULATION
        for (int i = n - 1; i >= 0; i--) {
            // State 1: We currently don't hold a stock. 
            // Options: Do nothing (aheadNo) OR Buy today (-prices[i] + aheadYes)
            int currNo = Math.max(aheadNo, -prices[i] + aheadYes);
            
            // State 2: We currently hold a stock.
            // Options: Do nothing (aheadYes) OR Sell today (prices[i] - fee + aheadNo)
            int currYes = Math.max(aheadYes, prices[i] - fee + aheadNo);
            
            // Move our pointers back one day for the next loop iteration
            aheadNo = currNo;
            aheadYes = currYes;
        }
        
        // We start on day 0 not holding any stock, so this holds our maximum possible profit
        return aheadNo;
    }

    // public int dfs(int prices[], int fee, int idx, int isHolding, int dp[][]){
    //     if(idx == prices.length) return 0;
    //     if(dp[idx][isHolding] != -1) return dp[idx][isHolding];
    //     int ans = 0;
    //     if(isHolding == 0){
    //         // we are not holding a stock right now
    //         int buy = -prices[idx] + dfs(prices, fee, idx+1, 1, dp);
    //         int leave = dfs(prices, fee, idx+1, 0, dp);
    //         ans = Math.max(buy, leave);
    //     }
    //     else{
    //         int sell = prices[idx] - fee + dfs(prices, fee, idx+1, 0, dp);
    //         int hold = dfs(prices, fee, idx+1, 1, dp);
    //         ans = Math.max(ans, Math.max(sell, hold));
    //     }
    //     return dp[idx][isHolding] = ans;
    // }
}