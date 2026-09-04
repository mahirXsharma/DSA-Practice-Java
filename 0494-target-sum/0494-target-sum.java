class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int ts = 0;
        for(int num : nums) ts +=  num;
        if((ts+target) %2 != 0 || Math.abs(target) > ts) return 0;
        int tar = (ts + target)/ 2;
        return dfs(nums, tar, 0, 0);
    }

    public int dfs(int nums[], int tar, int idx, int cs){
        if(idx == nums.length) return cs == tar ? 1 : 0;
        int leave = dfs(nums, tar, idx+1, cs );
        int take = dfs(nums, tar, idx+1, cs + nums[idx]);
        return leave + take;
    }
}