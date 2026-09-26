import java.util.Arrays;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        
        int maxLength = 1; // Track the global maximum length found anywhere
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    int val = dp[j] + 1;
                    
                    if (val > dp[i]) {
                        dp[i] = val;
                        count[i] = count[j]; // Scenario 1: New high score, inherit paths
                    } else if (val == dp[i]) {
                        count[i] += count[j]; // Scenario 2: Tie score, add new paths
                    }
                }
            }
            // Update the global maximum length after checking all previous elements for index i
            maxLength = Math.max(maxLength, dp[i]);
        }
        
        int totalNumberOfLIS = 0;
        // Final pass: Sum up the counts of every index that achieved the global maximum length
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLength) {
                totalNumberOfLIS += count[i];
            }
        }
        
        return totalNumberOfLIS;
    }
}