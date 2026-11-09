class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int freq[] = new int[n];
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += nums[i];
            freq[i] = sum;
        }
        
        int ans = 0;
        sum = 0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int curr = freq[j];
                if(curr - sum == k) ans++;
            }
            sum += nums[i];
        }

        return ans;
    }
}