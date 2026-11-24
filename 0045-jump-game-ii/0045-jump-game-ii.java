class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        dp[n-1] = 0;
        int ans = dfs(nums, 0, n, dp);

        return ans == (int)1e9 ? -1 : ans;
    }

    public int dfs(int nums[], int idx, int n, int dp[]){
        if(idx == n-1) return 0;
        if(idx > n-1 || nums[idx] == 0) return (int)1e9;
        if(dp[idx] != -1) return dp[idx];

        int k = (int)1e9, curr = nums[idx];
        int fakeIdx = idx;
        for(int i=0; i<curr; i++){
            fakeIdx += 1;
            k = Math.min(k, dfs(nums, fakeIdx, n, dp) + 1);
        }
        return dp[idx] = k;
    }
}