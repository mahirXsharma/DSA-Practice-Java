class Solution {
    Map<String, Integer> map;
    List<List<String>> ans;
    String b;
    Map<String, List<String>> adj; // 1. Add an Adjacency List

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        ans = new ArrayList<>();
        map = new HashMap<>();
        adj = new HashMap<>();
        b = beginWord;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        map.put(beginWord, 1);
        dict.remove(beginWord);
        
        boolean found = false;
        
        while (!q.isEmpty() && !found) {
            int size = q.size();
            Set<String> toRemove = new HashSet<>();
            
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                int currSteps = map.get(curr);
                
                // Don't break immediately, we need to finish the whole level
                if (curr.equals(endWord)) found = true; 
                
                char[] arr = curr.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char original = arr[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (arr[j] == ch) continue;
                        
                        arr[j] = ch;
                        String nextWord = new String(arr);
                        
                        if (dict.contains(nextWord)) {
                            toRemove.add(nextWord);
                            
                            // 2. Build the parent-child map forward so DFS can instantly walk backward
                            adj.computeIfAbsent(nextWord, k -> new ArrayList<>()).add(curr);
                            
                            if (!map.containsKey(nextWord)) {
                                map.put(nextWord, currSteps + 1);
                                q.add(nextWord);
                            }
                        }
                    }
                    arr[j] = original;
                }
            }
            dict.removeAll(toRemove);
        }
        
        if (map.containsKey(endWord)) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            dfs(endWord, path);
        }
        
        return ans;
    }
    
    private void dfs(String curr, List<String> path) {
        if (curr.equals(b)) {
            List<String> validPath = new ArrayList<>(path);
            Collections.reverse(validPath);
            ans.add(validPath);
            return;
        }
        
        // 3. ZERO string manipulation. Just pull the pre-calculated parents from the Adjacency List!
        if (adj.containsKey(curr)) {
            for (String prevWord : adj.get(curr)) {
                if (map.get(prevWord) + 1 == map.get(curr)) {
                    path.add(prevWord);
                    dfs(prevWord, path);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}