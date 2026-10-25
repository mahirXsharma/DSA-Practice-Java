class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length, m = matrix[0].length;
        int row = -1;
        int sii = 0, eii = n-1;
        while( sii <= eii){
            int mid = (sii + (eii - sii)/2);
            int curr = matrix[mid][m-1];
            if(curr == target) return true;
            else if(curr > target){
                row = mid;
                eii = mid-1;
            }
            else sii = mid+1;
        }

        if(row == -1) return false;
        int arr[] = matrix[row];
        int si = 0, ei = m-1;

        while(si <= ei){
            int mid = (si + (ei - si)/2);
            if(arr[mid] == target) return true;
            else if(arr[mid] > target) ei = mid-1;
            else si = mid+1;
        }
        return false;


    }
}