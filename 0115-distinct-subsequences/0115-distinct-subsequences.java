class Solution {
    public int numDistinct(String s, String t) {
        int dp[][] = new int[t.length()][s.length()];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return dfs(0, 0, s, t, dp);
    }

    public int dfs(int i, int idx, String s, String t, int dp[][]){
            if(i == t.length()) return 1;
            if(idx == s.length()) return 0;

        if(dp[i][idx] != -1) return dp[i][idx];
        int take = 0;
        if(s.charAt(idx) == t.charAt(i)) { 
            take = dfs(i+1, idx+1, s, t, dp);
        }
        
        int leave = dfs(i, idx+1, s, t, dp);
        return dp[i][idx] = take + leave;
    }
}