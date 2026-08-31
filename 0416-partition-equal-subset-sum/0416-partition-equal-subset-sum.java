class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int ts = 0;
        for(int num : nums) ts+= num;
        if (ts % 2 != 0) return false;
        int target = ts/2;
        boolean[][] dp = new boolean[n][target + 1];
        // TABULATION
        // first fill the firt col, as its possible for every row to have a sum of 0
        for(int i=0; i<n; i++)dp[i][0] = true;
        if(nums[0] <= target) dp[0][nums[0]] = true;

        for(int i=1; i<n; i++){
            for(int j=1; j<=target; j++){
                // in the case of leave, just copy from above
                boolean leave = dp[i-1][j];
                // lets assume by 'take', we didn't reached our ans
                boolean take = false;
                // check if target-nums[j] exist in the arr
                if(nums[i] <= j){
                    take = dp[i-1][j-nums[i]];
                }
                dp[i][j] = take || leave;
            }
        }
        return dp[n-1][target];

        // return dfs(nums, target, 0, 0, dp);
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