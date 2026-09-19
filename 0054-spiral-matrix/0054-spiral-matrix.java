class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int ub = 0, bb = matrix.length-1;
        int lb = 0, rb = matrix[0].length-1;
        while(ub <= bb && lb <= rb){
            for(int j=lb; j<=rb; j++){
                ans.add(matrix[ub][j]);
            }
            ub++;
            for(int i=ub; i<=bb; i++){
                ans.add(matrix[i][rb]);
            }
            rb--;
            if(ub > bb || lb > rb) break;
            for(int j=rb; j>=lb; j--){
                ans.add(matrix[bb][j]);
            }
            bb--;
            for(int i=bb; i>=ub; i--){
                ans.add(matrix[i][lb]);
            }
            lb++;
        }
        return ans;
    }
}