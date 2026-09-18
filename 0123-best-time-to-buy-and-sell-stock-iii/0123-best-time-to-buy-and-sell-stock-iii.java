class Solution {
    public int maxProfit(int[] prices) {

        Integer[][][] dp = new Integer[prices.length][3][2];
        
        return dfs(prices, 0, 0, 0, dp);
    }

    private int dfs(int[] prices, int idx, int tc, int isHolding, Integer[][][] dp) {
        if (idx == prices.length || tc == 2) {
            return 0; 
        }

        if (dp[idx][tc][isHolding] != null) {
            return dp[idx][tc][isHolding];
        }

        int skip = 0;
        int transact = 0;

        if (isHolding == 1) { 
            
            skip = dfs(prices, idx + 1, tc, 1, dp);
 
            transact = prices[idx] + dfs(prices, idx + 1, tc + 1, 0, dp);
            
        } else { 

            skip = dfs(prices, idx + 1, tc, 0, dp);
            
            transact = -prices[idx] + dfs(prices, idx + 1, tc, 1, dp);
        }

        return dp[idx][tc][isHolding] = Math.max(skip, transact);
    }
}