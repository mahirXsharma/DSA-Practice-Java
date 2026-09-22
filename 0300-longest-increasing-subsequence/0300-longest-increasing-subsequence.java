class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n+1];
        for(int row[] : dp) Arrays.fill(row, -1);
        return dfs(nums, 0, -1, dp);
    }

    public int dfs(int nums[], int idx, int pidx, int dp[][]){
        if(idx == nums.length) return 0;
        if(dp[idx][pidx+1] != -1) return dp[idx][pidx+1];

        int leave = dfs(nums, idx+1, pidx, dp);
        int take = 0;
        if(pidx == -1 || nums[idx] > nums[pidx]){
            take = dfs(nums, idx+1, idx, dp) + 1;
        }
        return dp[idx][pidx+1] = Math.max(take, leave);
    }
}