class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        return Atmost(nums, k, n) - Atmost(nums, k-1, n);
    }

    public int Atmost(int nums[], int k, int n){
        if(k < 0) return 0;
        int l = 0, r = 0, ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(r < n){
            int curr = nums[r];
            map.put( curr, map.getOrDefault(curr, 0) + 1);
            while(map.size() > k){
                int atLeft = nums[l];
                map.put(atLeft, map.get(atLeft)-1);
                if(map.get(atLeft) == 0) map.remove(atLeft);
                l++;
            }
            int winSize = r - l + 1;
            ans += winSize;
            r++;
        }
        return ans;
    }
}