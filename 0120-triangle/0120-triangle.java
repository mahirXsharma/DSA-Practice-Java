class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int dp[][] = new int[m][m];
        // for(int row[] : dp) Arrays.fill(row, (int)1e9);
        // return dfs(triangle, dp, 0, 0);
        // TABULATION
        List<Integer> last = triangle.get(m-1);
        for(int i=0; i<last.size(); i++){
            dp[m-1][i] = last.get(i);
        }
        for(int i=m-2; i>=0; i--){
            List<Integer> curr = triangle.get(i);
            for(int j=0; j<curr.size(); j++){
                dp[i][j] = curr.get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        return dp[0][0];

    }
    public int dfs( List<List<Integer>> list, int dp[][], int i, int idx){
        if(i == list.size()) return 0;
        if(dp[i][idx] != (int)1e9) return dp[i][idx];
        int curr = list.get(i).get(idx);
        int stay = curr + dfs(list, dp, i+1, idx);
        int go = curr + dfs(list, dp, i+1, idx+1);
        return dp[i][idx] = Math.min(stay, go);
    }
}