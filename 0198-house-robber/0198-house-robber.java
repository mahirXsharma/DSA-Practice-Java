class Solution {
    public int rob(int[] nums) {
        // 2 starting points, 0 or 1
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return dfs(nums, 0, dp);
    }
    public int dfs(int nums[], int i, int dp[]){
        int n = nums.length;
        if( i >= n) return 0;
        if(dp[i] != -1) return dp[i];
        int s0 = nums[i] + dfs(nums, i+2, dp);
        int s1 = Integer.MIN_VALUE;
        if(i+1 < n){
            s1 = nums[i+1] + dfs(nums, i+3, dp);
        }
        return  dp[i] = Math.max(s0, s1);
    }

}