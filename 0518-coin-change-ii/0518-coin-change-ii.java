class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        // for(int row[] : dp) Arrays.fill(row, -1);
        // return dfs(coins, amount, 0, dp);
        for(int i=0; i<n; i++) dp[i][0] = 1;
        // the first coin can be used multiple TIMESSSS
        for (int j = 1; j <= amount; j++) {
            if (j % coins[0] == 0) {
                dp[0][j] = 1; // Can we make amount j using only coins[0]?
            }
        }
        // TABULATION
        for(int i=1; i<n; i++){
            for(int j=1; j<=amount; j++){
                int leave = dp[i-1][j];
                int stay = 0;
                if(j >= coins[i]){
                    stay = dp[i][j-coins[i]];
                }
                dp[i][j] = leave + stay;
            }
        }
        return dp[n-1][amount];


    }
    public int dfs(int coins[], int tar, int idx, int dp[][]){
        if(tar == 0) return 1;
        if(tar < 0 || idx == coins.length) return 0;
        if(dp[idx][tar] != -1) return dp[idx][tar];
        int count = 0;
            int stay = dfs(coins, tar-coins[idx], idx, dp);
            int leave = dfs(coins, tar, idx+1, dp);
            int ans = stay + leave;
            count += ans;

        return dp[idx][tar] = count;

    }
}