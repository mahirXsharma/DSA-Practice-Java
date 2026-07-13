class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int dirs[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1)
                q.add(new int[] { i, 0 });
            grid[i][0] = 2;
            if (grid[i][n - 1] == 1)
                q.add(new int[] { i, n - 1 });
            grid[i][n - 1] = 2;
        }
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1)
                q.add(new int[] { 0, j });
            grid[0][j] = 2;
            if (grid[m - 1][j] == 1)
                q.add(new int[] { m - 1, j });
            grid[m - 1][j] = 2;
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