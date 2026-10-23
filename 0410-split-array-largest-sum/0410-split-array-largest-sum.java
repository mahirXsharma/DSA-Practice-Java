class Solution {
    public int splitArray(int[] nums, int k) {
        int max = 0, cs = 0;
        for(int num : nums){
            cs += num;
            if(num > max) max = num;
        }

        int si = max, ei = cs;
        int ans = 0;
        while(si <= ei){
            int mid = (si + (ei -si)/2);
            int patitionsNeeded = help(mid, nums);
            if( patitionsNeeded <= k){
                ans = mid;
                ei = mid-1;
            }
            else si = mid+1;
        }
        return ans;
    }

    public int help(int mid, int nums[]){
        int pN = 1, cs = 0;
        for(int num : nums){
            cs += num;
            if(cs > mid){
                pN++;
                cs = num;
            }
        }
        return pN;
    }
}