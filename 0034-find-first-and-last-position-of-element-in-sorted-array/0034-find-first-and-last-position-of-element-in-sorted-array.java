class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int left = findBound(nums, target, true);
        int right = findBound(nums, target, false);
        return new int[]{left, right};
    }

    private int findBound(int[] nums, int target, boolean searchLeft) {
        int si = 0, ei = nums.length - 1;
        int ans = -1;
        
        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            
            if (nums[mid] == target) {
                ans = mid; 
                if (searchLeft) {
                    ei = mid - 1; 
                } else {
                    si = mid + 1; 
                }
            } else if (nums[mid] < target) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
        return ans;
    }
}