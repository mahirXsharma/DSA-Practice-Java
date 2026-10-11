class Solution {
    public int numSubmat(int[][] mat) {

        int n=mat.length, m = mat[0].length; 
        int dp[][] = new int[n][m];

        for(int i=0; i<n; i++)dp[i][0] = mat[i][0];
        // clone mat
        for(int i=0; i<n; i++){
            for(int j=1; j<m; j++){
                if(mat[i][j] == 0) continue;
                dp[i][j] = dp[i][j-1] +1;
            }
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int row = i;
                int curr = dp[row][j];
                if(curr == 0) continue;
                int min = curr;
                while(curr != 0 && row >= 0){
                    min = Math.min(min, dp[row][j]);
                    ans += min;
                    row--;
                }
            }
        }
        return ans;
    }
}