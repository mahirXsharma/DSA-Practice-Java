class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        if(grid[0][0] == 1 || grid[m-1][m-1] == 1) return -1;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 1});
        grid[0][0] = 1;
        int[][] dirs = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},   
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}  
        };
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r= curr[0];
            int c= curr[1];
            int dist = curr[2];
            if(r == m-1 && c == m-1) return dist;
            for(int[] dir : dirs){
                int nextR = r + dir[0];
                int nextC = c + dir[1];
                if(nextR >= 0 && nextR < m && nextC >=0 && nextC < m){
                    if(grid[nextR][nextC] == 0){
                        grid[nextR][nextC] = 1;
                        q.add(new int[]{nextR, nextC, dist + 1});
                    }
                }
            }
        }
        return -1;
    }
}