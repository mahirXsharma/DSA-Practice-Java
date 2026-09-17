class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length() + 1][p.length() + 1];
        return dfs(s, p, 0, 0, dp);
    }
    private boolean dfs(String s, String p, int i, int j, int[][] dp) {
        if (j == p.length()) {
            return i == s.length();
        }

        if (i == s.length()) {
            for (int k = j; k < p.length(); k++) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }
        if (dp[i][j] != 0) {
            return dp[i][j] == 1 ? true : false;
        }

        boolean match = false;
        
        if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
            match = dfs(s, p, i + 1, j + 1, dp);
        } else if (p.charAt(j) == '*') {

            match = dfs(s, p, i, j + 1, dp) || dfs(s, p, i + 1, j, dp);
        } else {
            match = false;
        }
        dp[i][j] = match ==true ? 1 : -1;
        return match;
    }
}