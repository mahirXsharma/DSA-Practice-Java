class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] { sr, sc });
        int og = image[sr][sc];
        image[sr][sc] = color;
        if(og == color) return image;
        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int i = arr[0], j = arr[1];
            // top 
            if (i - 1 >= 0 && image[i-1][j] == og) {
                image[i - 1][j] = color;
                q.add(new int[] { i - 1, j });
            }
            // bottom
            if (i + 1 < m && image[i+1][j] == og) {
                image[i + 1][j] = color;
                q.add(new int[] { i + 1, j });
            }
            // right
            if (j + 1 < n && image[i][j+1] == og) {
                image[i][j + 1] = color;
                q.add(new int[] { i, j + 1 });
            }
            // left
            if (j - 1 >= 0 && image[i][j-1] == og) {
                image[i][j - 1] = color;
                q.add(new int[] { i, j - 1 });
            }

        }
        return image;
    }
}