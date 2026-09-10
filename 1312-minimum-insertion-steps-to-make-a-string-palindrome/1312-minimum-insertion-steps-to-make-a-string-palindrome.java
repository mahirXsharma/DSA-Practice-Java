class Solution {
    public int minInsertions(String s) {
        String s2 = new StringBuilder(s).reverse().toString();
        int n1 = s.length(), n2 = s2.length();
        int dp[][] = new int[n1+1][n2+1];
        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(s.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return n1 - dp[n1][n2];
    }
}