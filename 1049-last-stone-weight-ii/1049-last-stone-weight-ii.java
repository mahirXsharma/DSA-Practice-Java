class Solution {
    public int lastStoneWeightII(int[] stones) {
        int ts = 0, n = stones.length;
        for(int stone : stones) ts +=stone;
        int target = ts/2;
        boolean dp[][] = new boolean[n][target+1];
        // filling the base case of col 1
        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }
        // filling the base case for row zero
        if(stones[0] <= target){
            dp[0][stones[0]]= true;
        }
        for(int i=1; i<n; i++){
            for(int j=1; j<=target; j++){
                boolean leave = dp[i-1][j];
                boolean take = false;
                if(stones[i]<= j){
                    take = dp[i-1][j-stones[i]];
                }
                dp[i][j] = leave || take;
            }
        }
        int maxSumOfPileA = 0;
        for(int i=target; i>=0; i--){
            if(dp[n-1][i]) {
                maxSumOfPileA = i;
                break;
            }
        }
        return ts-2*maxSumOfPileA;
    }
}