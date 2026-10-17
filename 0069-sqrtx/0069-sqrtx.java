class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        long si = 1, ei = x/2;
        long ans = 0;
        while(si <= ei){
            long mid = (si + (ei - si)/2);
            long curr = mid * mid;
            if (curr == x) return (int)mid;
            else if(curr > x){
                ei = mid-1;
            }
            else {
                ans = mid;
                si = mid+1;
            }
        }
        return (int)ans;
    }
}