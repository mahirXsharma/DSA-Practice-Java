class Solution {
    // Standard direction arrays to keep the inner loop clean
    int[] dirR = {0, 1, 0, -1};
    int[] dirC = {1, 0, -1, 0};

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        
        int low = 0;
        int high = 1000000;
        int ans = -1;
        
        // 🚀 OPTIMIZATION 1: Allocate memory EXACTLY ONCE globally
        int[][] visited = new int[m][n];
        int attemptNumber = 1; // This tracks which BFS run we are on
        
        // 🚀 OPTIMIZATION 2: A raw array acts as our Queue. Max size is total cells.
        int[] queue = new int[m * n];
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Pass our reusable structures into the bouncer
            if (canReachEnd(heights, mid, m, n, visited, attemptNumber, queue)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            
            // Increment the attempt number so the next BFS knows the previous numbers are stale!
            attemptNumber++; 
        }
        return ans;
    }
    
    private boolean canReachEnd(int[][] heights, int mid, int m, int n, int[][] visited, int attemptNumber, int[] queue) {
        // Two pointers to simulate a Queue on our raw array
        int head = 0;
        int tail = 0;
        
        // Start at (0,0). Squish formula: 0 * n + 0 = 0
        queue[tail++] = 0; 
        visited[0][0] = attemptNumber; // Mark with the current attempt ID
        
        while (head < tail) {
            // Pop from queue
            int curr = queue[head++];
            
            // Un-squish the ID back into row and col
            int r = curr / n;
            int c = curr % n;
            
            if (r == m - 1 && c == n - 1) return true;
            
            for (int i = 0; i < 4; i++) {
                int nextR = r + dirR[i];
                int nextC = c + dirC[i];
                
                if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n) {
                    // 🚀 The Magic Check: Have we visited this cell DURING THIS SPECIFIC ATTEMPT?
                    if (visited[nextR][nextC] != attemptNumber) {
                        int jump = Math.abs(heights[r][c] - heights[nextR][nextC]);
                        
                        if (jump <= mid) {
                            visited[nextR][nextC] = attemptNumber; // Mark it for this attempt
                            queue[tail++] = nextR * n + nextC;     // Squish and add to queue
                        }
                    }
                }
            }
        }
        
        return false;
    }
}