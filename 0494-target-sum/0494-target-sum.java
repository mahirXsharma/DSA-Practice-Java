class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int ts = 0, n = nums.length;
        for(int num : nums) ts +=  num;
        if((ts+target) %2 != 0 || Math.abs(target) > ts) return 0;
        int tar = (ts + target)/ 2;
        int dp[][] = new int[n][ts + 1];
        for(int row[] : dp) Arrays.fill(row, -1);
        return dfs(nums, tar, 0, 0, dp);
    }

    public int dfs(int nums[], int tar, int idx, int cs, int dp[][]){
        if(idx == nums.length) return cs == tar ? 1 : 0;
        if(dp[idx][cs] != -1) return dp[idx][cs];
        int leave = dfs(nums, tar, idx+1, cs, dp);
        int take = dfs(nums, tar, idx+1, cs + nums[idx], dp);
        return dp[idx][cs] = leave + take;
    }
}