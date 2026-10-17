class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int si = 0, ei = n-1;
        int ans = Integer.MAX_VALUE;
        while(si <= ei){
            int mid = (si + (ei - si) /2);
            int curr = nums[mid];
            ans = Math.min(ans, curr);
            // if left half is sorted
            if(nums[si] <= nums[mid]){
                ans = Math.min(ans, nums[si]);
                si = mid+1;
            }
            else{
                ei = mid-1;
            }
        }
        return ans;
    }
}