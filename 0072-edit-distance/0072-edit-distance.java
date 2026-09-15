class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        int dp[][] = new int[n1+1][n2+1];
        //     for(int row[] : dp) Arrays.fill(row, -1);
        //  return dfs(word1, word2, n1-1, n2-1, dp);   

        // TABULATION
        for(int i=0; i<=n1; i++) dp[i][0] = i;
        for(int j=0; j<=n2; j++) dp[0][j] = j;

        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int up = dp[i-1][j];
                    int left = dp[i][j-1];
                    int diag = dp[i-1][j-1];
                    dp[i][j] = 1 + Math.min(left, Math.min(diag, up));
                }
            }
        }
        return dp[n1][n2];
    }
    public int dfs(String s1, String s2, int i, int j, int dp[][]){
        if(i < 0){
            return j+1;
        }
        if(j<0){
            return i+1;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        if(s1.charAt(i) == s2.charAt(j)) {
            ans = Math.min(ans, dfs(s1, s2, i-1, j-1, dp));
            }
        else{
            // insertion, deletion, replacing
            int ins = 1+dfs(s1, s2, i, j-1, dp);
            int del = 1+dfs(s1, s2, i-1, j, dp);
            int rep = 1+dfs(s1, s2, i-1, j-1, dp);
            ans = Math.min(ins, Math.min(del, rep));
        }
        return dp[i][j] = ans;
    }
}