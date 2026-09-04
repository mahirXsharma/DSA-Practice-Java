class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int row[] : dp) Arrays.fill(row, -1);
        return dfs(coins, amount, 0, dp);
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