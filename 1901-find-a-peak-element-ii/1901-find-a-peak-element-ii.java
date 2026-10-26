class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int si = 0, ei = m-1;

        while(si <= ei){
            int mid = (si + (ei - si)/2);
            int idx[] = help(mat, mid);
            int r = idx[0], c = idx[1], val = mat[r][c];

            int left = c == 0 ? -1 : mat[r][c-1];
            int right = c == m-1 ? -1 : mat[r][c+1];

            if(val > left && val > right) return idx;
            else if(left > val) ei = mid-1;
            else si = mid+1;
        }
        return new int[]{-1, -1};
    }

    public int[] help(int mat[][], int col){
        int r = -1, max = Integer.MIN_VALUE;
        for(int i=0; i<mat.length; i++){
            if(mat[i][col] > max){
                max = mat[i][col];
                r = i;
            }
        } 
        return new int[]{r, col};
    }
}