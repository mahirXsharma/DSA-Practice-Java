class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        for(int i=0; i<n; i++) nums[i] = nums[i]%2;

        return Atmost(nums, k, n) - Atmost(nums, k-1, n);
    }

    public int Atmost(int nums[], int k, int n){
        if(k < 0) return 0;
        int l = 0, r = 0, ans = 0, sum = 0;
        while(r < n){
            int curr = nums[r];
            sum += curr;
            while(sum > k){
                sum -= nums[l++];
            }
            int winSize = r-l+1;
            ans += winSize;
            r++;
        }
        return ans;
    }
}