class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int ts = 0, n = nums.length;
        for (int num : nums)
            ts += num;
        // 1. Math Guards: The Odd-ball trap and the Impossible Target trap
        if ((ts + target) % 2 != 0 || Math.abs(target) > ts)
            return 0;

        // 2. The Algebra Trick: Find the exact size of Pile A
        int tar = (ts + target) / 2;

        // 3. Create the 2D DP Array
        int[][] dp = new int[n][tar + 1];

        // --- DAY 0: BASE CASES ---
        // Trap Check: If the first number is 0, there are 2 ways to make sum 0 (Take or Leave)
        if (nums[0] == 0) {
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1; // Otherwise, just 1 way to make sum 0 (Leave)
        }

        // If the first number isn't 0 and actually fits in our target, there is 1 way to make it (Take)
        if (nums[0] != 0 && nums[0] <= tar) {
            dp[0][nums[0]] = 1;
        }

        // --- DAY 1 ONWARDS: THE NESTED LOOPS ---
        for (int i = 1; i < n; i++) {
            // Notice j starts at 0 to catch those zero-sums!
            for (int j = 0; j <= tar; j++) {

                // Option 1: Leave the current number
                int leave = dp[i - 1][j];

                // Option 2: Take the current number (only if it fits inside j)
                int take = 0;
                if (nums[i] <= j) {
                    take = dp[i - 1][j - nums[i]];
                }

                // Add the timelines together
                dp[i][j] = leave + take;
            }
        }

        // 4. Return the bottom-right corner of our relevant grid
        return dp[n - 1][tar];
    }

    // public int dfs(int nums[], int tar, int idx, int cs, int dp[][]){
    //     if(idx == nums.length) return cs == tar ? 1 : 0;
    //     if(dp[idx][cs] != -1) return dp[idx][cs];
    //     int leave = dfs(nums, tar, idx+1, cs, dp);
    //     int take = dfs(nums, tar, idx+1, cs + nums[idx], dp);
    //     return dp[idx][cs] = leave + take;
    // }
}