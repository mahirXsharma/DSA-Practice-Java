class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+2][2];
        // for(int row[] : dp) Arrays.fill(row, -1);
        // return dfs(0, prices, 0, n, dp);

        // TABULATION
        
        for(int i=n-1; i>=0; i--){
            for(int isHolding = 0; isHolding <2; isHolding++){
                int ans = Integer.MIN_VALUE;
                if(isHolding == 1){
                    // sell or skip
                    int sell = dp[i+2][0] + prices[i];
                    int keep = dp[i+1][1];
                    ans = Math.max(sell, keep);
                }
                else{
                    int buy = dp[i+1][1] - prices[i];
                    int skip = dp[i+1][0];
                    ans = Math.max(ans, Math.max(buy, skip));
                }   
                dp[i][isHolding] = ans;
            }
        }

        return dp[0][0];

    }

    // public int dfs(int i, int prices[], int isHolding, int n, int dp[][]){
    //     if(i >= prices.length ) return 0;
    //     if(dp[i][isHolding] != -1) return dp[i][isHolding];

    //     int ans = Integer.MIN_VALUE;
    //     if(isHolding == 1){
    //         // sell or skip
    //         int sell = dfs(i+2, prices, 0, n, dp) + prices[i];
    //         int keep = dfs(i+1, prices, 1, n, dp);
    //         ans = Math.max(sell, keep);
    //     }
    //     else{
    //         int buy = dfs(i+1, prices, 1, n, dp) - prices[i];
    //         int skip = dfs(i+1, prices, 0, n, dp);
    //         ans = Math.max(ans, Math.max(buy, skip));
    //     }   
    //     return dp[i][isHolding] = ans;

    // }
}