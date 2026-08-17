class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        
        // 1. Scout the first and last occurrence of every letter
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) first[c] = i;
            last[c] = i;
        }
        
        List<Integer>[] adj = new ArrayList[26];
        List<Integer>[] revAdj = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            adj[i] = new ArrayList<>();
            revAdj[i] = new ArrayList<>();
        }
        
        // 2. Build the Directed Graph (Dependencies)
        for (int i = 0; i < 26; i++) {
            if (first[i] != -1) {
                // If a letter exists inside my boundaries, I depend on it!
                for (int k = first[i]; k <= last[i]; k++) {
                    int j = s.charAt(k) - 'a';
                    if (i != j) {
                        adj[i].add(j);
                        revAdj[j].add(i);
                    }
                }
            }
        }
        
        // 3. Kosaraju Step 1: Fill the Stack by finish time
        boolean[] vis = new boolean[26];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < 26; i++) {
            if (first[i] != -1 && !vis[i]) {
                dfs1(i, adj, vis, st);
            }
        }
        
        // 4. Kosaraju Step 2: Harvest the SCCs using Reversed Graph
        Arrays.fill(vis, false);
        int[] sccId = new int[26];
        int currentScc = 0;
        
        while (!st.isEmpty()) {
            int node = st.pop();
            if (!vis[node]) {
                dfs2(node, revAdj, vis, sccId, currentScc);
                currentScc++;
            }
        }
        
        // 5. Find the Out-Degree of every SCC
        int[] outDegree = new int[currentScc];
        for (int i = 0; i < 26; i++) {
            if (first[i] != -1) {
                for (int neighbor : adj[i]) {
                    // If this letter points to a letter in a DIFFERENT group
                    if (sccId[i] != sccId[neighbor]) {
                        outDegree[sccId[i]]++;
                    }
                }
            }
        }
        
        // 6. Extract the substrings for SCCs with Out-Degree == 0
        List<String> res = new ArrayList<>();
        for (int id = 0; id < currentScc; id++) {
            if (outDegree[id] == 0) {
                int minFirst = n;
                int maxLast = -1;
                
                // Find the absolute borders of this specific isolated group
                for (int i = 0; i < 26; i++) {
                    if (first[i] != -1 && sccId[i] == id) {
                        minFirst = Math.min(minFirst, first[i]);
                        maxLast = Math.max(maxLast, last[i]);
                    }
                }
                res.add(s.substring(minFirst, maxLast + 1));
            }
        }
        
        return res;
    }
    
    // --- Standard Helper Methods ---
    
    private void dfs1(int node, List<Integer>[] adj, boolean[] vis, Stack<Integer> st) {
        vis[node] = true;
        for (int neighbor : adj[node]) {
            if (!vis[neighbor]) {
                dfs1(neighbor, adj, vis, st);
            }
        }
        st.push(node);
    }
    
    private void dfs2(int node, List<Integer>[] revAdj, boolean[] vis, int[] sccId, int id) {
        vis[node] = true;
        sccId[node] = id; // Tag this node with its SCC group number
        for (int neighbor : revAdj[node]) {
            if (!vis[neighbor]) {
                dfs2(neighbor, revAdj, vis, sccId, id);
            }
        }
    }
}