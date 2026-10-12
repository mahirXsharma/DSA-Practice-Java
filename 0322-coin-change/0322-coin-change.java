class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int row[] : dp) Arrays.fill(row, -1);
        int ans = dfs(0, amount, coins, dp);
        return ans == 1e9 ? -1 : ans;
    }

    public int dfs(int i, int rem, int coins[], int dp[][]){
        if(rem == 0) return 0;
        if(i >= coins.length) return (int)1e9;
        if(dp[i][rem] != -1) return dp[i][rem];

        int take = Integer.MAX_VALUE;
        if(rem >= coins[i]){
            take = dfs(i, rem-coins[i], coins, dp) + 1;
        }
        int leave = dfs(i+1, rem, coins, dp);
        return dp[i][rem] = Math.min(take, leave);
    }
}