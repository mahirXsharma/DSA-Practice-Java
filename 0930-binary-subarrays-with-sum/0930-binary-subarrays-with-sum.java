class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return countAtmost(nums, goal) - countAtmost(nums, goal-1); 
    }

    public int countAtmost(int nums[], int goal){
        if(goal < 0) return 0;
        int l = 0, r = 0, n = nums.length, ans = 0, sum = 0;
        while(r < n){
            sum += nums[r];
            while(sum > goal){
                sum -= nums[l];
                l++;
            }
            ans += r-l+1;
            r++;
        }
        return ans;
    }
}