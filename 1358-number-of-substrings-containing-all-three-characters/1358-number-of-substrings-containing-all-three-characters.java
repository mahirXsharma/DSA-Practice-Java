class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length(), ans = 0;
        int freq[] = new int[3];
        for (int i = 0; i < 3; i++)
            freq[i] = -1;

        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a'] = i;
            if (freq[0] != -1 && freq[1] != -1 && freq[2] != -1) {
                int idx = Math.min(freq[0], Math.min(freq[1], freq[2]));
                ans += idx + 1;
            }
        }
        return ans;
    }
}