class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int dirs[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for(int i=0; i<m; i++){
            if(grid[i][0] == 1)dfs(i, 0, grid, dirs, m, n);
            if(grid[i][n-1] == 1)dfs(i, n-1, grid, dirs, m, n);
        }
        for(int j=0; j<n; j++){
            if(grid[0][j] == 1)dfs(0, j, grid, dirs, m, n);
            if(grid[m-1][j] == 1)dfs(m-1, j, grid, dirs, m, n);
        }
        int ans =0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1)  ans++;
            }
        }
        return  ans;

    }
    // i, j, grid, m, n
    public void dfs(int i, int j, int grid[][], int dirs[][], int m, int n){
        int r = i, c = j;
        grid[i][j] = 2;
        for(int dir[] : dirs){
            int nextR = r + dir[0];
            int nextC = c + dir[1];
            if(nextR < m && nextR >= 0 && nextC < n && nextC >=0){
                if(grid[nextR][nextC] == 1) dfs(nextR, nextC, grid, dirs, m, n);
            }
        }
    }
}