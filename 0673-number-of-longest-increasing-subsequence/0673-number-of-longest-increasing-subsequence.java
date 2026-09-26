class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, maxLength = 1;
        int dp[] = new int[n];
        int count[] = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                int val = dp[j] + 1;
                if(nums[j] < nums[i]){
                    if(val > dp[i]){
                        dp[i] = dp[j] + 1;
                        // borrow the count from the previous one
                        count[i] = count[j];
                    }
                    else if(val == dp[i]) count[i] += count[j];
                }
            }
            if(dp[i] > maxLength){
                maxLength = dp[i];
            }
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            if(dp[i] == maxLength){
                ans += count[i];
            }
        }       
        return ans;


    }
}