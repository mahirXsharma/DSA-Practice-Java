class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[] = new int[amount+1];
        // for(int row[] : dp) Arrays.fill(row, -1);
        // return dfs(0, amount, coins, dp);
        dp[0] = 1;
        // TABULATION

        for(int i=n-1; i>=0; i--){
            for(int rem = 0; rem<=amount; rem++){
                int take = 0;
                if(rem >= coins[i]){
                    take = dp[rem-coins[i]];
                }
                int leave = dp[rem];
                dp[rem] = take + leave;
            }
        }
        return dp[amount];
    }

    // public int dfs(int i, int rem, int coins[], int dp[][]){
    //     if(rem == 0) return 1;
    //     if(i >= coins.length) return 0;
    //     if(dp[i][rem] != -1) return dp[i][rem];

    //     int take = 0;
    //     if(rem >= coins[i]){
    //         take = dfs(i, rem-coins[i], coins, dp);
    //     }
    //     int leave = dfs(i+1, rem, coins, dp);
    //     return dp[i][rem] = take + leave;
    // }
}