class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, ans = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            sum += curr;
            int key = sum - k;
            if (map.containsKey(key)) {
                ans += map.get(key);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;

    }
}