class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = 0;
        for(int pile : piles) max = pile > max ? pile : max;

        int si = 1, ei = max;
        int ans = 0;
        while(si <= ei){
            int mid = (si + (ei - si)/2);
            long cs = help(piles, mid);

            if(cs > h){
                si = mid+1;
            }
            else{
                ans = mid;
                ei = mid-1;
            }
        }
        return ans;
        
    }
    
    public long help(int nums[], int curr){
        long cs = 0;
        for(int num : nums){
            cs += (num + curr-1)/curr;
        }
        return cs;
    }
}