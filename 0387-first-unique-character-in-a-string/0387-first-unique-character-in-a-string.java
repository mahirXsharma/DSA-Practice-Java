class Solution {
    public int firstUniqChar(String s) {
        // 10^5 -> N only
        int n = s.length();
        int freq[] = new int[26];

        for(int i=0; i<n; i++) freq[s.charAt(i) - 'a']++;
        for(int i=0; i<n; i++){
            if(freq[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}