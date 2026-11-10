class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 10^4 -> N2 would barely Work, try for N or NlogN
        int n = strs.length;
        List<List<String>> ans = new ArrayList<>();
        // N * Number of Lists
        for(int i=0; i<n; i++){
            String str = strs[i];
            boolean matched = false;
            for(List<String> curr : ans ){
                String s = curr.get(0);
                if(isAmatch(str, s)){
                    curr.add(str);
                    matched = true;
                }
            }
            if(!matched){
                List<String> newList = new ArrayList<>();
                newList.add(str);
                ans.add(newList);
            }
        }
        return ans;
    }

    public boolean isAmatch(String s1, String s2){
        // check wether anagram or not
        if(s1.length() != s2.length()) return false;
        int freq[] = new int[26];
        for(int i=0; i<s1.length(); i++) freq[s1.charAt(i) - 'a']++;
        for(int i=0; i<s2.length(); i++){
            char curr = s2.charAt(i);
            freq[curr - 'a']--;
            if(freq[curr-'a'] < 0) return false;
        }
        return true;
    }
}