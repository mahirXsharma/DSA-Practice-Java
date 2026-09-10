class Solution {
    public int longestPalindromeSubseq(String s) {
        String s2 = new StringBuilder(s).reverse().toString();
        int n1 = s.length(), n2 = s2.length();
        int dp[][] = new int[n1][n2];
        for(int row[] : dp) Arrays.fill(row, -1);
        // int dp[][] = new int[n1+1][n2+1];
        // for(int i=1; i<=n1; i++){
        //     for(int j=1; j<=n2; j++){
        //         if(s.charAt(i-1) == s2.charAt(j-1)){
        //             dp[i][j] = dp[i-1][j-1] + 1;
        //         }
        //         else{
        //             dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        //         }
        //     }
        // }
        // return dp[n1][n2];
        return dfs(0, 0, s, s2, dp);
    }

    public int dfs(int p1, int p2, String s1, String s2, int dp[][]){
        if(p1 >= s1.length() || p2 >= s2.length()) return 0;
        if(dp[p1][p2] != -1) return dp[p1][p2];
        int ans = 0;
        if(s1.charAt(p1) == s2.charAt(p2)){
            int curr = dfs(p1+1, p2+1, s1, s2, dp) + 1;
            ans = Math.max(ans, curr);
        }
        else{
            int left = dfs(p1+1, p2, s1, s2, dp);
            int right = dfs(p1, p2+1, s1, s2, dp);
            ans = Math.max(left, right);
        }
        return dp[p1][p2] = ans;
    }

}