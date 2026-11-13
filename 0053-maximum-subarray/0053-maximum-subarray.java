class Solution {
    public int maxSubArray(int[] nums) {
        // n = 10^5 -> N only
        // what if the question wants us to return that 'subarray' instead of the sum ? 
        // kadan algo
        int sum = 0, ans = Integer.MIN_VALUE;
        for(int num : nums){
            sum += num;
            ans = Math.max(ans, sum);
            if(sum < 0) sum = 0;
        }
        return ans;

    }
}