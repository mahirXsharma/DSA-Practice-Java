class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 1 || n == 0) return n;
        HashSet<Character> set = new HashSet<>();
        int left = 0, ans = 0;

        for(int right = 0; right<n ; right ++){
            char currChar = s.charAt(right);
            while(set.contains(currChar)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(currChar);
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }
}