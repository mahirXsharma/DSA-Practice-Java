class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int si = 0, ei = n - 1;
        while (si <= ei) {
            // check mid
            int mid = (si + (ei - si) / 2);

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                ei = mid - 1;
            else
                si = mid + 1;
        }
        return -1;
    }
}