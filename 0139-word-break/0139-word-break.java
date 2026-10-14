class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean dp[] = new boolean[n+1];
        dp[n] = true;
        // return dfs(0, s, wordDict, memo);

        // TABULATION
        for(int i=n-1; i>=0; i--){
            StringBuilder sb = new StringBuilder();
            for(int idx = i; idx<n; idx++){
                sb.append(s.charAt(idx));
                if(wordDict.contains(sb.toString())){
                    if(dp[idx+1]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[0];
    }


    // public boolean dfs(int i, String s, List<String> wordDict, Boolean memo[]){
    //     if(i >= s.length()) return true;
    //     if(memo[i] != null) return memo[i];
    //     StringBuilder sb = new StringBuilder();
    //     for(int idx = i; idx<s.length(); idx++){
    //         sb.append(s.charAt(idx));
    //         if(wordDict.contains(sb.toString())){
    //             if(dfs(idx+1, s, wordDict, memo)) return memo[i] = true;
    //         }
    //     }
    //     return memo[i] = false;
    // }
}