class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // int dp[][] = new int[m][n];
        // return dfs(grid, 0, 0, m, n, dp);
        // TABULATION
        // dp[0][0] = grid[0][0];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                // check up and left
                if(i == 0 && j  == 0) continue;
                int curr = grid[i][j];
                int left = Integer.MAX_VALUE, up = Integer.MAX_VALUE;
                if(i-1 >=0) up = curr + grid[i-1][j];
                if(j-1 >=0) left = curr + grid[i][j-1];
                // dp[i][j] = Math.min(up, left); 
                grid[i][j] = Math.min(up, left);
            }
        }
        return grid[m-1][n-1];

    }
    public int dfs(int grid[][] , int i, int j, int m, int n, int dp[][]){
        if(i == m-1 && j == n-1) return grid[i][j];
        if(dp[i][j] != 0) return dp[i][j];
        int right = Integer.MAX_VALUE, down = Integer.MAX_VALUE;
        if(i < m-1) down = grid[i][j] + dfs(grid, i+1, j, m, n, dp);
        if(j < n-1) right = grid[i][j] + dfs(grid, i, j+1, m, n, dp);
 
         return dp[i][j] = Math.min(down, right );
    }
}