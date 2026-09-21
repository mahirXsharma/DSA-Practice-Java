class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n+1];
        for(int row[] : dp) Arrays.fill(row, -1);

        return dfs(nums, 0, -1, dp, n);
    }

    public int dfs(int nums[], int idx, int prevIdx, int dp[][], int n){
        if(idx == n) return 0;
        if(dp[idx][prevIdx+1] != -1) return dp[idx][prevIdx+1];

        int leave = dfs(nums, idx+1, prevIdx, dp, n);
        int take = 0;
        if(prevIdx == -1 || nums[prevIdx] < nums[idx]){
            take = dfs(nums, idx+1, idx, dp, n) + 1;
        }
        return  dp[idx][prevIdx+1] = Math.max(leave, take);
        
    }

}