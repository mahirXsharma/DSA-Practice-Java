class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 10^4 -> N2 would barely Work, try for N or NlogN
        int n = strs.length;
        HashMap<String, List<String>> map = new HashMap<>();
        // n * klogK
        for(int i=0; i<n; i++){
            char[] arr = strs[i].toCharArray();
            // klogk
            Arrays.sort(arr);
            String s = new String(arr);
            if(map.containsKey(s)){
                List<String> curr = map.get(s);
                curr.add(strs[i]);
                map.put(s, curr);
            }
            else{
                map.put(s, new ArrayList<>( List.of(strs[i]) ));
            }
        }
        List<List<String>> ans = new ArrayList<>( map.values() );

        return ans;
    }
}