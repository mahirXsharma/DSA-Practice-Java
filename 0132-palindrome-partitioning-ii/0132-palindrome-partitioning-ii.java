class Solution {
    public int minCut(String s) {
        int n = s.length();
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return dfs(s, 0, dp);     
    }

    public int dfs(String s, int i, int dp[]){
        if(i == s.length()-1 || isPalindrome(i, s.length()-1, s)) return 0;
        if(dp[i] != -1) return dp[i];

        int ans = Integer.MAX_VALUE;
        for(int k=i; k<s.length()-1; k++){
            if(!isPalindrome(i, k, s)) continue;
            int curr = dfs(s, k+1, dp) + 1;
            if(curr < ans) ans = curr;
        }
        return dp[i] = ans;
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