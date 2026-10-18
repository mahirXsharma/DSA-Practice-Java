class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(n < (long)m*k) return -1;
        int max = 0;
        for(int day : bloomDay) max = day > max ? day : max;

        int si = 1, ei = max;
        int ans = 0;
        while(si <= ei){
            int mid = (si + (ei - si)/2);
            boolean isPossible = help(bloomDay, mid, m, k);

            if(isPossible){
                ans = mid;
                ei = mid-1;
            }
            else{
                si = mid+1;
            }
        }

        return ans;
    }

    public boolean help(int nums[], int curr, int m, int k){
        int count = 0;
        for(int num : nums){
            if(num <= curr) count ++;
            else count = 0;
            if(count == k){
                m--;
                count = 0;
            }
            if(m == 0) return true;
        }
        return false;
    }
}