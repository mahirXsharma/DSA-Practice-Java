class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<n; i++){
            int next = i+1; 
            while(next < n){
                // swap
                int temp = matrix[i][next];
                matrix[i][next] = matrix[next][i];
                matrix[next][i] = temp;
                next++;
            }
        }
        int i=0, j = n-1;
        while(i < j){
            for(int k=0; k<n; k++){
                int temp = matrix[k][i];
                matrix[k][i] = matrix[k][j];
                matrix[k][j] = temp;
            }
            i++;
            j--;
        }
    }
}