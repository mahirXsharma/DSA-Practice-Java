class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n <= 1) return n;
        
        // Use an integer array to store the LAST SEEN INDEX of each character
        // Default values in Java are 0, so we have to be careful with index 0.
        // We will store (index + 1) to avoid confusing index 0 with an empty slot.
        int[] lastSeen = new int[128]; 
        
        // Convert to a raw char array to avoid charAt() overhead
        char[] chars = s.toCharArray();
        
        int left = 0;
        int ans = 0;
        
        for (int right = 0; right < n; right++) {
            char currChar = chars[right];
            
            // If we've seen this character before AND its last position is inside our current window
            if (lastSeen[currChar] > left) {
                // INSTANT TELEPORT: Jump 'left' pointer directly past the duplicate
                left = lastSeen[currChar]; 
            }
            
            // Calculate max (right - left + 1)
            ans = Math.max(ans, right - left + 1);
            
            // Update the memory bank with the new (index + 1)
            lastSeen[currChar] = right + 1;
        }
        
        return ans;
    }
}