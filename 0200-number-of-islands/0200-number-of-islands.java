class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                char curr = grid[i][j];
                if(curr == '1'){
                    ans ++;
                    dfs(i, j, grid, m, n);
                }
            }
        }
        return ans;
    }
    public void dfs(int i, int j, char[][] grid, int m, int n){
        // right
        if(j+1 < n && grid[i][j+1] == '1' ){
            grid[i][j+1] = '0';
            dfs(i, j+1, grid, m, n);
        }
        // left
        if(j-1 >=0 && grid[i][j-1] == '1'){
            grid[i][j-1] = '0';
            dfs(i, j-1, grid, m, n);
        } 
        // top
        if(i-1 >=0 && grid[i-1][j] == '1'){
            grid[i-1][j] = '0';
            dfs(i-1, j, grid, m, n);
        }
        // bottom
        if(i+1 < m && grid[i+1][j] == '1'){
            grid[i+1][j] = '0';
            dfs(i+1, j, grid, m, n);
        }
    }
}