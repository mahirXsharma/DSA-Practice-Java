class Solution {
    public int numDistinct(String s, String t) {
        StringBuilder sb = new StringBuilder();
        int dp[][] = new int[t.length()][s.length()];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return dfs(0, 0, s, t, sb, dp);
    }

    public int dfs(int i, int idx, String s, String t, StringBuilder sb, int dp[][]){
        if(i == t.length() || idx == s.length()){
            if(sb.toString().equals(t)) return 1;
            else return 0;
        }
        if(dp[i][idx] != -1) return dp[i][idx];
        int take = 0;
        if(s.charAt(idx) == t.charAt(i)) { 
            take = dfs(i+1, idx+1, s, t, sb.append(s.charAt(idx)), dp);
            sb.deleteCharAt(sb.length()-1);
        }
        
        int leave = dfs(i, idx+1, s, t, sb, dp);
        return dp[i][idx] = take + leave;
    }
}