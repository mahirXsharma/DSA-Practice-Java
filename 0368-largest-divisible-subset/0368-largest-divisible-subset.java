class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n= nums.length;
        int dp[] = new int[n];
        int prev[] = new int[n];
        for(int i=0; i<n; i++){
            prev[i] = i;
        }
        int max = 0, idx = -1;
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=1; i<n; i++){
            int curr = nums[i];
            for(int j=0; j<i; j++){
                int alt = nums[j];
                if( curr%alt == 0){
                    if(dp[j] + 1 > dp[i]){
                    dp[i] =  dp[j]+1;
                    prev[i] = j;
                    }
                    
                }
            }
            if(dp[i] > max){
                max = dp[i];
                idx = i;
            }
        }
        if(idx == -1) {
            ans.add(nums[0]);
            return ans;
        }

        while(prev[idx] != idx){
            ans.add(nums[idx]);
            idx = prev[idx];
        }
        ans.add(nums[idx]);
        
        return ans;

    }
}