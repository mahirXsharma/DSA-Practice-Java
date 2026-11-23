class WordDictionary {

    class TrieNode {
        TrieNode child[] = new TrieNode[26];
        boolean eow = false;
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.child[idx] == null) {
                curr.child[idx] = new TrieNode();
            }
            curr = curr.child[idx];
            if (i == n - 1)
                curr.eow = true;
        }
    }

    public boolean search(String word) {
        TrieNode curr = root;
        int n = word.length();
        return dfs(curr, n, word, 0);
    }
    
    public boolean dfs(TrieNode root, int n, String word, int idx){
        if(idx == n) return root.eow;
        char curr = word.charAt(idx);
        boolean ans = false;
        if(curr == '.'){
            for(int i=0; i<26; i++){
                TrieNode ex = root;
                if(ex.child[i] != null){
                    ex = root.child[i];
                    if(dfs(ex, n, word, idx+1) == true) return true;
                }
            }
        }   
        else{
            int i = curr - 'a';
            if(root.child[i] == null) return false;
            root = root.child[i];
            ans = dfs(root, n, word, idx+1);
        }
        return ans;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */