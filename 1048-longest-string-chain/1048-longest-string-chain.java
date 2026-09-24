class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length, ans = 1;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(words, (a,b)->a.length()-b.length());

        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(words[i].length() != words[j].length() + 1) continue;
                if(dfs(words[i], words[j] ) && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                }
            }
            if(dp[i] > ans){
                ans = dp[i];
            }
        }
        return ans;
    }

    public boolean dfs(String s1, String s2){
        int count =0, i=0, j=0;
        while(i < s1.length() && j<s2.length()){
            if(count > 1) return false;
            if(s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
                count++;
            }
        }

        return j == s2.length();
    }

}