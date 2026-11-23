class Trie {

    class TrieNode{
        TrieNode child[] = new TrieNode[26];
        boolean eow = false;
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();    
    }
    
    public void insert(String word) {
        int n = word.length();
        TrieNode curr = root;
        for(int i=0; i<n; i++){
            int idx = word.charAt(i) - 'a';
            if(curr.child[idx] == null){
                curr.child[idx] = new TrieNode();
            }
            curr = curr.child[idx];
            if(i == n-1) curr.eow = true;
        }
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        int n = word.length();
        for(int i=0; i<n; i++){
            int idx = word.charAt(i) - 'a';
            if(curr.child[idx] == null) return false;
            curr = curr.child[idx];
            if(i == n-1 && curr.eow == false) return false;
        }
        return true;
    }
    
    public boolean startsWith(String word) {
        TrieNode curr = root;
        int n = word.length();
        for(int i=0; i<n; i++){
            int idx = word.charAt(i) - 'a';
            if(curr.child[idx] == null) return false;
            curr = curr.child[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */