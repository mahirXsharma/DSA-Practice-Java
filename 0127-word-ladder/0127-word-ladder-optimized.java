class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new ArrayDeque<>();
        int listSize = wordList.size();
        HashSet<String> set = new HashSet<>();
        for(int i=0; i <listSize; i++) set.add(wordList.get(i));
        q.add(beginWord);
        set.add(beginWord);
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            ans ++;
            for(int i=0; i<size; i++){
                String curr = q.poll();
                if(curr.equals(endWord)) return ans;
                char arr[] = curr.toCharArray();
                for(int j=0; j<curr.length(); j++){
                    char original = arr[j];
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        if(arr[j] == ch) continue;
                        arr[j] = ch;
                        String newString = new String(arr);
                        if(set.contains(newString)){
                            q.add(newString);
                            set.remove(newString);
                        }
                    }
                    arr[j] = original;
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