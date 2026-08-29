class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int dp[][] = new int[m][m];
        for(int row[] : dp) Arrays.fill(row, (int)1e9);
        return dfs(triangle, dp, 0, 0);

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