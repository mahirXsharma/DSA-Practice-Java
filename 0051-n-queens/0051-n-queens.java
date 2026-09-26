class Solution {
    public List<List<String>> solveNQueens(int n) {
        char matrix[][] = new char[n][n];
        for(char row[] : matrix) Arrays.fill(row, '.');

        List<List<String>> ans = new ArrayList<>();
        boolean isCol[] = new boolean[n];
        boolean left[] = new boolean[2*n-1];
        boolean right[] = new boolean[2*n-1];
        dfs(matrix, 0, ans, n, isCol, left, right);
        return ans;
    }

    public void dfs(char matrix[][], int row, List<List<String>> ans, int n, boolean isCol[], boolean left[], boolean right[]){
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
            int minor = row+i;
            int major = row-i + n-1;

            if(!isCol[i] && !left[major] && !right[minor]){
                matrix[row][i] = 'Q';
                isCol[i]=true;
                left[major] = true;
                right[minor] = true;

                dfs(matrix, row+1, ans, n, isCol, left, right);
                matrix[row][i] = '.';

                isCol[i]=false;
                left[major] = false;
                right[minor] = false;
            }
        }
    }
    
}