class Solution {
    public int[] beautifulArray(int n) {
        
        int[] ans = new int[n];
        if(n == 1) ans[0] = 1;
        else {
            int idx = 0;
            for(int x : beautifulArray((n+1)/2)){
                ans[idx] = 2*x-1;
                idx++;
            }

            // right side
            for(int x : beautifulArray(n/2)){
                ans[idx] = 2*x;
                idx++;
            }
        }
        return ans;

    }
}