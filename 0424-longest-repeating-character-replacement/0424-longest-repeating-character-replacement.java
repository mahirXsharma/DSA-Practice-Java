class Solution {
    public int characterReplacement(String s, int k) {

        int n = s.length();
        int freq[] = new int[26];
        int right = 0, left = 0, max = 0, maxFreq = 0;

        while(right < n){
            char curr = s.charAt(right);
            freq[curr-'A']++;
            maxFreq = Math.max(maxFreq, freq[curr-'A']);

            while(right - left + 1 - maxFreq > k){
                char atLeft = s.charAt(left);
                freq[atLeft - 'A']--;
                left++;
            }
            int cs = right - left + 1;
            if(cs > max) max = cs;
            right ++;
        }
        return max;
    }
}