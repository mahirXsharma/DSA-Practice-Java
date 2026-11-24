class Solution {
    public List<Integer> partitionLabels(String s) {
        // s.length -> 500 => any tc will work
        char arr[] = s.toCharArray();
        int n = arr.length, l = 0, r = 0;
        int freq[] = new int[26];
        for(char curr : arr){
            freq[curr - 'a']++;
        }
        List<Integer> list = new ArrayList<>();
        HashSet<Character> set = new HashSet<>();
        while( r < n){
            char curr = arr[r];
            set.add(curr);
            freq[curr-'a']--;
            // a loop to check if all the chars in the set is at 0
            boolean f = true;;
            for(Character kar : set){
                if(freq[kar - 'a'] != 0) f = false;
            }
            if(f){
                int len = r - l + 1;
                list.add(len);
                set.clear();
                l = r+1;
            }
            r++;
        }
        return list;
    }
}