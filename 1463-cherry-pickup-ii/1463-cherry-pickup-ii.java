class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int dp[][][] = new int[m][n][n];
        for(int row[][] : dp){
            for(int curr[] : row) Arrays.fill(curr , -1);
        }
        return dfs(grid, 0, n-1, 0, dp);
    }
    public int dfs(int grid[][], int j1, int j2, int i, int dp[][][]){
        int m = grid.length, n = grid[0].length;
        if(i == m) return 0;
        if(j1<0 || j2<0 || j1>=n || j2>=n)return -(int)1e8;
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
        int ans = 0;
        for(int d1=-1; d1<=1; d1++){
            for(int d2=-1; d2<=1; d2++){
                int curr =0;
                if(j1 == j2) curr+= grid[i][j1];
                else curr += grid[i][j1] + grid[i][j2];
                int value = curr + dfs(grid, j1+d1, j2+d2, i+1, dp);
                ans = Math.max(ans, value);
            }
        }
        return dp[i][j1][j2] = ans;
    }
}