class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[2][k+1][n+1];
        // for(int matrix[][] : dp){
        //     for(int row[] : matrix){
        //         Arrays.fill(row, -1);
        //     }
        // }
        // return dfs(prices, 0, 0, 0, k, n, dp);
        for(int idx = n-1; idx>=0; idx--){
            for(int tc = 0; tc<k; tc++){
                for(int isH = 0; isH<=1; isH++){
                    int skip = 0;
                    int trans = 0;
                    if(isH == 0){
                        skip = dp[0][tc][idx + 1];
                        trans = -prices[idx] + dp[1][tc][idx+1];
                    }
                    else{
                        skip = dp[1][tc][idx+1];
                        trans = prices[idx] + dp[0][tc+1][idx+1];
                    }
                    dp[isH][tc][idx] = Math.max(skip, trans);
                }
            }
        }
        return dp[0][0][0];
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