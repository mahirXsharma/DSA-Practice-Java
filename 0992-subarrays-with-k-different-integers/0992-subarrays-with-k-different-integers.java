class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        return Atmost(nums, k, n) - Atmost(nums, k-1, n);
    }

    public int Atmost(int nums[], int k, int n){
        if(k < 0) return 0;
        int l = 0, r = 0, ans = 0, d = 0;
        int[] freq = new int[n + 1];

        while(r < n){
            int curr = nums[r];
            if(freq[curr] == 0 ) d++;
            freq[curr] ++;
            while(d > k){
                int al = nums[l++];
                freq[al]--;
                if(freq[al] == 0) d--;
            }
            int winSize = r - l + 1;
            ans += winSize;
            r++;
        }
        return ans;
    }
}