class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int ts = 0;
        for(int num : nums) ts+= num;
        // 1. THE ODD TRAP: Instantly kill impossible targets
        if (ts % 2 != 0) return false;
        Boolean dp[][] = new Boolean[ts+1][n];

        return dfs(nums, ts, 0, 0, dp);
    }
    public boolean dfs(int nums[], int ts, int curr, int idx, Boolean dp[][]){
        if(ts - curr == curr) return true;
        if(curr >= ts || idx >= nums.length) return false;
        if(dp[curr][idx] != null) return dp[curr][idx];
        boolean take = dfs(nums, ts, curr + nums[idx], idx+1, dp);
        boolean leave = dfs(nums, ts, curr, idx+1, dp);
        return dp[curr][idx] = take || leave;
    }
}