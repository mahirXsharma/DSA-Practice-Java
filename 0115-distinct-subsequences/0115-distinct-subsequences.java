class Solution {
    public int numDistinct(String s, String t) {
        int n1 = t.length(), n2 = s.length();
        int dp[][] = new int[n1+1][n2+1];
        // for (int row[] : dp)
        //     Arrays.fill(row, -1);
        // return dfs(0, 0, s, t, dp);

        // TABULATION
        for(int j=0; j<=n2; j++){
            dp[n1][j] = 1;
        }
        for(int i=n1-1; i>=0; i--){
            for(int j=n2-1; j>=0; j--){
                int take = 0;
                if(s.charAt(j) == t.charAt(i)){
                    take = dp[i+1][j+1];
                }
                int leave = dp[i][j+1];
                dp[i][j] = take + leave;
            }
        }
        return dp[0][0];
    }

    public int dfs(int i, int idx, String s, String t, int dp[][]){
            if(i == t.length()) return 1;
            if(idx == s.length()) return 0;

        if(dp[i][idx] != -1) return dp[i][idx];
        int take = 0;
        if(s.charAt(idx) == t.charAt(i)) { 
            take = dfs(i+1, idx+1, s, t, dp);
        }
        
        int leave = dfs(i, idx+1, s, t, dp);
        return dp[i][idx] = take + leave;
    }
}