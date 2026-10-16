class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int si = 0, ei = n-1;
        int left = -1, right = -1;
        
        // left
        while(si <= ei){
            int mid = (si + (ei-si)/2);
            if(nums[mid] >= target){
                if(nums[mid] == target) left =mid;
                ei = mid-1;
            }
            else si = mid+1;
        }
        // right
        si = 0;
        ei = n-1;
        while(si <= ei){
            int mid = (si + (ei - si)/2);
            if(nums[mid] <= target){
                if(nums[mid] == target) right = mid;
                si = mid+1;
            }
            else ei = mid-1;
        }
        
       return new int[]{left, right};
    }
}