class Solution {
    public boolean isAnagram(String s, String t) {
        // n -> 5*10^4 => N only
        // in case the String also contains UNI CODE -> then we will resort to using HASHMAP
        int n1 = s.length(), n2 = t.length();
        if(n1 != n2) return false;
        int freq[] = new int[26];
        for(int i=0; i<n1; i++){
            freq[s.charAt(i)-'a'] ++;
        }
        for(int i=0; i<n1; i++){
            freq[t.charAt(i)- 'a']--;
        }

        for(int num : freq){
            if(num != 0) return false;
        }
        return true;
    }
}