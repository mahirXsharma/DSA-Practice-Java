class Solution {
    public int lastStoneWeightII(int[] stones) {
        int ts = 0, n = stones.length;
        for(int stone : stones) ts +=stone;
        int target = ts/2;
        boolean dp[] = new boolean[target+1];
        // filling the base case of col 1
            dp[0] = true;
        // filling the base case for row zero
        if(stones[0] <= target){
            dp[stones[0]]= true;
        }
        for(int i=1; i<n; i++){
            for(int j=target; j>=stones[i]; j--){
                boolean leave = dp[j];
                boolean take = dp[j - stones[i]];
                dp[j] = leave || take;
            }
        }
        int maxSumOfPileA = 0;
        for(int i=target; i>=0; i--){
            if(dp[i]) {
                maxSumOfPileA = i;
                break;
            }
        }
        return ts-2*maxSumOfPileA;
    }
}