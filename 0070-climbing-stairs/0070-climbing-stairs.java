class Solution {
    public int climbStairs(int n) {
        int curr = 0;
        int dp[] = new int[n+1];
        return rec(n, curr, dp);
    }
    public int rec(int n, int curr, int dp[]){
        if(curr == n) return 1;
        if(curr > n) return 0;
        if(dp[curr] != 0) return dp[curr];


        int ways = rec(n, curr+1, dp) + rec(n, curr+2, dp);
        return dp[curr] = ways;

        
    }

}