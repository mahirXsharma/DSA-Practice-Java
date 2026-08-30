class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int ts = 0;
        for(int num : nums) ts += num;
        
        if (ts % 2 != 0) return false;
        
        int target = ts / 2;
        int dp[][] = new int[target + 1][n];
        for(int row[] : dp) Arrays.fill(row, -1);
        
        return dfs(nums, target, 0, 0, dp);
    }
    
    public boolean dfs(int nums[], int target, int curr, int idx, int dp[][]){
        if (curr == target) return true;
        if (curr > target || idx >= nums.length) return false;
        
        // Translate: If it's 1, return true. If it's 0, return false.
        if (dp[curr][idx] != -1) return dp[curr][idx] == 1;
        
        // Short-circuited recursion
        boolean ans = dfs(nums, target, curr + nums[idx], idx + 1, dp) || 
                      dfs(nums, target, curr, idx + 1, dp);
        
        // Translate: Save true as 1, false as 0
        dp[curr][idx] = ans ? 1 : 0;
        return ans;
    }
}