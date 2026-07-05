class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int ans = 0;
        boolean visited[] = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                q.add(i);
                while (!q.isEmpty()) {
                    int curr = q.poll();
                    for (int j = 0; j < n; j++) {
                        if (isConnected[curr][j] == 1 && !visited[j]) {
                            visited[j] = true;
                            q.add(j);
                        }
                    }
                }
                ans++;
            }
        }
        return ans;
    }
}