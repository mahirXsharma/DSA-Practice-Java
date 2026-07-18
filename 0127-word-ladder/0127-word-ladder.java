class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 1. Put all words in a HashSet for instant O(1) lookups
        Set<String> set = new HashSet<>(wordList);
        
        // If the target word isn't even in the dictionary, it's impossible
        if (!set.contains(endWord)) return 0;
        
        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);
        int ans = 1; // Start at 1 because the sequence includes the first word
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            // Process the current wave
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                
                // Target found!
                if (curr.equals(endWord)) {
                    return ans;
                }
                
                // Try changing every single letter of the current word from 'a' to 'z'
                char[] arr = curr.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char original = arr[j];
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (arr[j] == c) continue;
                        
                        arr[j] = c;
                        String nextWord = new String(arr);
                        
                        // If the modified word is in our dictionary, queue it up and remove it from the set (acts as visited)
                        if (set.contains(nextWord)) {
                            q.add(nextWord);
                            set.remove(nextWord);
                        }
                    }
                    // Backtrack the letter so we can modify the next position
                    arr[j] = original;
                }
            }
            // Wave finished, increment step count
            ans++;
        }
        
        // If the queue empties and we never returned, no path exists
        return 0;
    }
}