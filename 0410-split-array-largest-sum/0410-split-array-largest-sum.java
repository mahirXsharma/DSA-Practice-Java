class Solution {
    public int splitArray(int[] nums, int k) {
        int max = 0, ts = 0;
        for(int num : nums){
            ts += num;
            if(num > max) max = num;
        }
        int si = max, ei = ts;
        int ans = 0;
        while( si <= ei){
            int mid = (si + (ei -si)/2);
            int dn = help(mid, nums);

            if(dn >= k){
                si = mid+1;
            }
            else{
            ans = mid;

                ei = mid-1;
            }
        }
        return ans;
    }

    public int help(int curr, int nums[]){
        int cs = 0;
        int dn = 0;
        for(int num : nums){
            cs += num;
            if(cs > curr){
                dn ++;
                cs = num;
            }
        }
        return dn;
    }
}