class Solution {
    int mod = (int) 1e9 + 7;

    public int countPalindromes(String s) {
        int n = s.length();
        if (n < 5)
            return 0;
        int ans = 0;

        for (char x = '0'; x <= '9'; x++) {
            for (char y = '0'; y <= '9'; y++) {
                int dp[][] = new int[n][5];
                for (int row[] : dp)
                    Arrays.fill(row, -1);
                ans = (ans + dfs(0, 0, x, y, s, dp)) % mod;
            }
        }
        return ans;
    }

    public int dfs(int i, int slot, char x, char y, String s, int dp[][]) {
        if (slot == 5)
            return 1;

        if (i >= s.length())
            return 0;
        if (dp[i][slot] != -1)
            return dp[i][slot];

        // leave this character
        int leave = dfs(i + 1, slot, x, y, s, dp);
        // if it match, then only take it
        char curr = (slot % 2 == 0) ? x : y;
        int take = 0;
        if (slot == 2 || s.charAt(i) == curr) {
            take = dfs(i + 1, slot + 1, x, y, s, dp);
        }
        return dp[i][slot] = (take + leave) % mod;
    }
}