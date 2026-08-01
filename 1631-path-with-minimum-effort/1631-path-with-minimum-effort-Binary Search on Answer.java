class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m= heights.length, n = heights[0].length;
        int low = 0, high = 1000000, ans = -1, currNo = 1;
        int vis[][] = new int[m][n];
        while(low <= high){
            int mid = low + (high-low)/2;
            if(canReachEnd(heights, mid, m, n, vis, currNo)){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
            currNo ++;
        }
        return ans;
    }
    private boolean canReachEnd(int heights[][], int mid, int m, int n, int vis[][], int currNo){
        int dirs[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        vis[0][0] = currNo;
        while( !q.isEmpty() ){
            int curr[] = q.poll();
            int r= curr[0], c = curr[1];
            if(r == m-1 && c == n-1) return true;
            for( int[] dir : dirs){
                int nextR = r + dir[0];
                int nextC = c + dir[1];
                if(nextR >= 0 && nextR < m && nextC < n && nextC >= 0){
                    int jump = Math.abs(heights[r][c] - heights[nextR][nextC]);
                    if( vis[nextR][nextC] != currNo && jump <= mid){
                        vis[nextR][nextC] = currNo;
                        q.add(new int[]{nextR, nextC});
                    }
                }
            }
        }
        return false;
    }
}