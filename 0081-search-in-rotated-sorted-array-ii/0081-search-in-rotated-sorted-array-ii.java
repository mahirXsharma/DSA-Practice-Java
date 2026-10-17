class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int si = 0, ei = n - 1;
        while (si <= ei) {
            int mid = (si + (ei - si) / 2);
            if (nums[mid] == target)
                return true;
            if (nums[si] == nums[mid] && nums[mid] == nums[ei]) {
                si = si + 1;
                ei = ei - 1;
                continue;
            } else if (nums[si] <= nums[mid]) {
                if (nums[si] <= target && target <= nums[mid]) {
                    ei = mid - 1;
                } else
                    si = mid + 1;
            } else {
                if (nums[mid] <= target && nums[ei] >= target) {
                    si = mid + 1;
                } else
                    ei = mid - 1;
            }
        }
        return false;
    }
}