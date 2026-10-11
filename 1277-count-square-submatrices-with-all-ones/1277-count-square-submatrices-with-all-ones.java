class Solution {
    public int countSquares(int[][] matrix) {
        // TABULATION
        int n=matrix.length, m = matrix[0].length;
        int dp[][] = new int[n][m];
        // filling the first row and col
        for(int j=0; j<m; j++)dp[0][j] = matrix[0][j];
        for(int i=0; i<n; i++)dp[i][0] = matrix[i][0];

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(matrix[i][j] == 0) continue;
                int lg = Math.min(dp[i][j-1], dp[i-1][j-1]);
                dp[i][j] = Math.min(dp[i-1][j], lg)+1;

            }
        }

        int ans = 0;
        for(int row[] : dp){
            for(int curr:row){
                ans+= curr;
            }
        }
        return ans;
    }
}