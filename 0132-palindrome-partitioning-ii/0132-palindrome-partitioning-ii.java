class Solution {
    public int minCut(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for(int row[] : dp) Arrays.fill(row, -1);
        return dfs(s, 0, n- 1, dp);     
    }

    public int dfs(String s, int i, int j, int dp[][]){
        if(i == j || isPalindrome(i, j, s)) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int ans = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            if(!isPalindrome(i, k, s)) continue;
            int curr = dfs(s, k+1, j, dp) + 1;
            if(curr < ans) ans = curr;
        }
        return dp[i][j] = ans;
    }

    public boolean isPalindrome(int i, int j, String s){
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i ++;
            j--;
        }
        return true;
    }
}