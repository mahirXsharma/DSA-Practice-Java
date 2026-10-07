class Solution {
    public int minCut(String s) {
        int n = s.length();
        int dp[] = new int[n];
        boolean isPal[][] = new boolean[n][n];

        for(int i=n-1; i>=0; i--){
            for(int j=i; j<n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j-i <= 2 || isPal[i+1][j-1]){
                        isPal[i][j] = true;
                    }
                }    
            }
        }
        // Arrays.fill(dp, -1);
        // return dfs(s, 0, dp);     
        for(int i=n-1; i>=0; i--){
            if (isPal[i][n-1]) {
                dp[i] = 0;
                continue;
            }
            int ans = Integer.MAX_VALUE;

            for(int k=i; k<n-1; k++){
                if(!isPal[i][k]) continue;

                int curr = dp[k+1] + 1;
                if(curr < ans) ans = curr;
            }
            dp[i] = ans;
        }
        return dp[0];
    }

    // public int dfs(String s, int i, int dp[]){
    //     if(i == s.length()-1 || isPalindrome(i, s.length()-1, s)) return 0;
    //     if(dp[i] != -1) return dp[i];

    //     int ans = Integer.MAX_VALUE;
    //     for(int k=i; k<s.length()-1; k++){
    //         if(!isPalindrome(i, k, s)) continue;
    //         int curr = dfs(s, k+1, dp) + 1;
    //         if(curr < ans) ans = curr;
    //     }
    //     return dp[i] = ans;
    // }

    // public boolean isPalindrome(int i, int j, String s){
    //     while(i <= j){
    //         if(s.charAt(i) != s.charAt(j)) return false;
    //         i ++;
    //         j--;
    //     }
    //     return true;
    // }
}