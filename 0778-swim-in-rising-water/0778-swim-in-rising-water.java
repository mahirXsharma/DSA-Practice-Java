class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        // right, down, left
        int dirs[][] = {{-1,0},{0, 1}, {1, 0}, {0, -1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int t = 0;
        pq.add(new int[]{grid[0][0], 0, 0});
        grid[0][0] = -1;
        while(true){
            if(pq.peek()[0] <= t){
                int curr[] = pq.poll();
                int val = curr[0], i = curr[1], j = curr[2];
                if(i == n-1 && j == n-1) break;
                for(int dir[] : dirs){
                    int nextR = i + dir[0], nextC = j + dir[1];
                    if(nextR < n && nextC < n && nextR >=0 && nextC >= 0){
                        int currVal = grid[nextR][nextC];
                        if( currVal != -1){
                            pq.add(new int[]{currVal, nextR, nextC});
                            grid[nextR][nextC] = -1;
                        }
                    }
                }
            }
            else t++;
        }
        return t;
    }
}