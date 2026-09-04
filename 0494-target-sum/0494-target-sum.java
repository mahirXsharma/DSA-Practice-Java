class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int n = nums.length;
        int ts = 0;
        for(int num : nums) ts += num;
        int dp[][] = new int[n][2*ts + 1];
        for(int row[] : dp) Arrays.fill(row, -1);
        return dfs(nums, target, 0, 0, dp, ts);
    }

    public int dfs(int nums[], int tar, int cs, int idx, int dp[][], int ts){
        if(idx == nums.length){
            return cs == tar? 1 : 0;
        }
        if(dp[idx][cs+ts] != -1) return dp[idx][cs + ts];
        int takeminus = dfs(nums, tar, cs -nums[idx], idx + 1, dp, ts);
        int takeplus = dfs(nums, tar, cs + nums[idx], idx + 1, dp, ts);
        int ans = takeminus + takeplus;
        return dp[idx][cs + ts] = ans ;
    }
}