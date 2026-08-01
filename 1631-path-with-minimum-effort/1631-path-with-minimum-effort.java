class Solution {
    public int minimumEffortPath(int[][] heights) {
        int low = 0;
        int high = 1000000;
        int ans = -1;
        // why equality though? ( silly question )
        while(low <= high){
            int mid = low + (high-low)/2;
            if(canReachEnd(heights, mid)){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }
    private boolean canReachEnd(int heights[][], int mid){
        int m= heights.length, n = heights[0].length;
        int dirs[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean vis[][] = new boolean[m][n];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        vis[0][0] = true;
        while( !q.isEmpty() ){
            int curr[] = q.poll();
            int r= curr[0], c = curr[1];
            if(r == m-1 && c == n-1) return true;
            for( int[] dir : dirs){
                int nextR = r + dir[0];
                int nextC = c + dir[1];
                if(nextR >= 0 && nextR < m && nextC < n && nextC >= 0){
                    int jump = Math.abs(heights[r][c] - heights[nextR][nextC]);
                    if(!vis[nextR][nextC] && jump <= mid){
                        vis[nextR][nextC] = true;
                        q.add(new int[]{nextR, nextC});
                    }
                }
            }
        }
        return false;
    }
}