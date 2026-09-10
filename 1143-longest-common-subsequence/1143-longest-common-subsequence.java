class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();
        int dp[][] = new int[n1+1][n2+1];
        // for(int row[] : dp) Arrays.fill(row, -1);
        // return dfs(0, 0, 0, text1, text2, dp);

        // TABULATION
        // idx's in the arr are off by one
        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    // take from the diagonal
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    if(dp[i-1][j] > dp[i][j-1]){
                        dp[i][j] = dp[i-1][j];
                    }
                    else dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[n1][n2];

    }

    public int dfs(int p1, int p2, int count, String s1, String s2, int dp[][]){
        if(p1 >= s1.length() || p2 >= s2.length()) return 0;
        if(dp[p1][p2] != -1) return dp[p1][p2];
        int ans = 0;
        if(s1.charAt(p1) == s2.charAt(p2)){
            int curr = dfs(p1+1, p2+1, count+1, s1, s2, dp);
            ans = Math.max(ans, curr);
        }
        else{
            int curr1 = dfs(p1, p2+1, count, s1, s2, dp);
            int curr2 = dfs(p1+1, p2, count, s1, s2, dp);
            int total = Math.max(curr1, curr2);
            ans = Math.max(total, ans);
        }
        return dp[p1][p2] =ans;
    }
}