class Solution {
    public int rob(int[] nums) {
        // 2 starting points, 0 or 1
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        int dp[] = new int[n];
        // Arrays.fill(dp, -1);
        // return dfs(nums, 0, dp);

        // TABULATION
        // dp[0] = nums[0];
        // dp[1] = Math.max(nums[0], nums[1]);

        // optimizing space
        int first = nums[0];
        int sec = Math.max(nums[0], nums[1]);
        int ans = 0;
        for(int i=2; i<n; i++){
            int loot = nums[i] + first;
            int skip = sec;
            ans = Math.max(loot, skip);
            first = sec;
            sec = ans;
        }
        return sec;
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