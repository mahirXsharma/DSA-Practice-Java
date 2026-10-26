class Solution {
    int dirs[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length, m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int curr = mat[i][j];
                boolean isPossible = help(mat, curr, i, j);
                if(isPossible) return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    public boolean help(int mat[][], int curr, int i, int j) {
        for (int dir[] : dirs) {
            int r = i + dir[0], c = j + dir[1];
            if (r >= 0 && c >= 0 && r < mat.length && c < mat[0].length) {
                int val = mat[r][c];
                if (curr < val)
                    return false;
            }
        }
        return true;
    }
}