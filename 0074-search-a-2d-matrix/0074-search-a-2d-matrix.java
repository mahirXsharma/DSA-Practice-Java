class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length, m = matrix[0].length;

        int si = 0, ei = n-1;
        int row = -1;
        while(si <= ei){
            int mid = si + (ei - si)/2;
            if(matrix[mid][0] == target) return true;
            else if(matrix[mid][0] > target) ei = mid-1;
            else{
                row = mid;
                si = mid+1;
            }
        }
        if(row == -1) return false;
        return bs(row, 0, m-1, matrix, target);



        // O (m * n)
        // int arr[] = new int[m*n];
        // for(int i =0; i<n; i++){
        //     for(int j=0; j<m; j++){
        //         arr[i*m  + j] = matrix[i][j];
        //     }   
        // }
        // int si=0, ei = arr.length-1;
        // while(si <= ei){
        //     int mid = si + (ei-si)/2;
        //     if(arr[mid] == target) return true;
        //     else if(arr[mid] > target) ei = mid-1;
        //     else si = mid+1;
            
        // }
        // return false;
    }

    public boolean bs(int row, int si, int ei, int matrix[][], int target ){
        while(si <= ei){
            int mid = si + (ei - si)/2;
            int curr = matrix[row][mid];
            if( curr == target) return true;
            else if(curr > target) ei = mid-1;
            else si = mid+1;
        }
        return false;
    }
    
}