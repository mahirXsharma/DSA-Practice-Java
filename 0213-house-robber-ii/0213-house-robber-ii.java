class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        return Math.max(robHelper(nums, 0, n-2), robHelper(nums, 1, n-1));
        
    }
    private int robHelper(int[] nums, int start, int end) {
        int first = 0;
        int sec = 0;
        
        for (int i = start; i <= end; i++) {
            int loot = nums[i] + first;
            int skip = sec;
            
            int ans = Math.max(loot, skip);
            first = sec;
            sec = ans;
        }
        
        return sec;
    }
}