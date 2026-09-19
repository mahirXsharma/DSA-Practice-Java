class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[2][3][n+1];
        // for (int[][] matrix : dp) {
        //     for (int[] row : matrix) {
        //         Arrays.fill(row, -1);
        //     }
        // }
        // return dfs(prices, 0, 0, 0, n, dp);

        // TABULATION

        for(int i=n-1; i>=0; i--){
            for(int j=0; j<=1; j++){
                for(int tc=0; tc <= 1; tc++){
                    int skip = 0;
                    int trans = 0;
                    if(j == 1){
                        skip = dp[1][tc][i+1];
                        trans = prices[i] + dp[0][tc+1][i+1];
                    }
                    else{
                        skip = dp[0][tc][i+1];
                        trans = -prices[i] + dp[1][tc][i+1];
                    }
                    dp[j][tc][i] = Math.max(skip, trans);
                }
            }
        }
        return dp[0][0][0];
    }

    // public int dfs(int prices[], int isHolding, int tc, int idx, int n, int dp[][][]){
    //     if(tc == 2 || idx == n) return 0;
    //     if(dp[isHolding][tc][idx] != -1) return dp[isHolding][tc][idx];
    //     int skip = 0;
    //     int trans = 0;
    //     if(isHolding == 1){
    //         skip = dfs(prices, 1, tc, idx+1, n, dp);
    //         trans = prices[idx] + dfs(prices, 0, tc + 1, idx + 1, n, dp);
    //     }
    //     else{
    //         skip = dfs(prices, 0, tc, idx+1, n, dp);
    //         trans = -prices[idx] + dfs(prices, 1, tc, idx+1, n, dp);
    //     }
    //     return  dp[isHolding][tc][idx] = Math.max(skip, trans);
    // }
}