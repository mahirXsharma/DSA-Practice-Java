class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate elements for our fixed outer pointer 'i'
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Step 2: Set up the Two Pointers on the remaining elements
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // We found a valid triplet!
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move both pointers inward
                    left++;
                    right--;

                    // Skip duplicates for 'left' AND ensure it stays in bounds
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // Skip duplicates for 'right' AND ensure it stays in bounds
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    // The sum is too small, we need a bigger number
                    left++;
                } else {
                    // The sum is too big, we need a smaller number
                    right--;
                }
            }
        }
        return ans;
    }
}