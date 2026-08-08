class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> m=new HashMap<>();
        int max=0;
        int j=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            m.put(ch,m.getOrDefault(ch,0)+1);
            while(m.get(ch)>1){
                char c=s.charAt(j);
                m.put(c,m.get(c)-1);
                j++;
            }
            max=Math.max(max,i-j+1);
        }
        return max;
    }
}