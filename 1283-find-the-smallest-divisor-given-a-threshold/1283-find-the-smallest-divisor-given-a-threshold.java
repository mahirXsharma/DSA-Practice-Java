class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int num : nums)
            max = Math.max(max, num);

        int si = 1, ei = max;
        int ans = 0;
        while (si <= ei) {
            int mid = (si + (ei - si) / 2);
            int cs = help(nums, mid);
            if (cs > threshold) {
                si = mid + 1;
            } else {
                ei = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    public int help(int nums[], int curr) {
        int ans = 0;
        for (int num : nums) {
            ans += (num + curr - 1) / curr;
        }
        return ans;
    }
}