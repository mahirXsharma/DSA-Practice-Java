class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int ts = 0;
        for(int num : nums) ts+= num;
        if (ts % 2 != 0) return false;
        int target = ts/2;
        Boolean dp[][] = new Boolean[target+1][n];

        return dfs(nums, target, 0, 0, dp);
    }
    public boolean dfs(int nums[], int target, int curr, int idx, Boolean dp[][]){
        if(curr == target) return true;
        if(curr > target || idx >= nums.length) return false;
        if(dp[curr][idx] != null) return dp[curr][idx];
        // If 'take' is true, it completely skips calculating 'leave'!
        boolean ans = dfs(nums, target, curr + nums[idx], idx+1, dp) || 
                    dfs(nums, target, curr, idx+1, dp);

        return dp[curr][idx] = ans;
    }
}