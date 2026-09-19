class Solution {
    public int maxProfit(int[] prices) {
        Integer[][][] dp = new Integer[2][3][prices.length];
        return dfs(prices, 0, 0, 0, prices.length, dp);
    }

    public int dfs(int prices[], int isHolding, int tc, int idx, int n, Integer dp[][][]){
        if(tc == 2 || idx == n) return 0;
        if(dp[isHolding][tc][idx] != null) return dp[isHolding][tc][idx];
        int skip = 0;
        int trans = 0;
        if(isHolding == 1){
            skip = dfs(prices, 1, tc, idx+1, n, dp);
            trans = prices[idx] + dfs(prices, 0, tc + 1, idx + 1, n, dp);
        }
        else{
            skip = dfs(prices, 0, tc, idx+1, n, dp);
            trans = -prices[idx] + dfs(prices, 1, tc, idx+1, n, dp);
        }
        return  dp[isHolding][tc][idx] = Math.max(skip, trans);
    }
}