class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new ArrayDeque<>();
        int listSize = wordList.size();
        HashSet<String> set = new HashSet<>();
        q.add(beginWord);
        set.add(beginWord);
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            ans ++;
            for(int i=0; i<size; i++){
                String curr = q.poll();
                if(curr.equals(endWord)) return ans;
                for(int j=0; j<listSize; j++){
                    String currString = wordList.get(j);
                    if(differ(curr, currString) && !set.contains(currString)){
                        set.add(currString);
                        q.add(currString);
                    }
                }
            }
        }
        return 0;
    }
    public boolean differ(String curr1, String curr2){
        int sc = 0;
        for(int i=0; i<curr1.length(); i++){
            if(curr1.charAt(i) != curr2.charAt(i)) sc++;
        } 
        return sc == 1;
    }
}