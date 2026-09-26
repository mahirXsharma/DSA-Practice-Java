class Solution {
    public List<List<String>> solveNQueens(int n) {
        char matrix[][] = new char[n][n];
        for(char row[] : matrix) Arrays.fill(row, '.');

        List<List<String>> ans = new ArrayList<>();

        dfs(matrix, 0, ans, n);
        return ans;
    }

    public void dfs(char matrix[][], int row, List<List<String>> ans, int n){
        if(row == n){
            List<String> validPath = new ArrayList<>();
            for(int i=0; i<n; i++){
                validPath.add(new String(matrix[i]));               
            } 
            ans.add(validPath);
            return;
        }

        for(int i=0; i<n; i++){
            // is this safe ? if yes then  place the Queen

            if(isSafe(row, i, matrix, n)){
                matrix[row][i] = 'Q';
                dfs(matrix, row+1, ans, n);
                matrix[row][i] = '.';
            }
        }
    }
    public boolean isSafe(int row, int col, char matrix[][], int n){
        // when it is safe?? -> top, left & right diag !
        for(int i = row-1; i >= 0; i--){
            if(matrix[i][col] == 'Q') return false;
        }

        int currRow = row-1, currCol = col-1;
        while(currRow >= 0 && currCol >= 0){
            if(matrix[currRow][currCol] == 'Q') return false;
            currRow--;
            currCol--;
        }

        currRow = row-1;
        currCol = col+1;
        while(currRow >= 0 && currCol < n){
            if(matrix[currRow][currCol] == 'Q') return false;
            currRow--;
            currCol++;
        }
        return true;

    }
}