class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];

        int left[] = new int[n];
        int right[] = new int[n];

        int mul = 1;
        for(int i=0; i<n; i++){
            if(i != 0)mul = mul * nums[i-1];
            left[i] = mul;
        }

        mul = 1;
        for(int i=n-1; i>=0; i--){
            if(i != n-1) mul = mul * nums[i+1];
            right[i] = mul;
        }

        for(int i=0; i<n; i++){
            int l = left[i], r = right[i];
            ans[i] = l*r;
        }





        // N2
        // for(int i=0; i<n; i++){
        //     int mul = 1;
        //     for(int j=0; j<n; j++){
        //         if(j == i) continue;
        //         mul = mul*nums[j];
        //     }
        //     ans[i] = mul;
        // }
        return ans;
    }
}