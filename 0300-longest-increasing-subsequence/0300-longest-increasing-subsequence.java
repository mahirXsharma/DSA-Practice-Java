class Solution {
    public int lengthOfLIS(int[] nums) {
        int ans = 0, n = nums.length;
        if(n ==1) return 1;

        int dp[][] = new int[n][n];
        for(int row[] : dp) Arrays.fill(row, -1);

        for(int i=0; i<n; i++){
            int curr = dfs(nums, i, i, dp);
            ans = Math.max(ans, curr);
        }
        return ans;
    }

    public int dfs(int nums[], int idx, int prevIdx, int dp[][]){
        if(idx == nums.length) return 1; 
        if(dp[idx][prevIdx] != -1) return dp[idx][prevIdx];
        int val = nums[idx];
        int ans = 0;
        if(val >  nums[prevIdx]){
            // take or leave
            int take = dfs(nums, idx+1, idx, dp) +1;
            int leave = dfs(nums, idx+1, prevIdx, dp);
            ans = Math.max(take, leave);
        }
        ans = Math.max(ans, dfs(nums, idx+1, prevIdx, dp));
        
        return dp[idx][prevIdx] = ans;
    }
}