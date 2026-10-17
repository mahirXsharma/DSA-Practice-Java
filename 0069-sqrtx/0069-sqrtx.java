class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        long si = 1, ei = x/2;
        int ans = 0;
        while(si <= ei){
            int mid = (int)(si + (ei - si)/2);
            if (mid == x/mid) return mid;
            else if(mid > x/mid){
                ei = mid-1;
            }
            else {
                ans = mid;
                si = mid+1;
            }
        }
        return ans;
    }
}