class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n <= 1) return n;
  
        int[] lastSeen = new int[128]; 
        char[] chars = s.toCharArray();
        
        int left = 0;
        int ans = 0;
        
        for (int right = 0; right < n; right++) {
            char currChar = chars[right];

            if (lastSeen[currChar] > left) {
                left = lastSeen[currChar]; 
            }
            
            ans = Math.max(ans, right - left + 1);
            lastSeen[currChar] = right + 1;
        }
        
        return ans;
    }
}