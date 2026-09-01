class Solution {
    public int lastStoneWeightII(int[] stones) {


        int ts = 0, n = stones.length;
        for(int stone : stones) ts +=stone;
        int target = ts/2;

        int dp[][] = new int[n][target+1];
        for(int row[] : dp) Arrays.fill(row, -1);
        int maxSum = dfs(0, 0, target, stones, dp);

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

    public int dfs(int idx, int currSum, int target, int stones[], int dp[][]){
        if(currSum > target ) return 0;
        if( idx >= stones.length || currSum == target) return currSum;
        if(dp[idx][currSum] != -1) return dp[idx][currSum];
        int leave = dfs(idx+1, currSum, target, stones, dp);
        int take = dfs(idx+1, currSum + stones[idx], target, stones, dp);
        return dp[idx][currSum] = Math.max(leave, take);


    }
}