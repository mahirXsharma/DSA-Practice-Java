class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0, sum = 0;
        int freq[] = new int[128];

        while(right < n){
            char curr = s.charAt(right);
            while(freq[curr] > 0){
                freq[s.charAt(left)]--;
                left++;
            }
            freq[curr] ++;
            right++;
            int val = right - left;
            if(val > sum) sum = val;
        }
        return sum;
    }
}