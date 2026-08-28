class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;
        int dp[][] = new int[m][n];
        for(int row[] : dp) Arrays.fill(row, -1);
        // TABULATION   
        dp[m-1][n-1] = 1;
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(i == m-1 && j == n-1) continue;
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                    }
                // check the right and bottom
                int right = 0, down = 0;
                if(j+1 < n) right = dp[i][j+1];
                if(i+1 < m) down = dp[i+1][j];
                dp[i][j] = right + down;
            }
        }
        return dp[0][0];
        // return dfs(obstacleGrid, 0, 0, dp, m, n);
    }
    public int dfs(int obstacleGrid[][], int i, int j, int dp[][], int m, int n){

        if(obstacleGrid[i][j] == 1) return dp[i][j] = 0;
        if(i == m-1 && j == n-1) return dp[i][j] = 1;
        if(dp[i][j] != -1)  return dp[i][j];
        int right = 0, down = 0;
        if(j < n-1) right = dfs(obstacleGrid, i, j+1, dp, m, n);
        if(i < m-1) down = dfs(obstacleGrid, i+1, j, dp, m, n);
        return dp[i][j] = right + down;
    }
}