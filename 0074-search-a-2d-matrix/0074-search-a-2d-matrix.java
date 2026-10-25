class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int n = matrix.length, m = matrix[0].length;
        int si = 0, ei = n*m - 1;

        while(si <= ei){
            int mid = (si + (ei - si)/2);
            int row = mid/m, col = mid % m;
            int curr = matrix[row][col];
            if(curr == target) return true;
            else if (curr > target) ei = mid-1;
            else si = mid+1;
        }
        return false;
    }
}