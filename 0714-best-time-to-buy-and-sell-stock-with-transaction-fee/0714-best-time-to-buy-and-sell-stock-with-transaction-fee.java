class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp[][] = new int[n+1][2];
        // for(int row[] : dp) Arrays.fill(row, -1);
        // return dfs(prices, fee, 0, 0, dp);

        // TABULATION
        for(int i=n-1; i>=0; i--){
            for(int k=0; k<=1; k++){
                int ans = 0;
                if(k == 0){
                    int buy = -prices[i] + dp[i+1][1];
                    int leave = dp[i+1][0];
                     ans = Math.max(buy, leave);
                }
                else{
                    int sell = prices[i] - fee + dp[i+1][0];
                    int hold = dp[i+1][1];
                    ans = Math.max(ans, Math.max(sell, hold));
                }
                dp[i][k] = ans;
            }
        }
        return dp[0][0];

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