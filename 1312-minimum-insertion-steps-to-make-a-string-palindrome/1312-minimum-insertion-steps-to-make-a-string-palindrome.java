class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        int dp[][] = new int[n][n];
        for(int row[] : dp) Arrays.fill(row, -1);
        int lcs = dfs(0, 0, s, rev, dp);
        return n - lcs;
    }

    public int dfs(int i, int j, String s1, String s2, int dp[][]){
        if(i>=s1.length() || j>=s2.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            int curr = dfs(i+1, j+1, s1, s2, dp) + 1;
            ans = curr;
        }
        else{
            int left = dfs(i+1, j, s1, s2, dp);
            int right = dfs(i, j+1, s1, s2, dp);
            ans = Math.max(ans, Math.max(left, right));
        }
        return dp[i][j] = ans;
    }
}