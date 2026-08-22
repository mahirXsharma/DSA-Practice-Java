class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length, n = matrix[0].length;
        int[] drow  = new int[m];
        int[] dcol = new int[n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    drow[i] = 1;
                    dcol[j] = 1;
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(drow[i] == 1 || dcol[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
        
    }
}