class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount < 0) return -1;
        int dp[] = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        // return dfs(coins, amount, dp);
        // TABULATION 
        dp[0] = 0;
        for(int i=1; i<=amount; i++){
            for(int coin : coins){
                int curr = i - coin;
                if(curr >= 0){
                    dp[i] = Math.min(dp[i], dp[curr] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];



        // this shit will fail, coz of [1, 3, 4] & amount = 6
        // greedy ans -> 4+1+1
        // but the actual ans -> 3 + 3
        // hence we gotta use dp over here

        // Arrays.sort(coins);
        // int ans = 0;
        // for(int i=coins.length-1; i>=0; i--){
        //     while(amount >= coins[i]){
        //         // reduce the amount
        //         amount -= coins[i];
        //         ans++;
        //     }
        // }
        // if(amount !=0){
        //     return -1;
        // }
        // return ans;
    }

    public int dfs(int coins[], int amount, int dp[]){
        if(amount == 0) return 0;
        if(amount <0) return -1;
        if(dp[amount] != -2) return dp[amount];
        int minCount = Integer.MAX_VALUE;
        for(int coin : coins){
            int res = dfs(coins, amount - coin, dp);
            if(res >=0 && res < minCount){
                minCount = res + 1;
            }
        }
         return dp[amount] = minCount == Integer.MAX_VALUE ? -1 : minCount;

    }
}