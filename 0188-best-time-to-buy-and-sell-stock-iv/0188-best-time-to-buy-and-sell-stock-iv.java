class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[3][k][n];
        for(int matrix[][] : dp){
            for(int row[] : matrix){
                Arrays.fill(row, -1);
            }
        }
        return dfs(prices, 0, 0, 0, k, n, dp);
    }
    
    public int dfs(int prices[], int isHolding, int tc, int idx, int k, int n, int[][][] dp){
        if(tc == k || idx == n) return 0;
        if(dp[isHolding][tc][idx] != -1) return dp[isHolding][tc][idx];
        int skip = 0;
        int trans = 0;
        if(isHolding == 0){
             skip = dfs(prices, 0, tc, idx+1, k, n, dp);
             trans = -prices[idx] + dfs(prices, 1, tc, idx+1, k, n, dp);
        }
        else{
             skip = dfs(prices, 1, tc, idx+1, k, n, dp);
             trans = prices[idx] + dfs(prices, 0, tc+1, idx+1, k, n, dp);
        }
        return dp[isHolding][tc][idx] = Math.max(skip, trans);
    }
}