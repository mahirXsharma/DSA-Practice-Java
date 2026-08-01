class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b)->a[0]-b[0] );
        int dist[][] = new int[m][n];


        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        pq.add(new int[]{0, 0, 0});


        while( !pq.isEmpty()){
            int[] curr = pq.poll();
            int currEffort = curr[0];
            int r = curr[1];
            int c = curr[2];
            if(r == m-1 && c == n-1) return currEffort;
            for(int dir[] : dirs){
                int nextR = r + dir[0];
                int nextC = c + dir[1];
                if(nextR>=0 && nextR < m && nextC >=0 && nextC < n){
                    int jump = Math.abs(heights[r][c] - heights[nextR][nextC]);
                    int newEffort = Math.max(currEffort, jump);
                    if(newEffort < dist[nextR][nextC]){
                        dist[nextR][nextC] = newEffort;
                        pq.add(new int[]{newEffort, nextR, nextC});
                    }
                }
            }
        }
        return -1;
    }
}