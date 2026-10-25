class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // diagonal binary search
        int n = matrix.length, m = matrix[0].length;
        int diag = Math.min(n, m);

        for(int i=0; i<diag; i++){
            // row search
            int si = i, ei = m-1;
            while(si <= ei){
                int mid = (si + (ei - si)/2);
                int curr = matrix[i][mid];
                if(curr == target) return true;
                else if(curr > target) ei = mid-1;
                else si = mid+1;
            }

            si = i;
            ei = n-1;
            while(si <= ei){
                int mid = (si + (ei - si)/2);
                int curr = matrix[mid][i];
                if(curr == target) return true;
                else if(curr > target) ei = mid-1;
                else si = mid+1;
            }   
        }
        return false;
    }
}