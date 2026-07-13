class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int dirs[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        Queue<int[]> q = new ArrayDeque<>();
        // Just loop the whole board once
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Is this cell on the border AND is it a 1?
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && grid[i][j] == 1) {
                    q.add(new int[] { i, j });
                    grid[i][j] = 2; // Marked immediately, safely inside brackets!
                }
            }
        }
        while (!q.isEmpty()) {
            int curr[] = q.poll();
            for (int dir[] : dirs) {
                int nextR = curr[0] + dir[0];
                int nextC = curr[1] + dir[1];
                if (nextR < m && nextR >= 0 && nextC < n && nextC >= 0) {
                    if (grid[nextR][nextC] == 1)
                        q.add(new int[] { nextR, nextC });
                    grid[nextR][nextC] = 2;

                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    ans++;
            }
        }
        return ans;

    }

}