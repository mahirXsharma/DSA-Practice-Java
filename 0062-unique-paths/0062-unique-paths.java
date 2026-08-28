class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        return dfs(m, n, 0, 0, dp);
    }
    public int dfs(int m, int n, int i, int j, int dp[][]){
        if( i == m-1 && j == n-1){
            return dp[i][j] = 1;
        }
        if(dp[i][j] != 0) return dp[i][j];
        // move to right & down if possible
        int down = 0, right = 0;
        if(j < n-1)  right = dfs(m, n, i, j+1, dp);
        if(i < m-1)  down = dfs(m, n, i+1, j, dp);
        int total = down + right;
        return dp[i][j] = total;
    }
}