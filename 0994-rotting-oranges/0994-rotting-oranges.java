class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        int ans = 0;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    ans++;
                if (grid[i][j] == 2)
                    q.add(new int[] { i, j });
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int p = 0; p < size; p++) {
                int[] arr = q.poll();
                int i = arr[0], j = arr[1];
                // top 
                if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    q.add(new int[] { i - 1, j });
                    ans--;
                }
                // bottom
                if (i + 1 < m && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    q.add(new int[] { i + 1, j });
                    ans--;
                }
                // right
                if (j + 1 < n && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    q.add(new int[] { i, j + 1 });
                    ans--;
                }
                // left
                if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    q.add(new int[] { i, j - 1 });
                    ans--;
                }
            }
            if(!q.isEmpty())count++;
        }
        if (ans != 0) return -1;
        return count;

    }

}