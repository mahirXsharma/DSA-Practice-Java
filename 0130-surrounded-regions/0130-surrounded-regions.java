class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        int dirs[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // rows
        for(int i=0; i<m; i++){
            if (board[i][0] == 'O') dfs(i, 0, board, dirs, m, n);
            if (board[i][n-1] == 'O') dfs(i, n-1, board, dirs, m, n);
        }
        // columns
         for(int j=0; j<n; j++){
            if (board[0][j] == 'O') dfs(0, j, board, dirs, m, n);
            if (board[m-1][j] == 'O') dfs(m-1, j, board, dirs, m, n);
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'M') board[i][j] = 'O';
            }
        }

    }
    public void dfs(int i, int j, char board[][], int dirs[][], int m, int n){
        // convert the curr 0 to M
        // check if it has any zero near by
        // if yes -> call dfs for them 
        // if no-> return
        board[i][j] = 'M';
        for(int dir[] : dirs){
            int nextR = i + dir[0];
            int nextC = j + dir[1];
            if(nextR < m && nextR >=0 && nextC < n && nextC >=0){
                if(board[nextR][nextC] == 'O') dfs(nextR, nextC, board, dirs, m, n);
            }
        }
    }
}