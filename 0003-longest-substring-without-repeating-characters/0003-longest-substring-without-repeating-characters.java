class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 1 || n == 0) return n;
        boolean vis[] = new boolean[128];
        int left = 0, ans = 0;

        for(int right = 0; right<n ; right ++){
            char currChar = s.charAt(right);
            while(vis[currChar]){
                vis[s.charAt(left)] = false;
                left++;
            }
            vis[currChar] = true;
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }
}