class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0, sum = 0;
        HashSet<Character> set = new HashSet<>();

        while(right < n){
            char curr = s.charAt(right);
            while(set.contains(curr)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(curr);
            right++;
            int val = right - left;
            if(val > sum) sum = val;
        }
        return sum;
    }
}