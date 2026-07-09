class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int dirs[][] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int m=mat.length, n = mat[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        boolean vis[][] = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){

            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];
                // all 4 direcitons-> if any one is unvisited -> that a 1 ->
                // mark it visited and add a 1 realtive to its value
                for(int dir[] : dirs){
                    int nextR = r + dir[0];
                    int nextC = c + dir[1];
                    if(nextR >= 0 && nextR <m && nextC >= 0 && nextC < n){
                        if(!vis[nextR][nextC]){
                            mat[nextR][nextC] = mat[r][c] + 1;
                            vis[nextR][nextC] = true;
                            q.add(new int[]{nextR, nextC});
                        }
                    }
                }
            }
        }
        return mat;
    }
}