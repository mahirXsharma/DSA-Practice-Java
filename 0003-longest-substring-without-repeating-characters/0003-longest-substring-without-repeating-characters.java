class Solution {
    public int lengthOfLongestSubstring(String s) {
        // n-> 10^5 => N only
        int freq[] = new int[128];
        int l = 0, r =0, n = s.length(), ans = 0;
        while(r < n){
            char curr = s.charAt(r);
            freq[curr]++;
            while(freq[curr] >= 2){
                char atLeft = s.charAt(l);
                freq[atLeft]--;
                l++;
            }
            int len = r-l+1; 
            if(len > ans) ans = len;
            r++;
        }
        return ans;
    }
}