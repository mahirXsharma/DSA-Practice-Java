class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int n = nums.length;
        return dfs(nums, target, 0, 0);
    }

    public int dfs(int nums[], int tar, int cs, int idx){
        if(idx == nums.length){
            return cs == tar? 1 : 0;
        }
        int takeminus = dfs(nums, tar, cs -nums[idx], idx + 1);
        int takeplus = dfs(nums, tar, cs + nums[idx], idx + 1);
        int ans = takeminus + takeplus;
        return ans ;
    }
}