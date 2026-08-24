class Solution {
    public int climbStairs(int n) {
         if(n == 1 || n == 2) return n;
        int prev1 = 1, prev2 = 2;
        int ans = 0;
        for(int i=3; i<=n; i++){
            ans = prev1 + prev2;
            prev1 = prev2;
            prev2 = ans;
        }
        return ans;
    }


    // TOP-DOWN
    // public int rec(int n, int curr, int dp[]){
    //     if(curr == n) return 1;
    //     if(curr > n) return 0;
    //     if(dp[curr] != 0) return dp[curr];


    //     int ways = rec(n, curr+1, dp) + rec(n, curr+2, dp);
    //     return dp[curr] = ways;
    
}