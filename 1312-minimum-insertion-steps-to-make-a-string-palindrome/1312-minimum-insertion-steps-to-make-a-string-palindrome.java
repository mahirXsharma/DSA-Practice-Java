class Solution {
    public int minInsertions(String s) {
        // String s2 = new StringBuilder(s).reverse().toString();
        int n = s.length();
        // int dp[][] = new int[n][n];
        // for(int row[] : dp) Arrays.fill(row, -1);
        // return n - dfs(0, n-1, s, s, dp);


        // TABULATION

        int dp[][] = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(s.charAt(i-1) == s.charAt(n-j)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return n - dp[n][n];
    }

    public int dfs(int p1, int p2, String s1, String s2, int dp[][]){
        if(p1 >= s1.length() || p2 < 0) return 0;
        if(dp[p1][p2] != -1) return dp[p1][p2];
        int ans = 0;
        if(s1.charAt(p1) == s2.charAt(p2)){
            int curr = dfs(p1+1, p2-1, s1, s2, dp) + 1;
            ans = Math.max(ans, curr);
        }
        else{
            int left = dfs(p1+1, p2, s1, s2, dp);
            int right = dfs(p1, p2-1, s1, s2, dp);
            ans = Math.max(left, right);
        }
        return dp[p1][p2] =ans;
    }
}