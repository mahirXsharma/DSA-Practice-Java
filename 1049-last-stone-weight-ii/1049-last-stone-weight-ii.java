class Solution {
    public int lastStoneWeightII(int[] stones) {


        int ts = 0, n = stones.length;
        for(int stone : stones) ts +=stone;
        int target = ts/2;

        int dp[][] = new int[n][target+1];
        for(int row[] : dp) Arrays.fill(row, -1);
        int maxSum = target - dfs(0, target, stones, dp);

        return ts-(2*maxSum);







        // boolean dp[] = new boolean[target+1];
        // // filling the base case of col 1
        //     dp[0] = true;
        // // filling the base case for row zero
        // if(stones[0] <= target){
        //     dp[stones[0]]= true;
        // }
        // for(int i=1; i<n; i++){
        //     for(int j=target; j>=stones[i]; j--){
        //         boolean leave = dp[j];
        //         boolean take = dp[j - stones[i]];
        //         dp[j] = leave || take;
        //     }
        // }
        // int maxSumOfPileA = 0;
        // for(int i=target; i>=0; i--){
        //     if(dp[i]) {
        //         maxSumOfPileA = i;
        //         break;
        //     }
        // }
        // return ts-2*maxSumOfPileA;
    }

    public int dfs(int i, int rem, int stones[], int dp[][]){
        if(rem == 0 ) return 0;
        if( i >= stones.length) return rem;
        if(dp[i][rem] != -1) return dp[i][rem];
        int leave = dfs(i+1, rem, stones, dp);
        int take = Integer.MAX_VALUE;
        if (stones[i] <= rem) { // Protect against negative remainder
            take = dfs(i + 1, rem - stones[i], stones, dp);
        }
        return dp[i][rem] = Math.min(leave, take);
    }
}