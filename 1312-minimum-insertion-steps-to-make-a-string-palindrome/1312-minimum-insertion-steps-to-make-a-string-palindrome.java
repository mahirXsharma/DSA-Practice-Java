class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        // int dp[][] = new int[n+1][n+1];
        // for(int row[] : dp) Arrays.fill(row, -1);
        // int lcs = dfs(0, 0, s, rev, dp);
        int bottomRow[] = new int[n+1];
        int currRow[] = new int[n+1];


        // TABULATION
        for(int i=n-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                // int ans =0;
                if(s.charAt(i) == rev.charAt(j)){
                    currRow[j] = bottomRow[j+1]+1;
                    // ans = curr;
                }
                else{
                    int left = bottomRow[j];
                    int right = currRow[j+1];
                    currRow[j] = Math.max(left, right);
                }
                // dp[i][j] = ans;
            }
            bottomRow = currRow.clone();

        }
        int lcs = bottomRow[0];


        return n - lcs;
    }

    // public int dfs(int i, int j, String s1, String s2, int dp[][]){
    //     if(i>=s1.length() || j>=s2.length()) return 0;

    //     if(dp[i][j] != -1) return dp[i][j];
    //     int ans = 0;
    //     if(s1.charAt(i) == s2.charAt(j)){
    //         int curr = dfs(i+1, j+1, s1, s2, dp) + 1;
    //         ans = curr;
    //     }
    //     else{
    //         int left = dfs(i+1, j, s1, s2, dp);
    //         int right = dfs(i, j+1, s1, s2, dp);
    //         ans = Math.max(ans, Math.max(left, right));
    //     }
    //     return dp[i][j] = ans;
    // }
}