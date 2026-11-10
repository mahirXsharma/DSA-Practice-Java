class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 10^4 -> N2 would barely Work, try for N or NlogN
        int n = strs.length;
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
    
        for(int i=0; i<n; i++){
            char[] arr = strs[i].toCharArray();
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
        for(String key : map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
    }
}