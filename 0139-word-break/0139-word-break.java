class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean memo[] = new Boolean[s.length()];
        return dfs(0, s, wordDict, memo);
    }

    public boolean dfs(int i, String s, List<String> wordDict, Boolean memo[]){
        if(i >= s.length()) return true;
        if(memo[i] != null) return memo[i];
        StringBuilder sb = new StringBuilder();
        for(int idx = i; idx<s.length(); idx++){
            sb.append(s.charAt(idx));
            if(wordDict.contains(sb.toString())){
                if(dfs(idx+1, s, wordDict, memo)) return memo[i] = true;
            }
        }
        return memo[i] = false;
    }
}