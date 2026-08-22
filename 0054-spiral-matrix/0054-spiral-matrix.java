class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int ub = 0, lb = 0, rb = n-1, bb = m-1;
            while(ub <= bb && lb <= rb){
                for(int i = lb; i<= rb; i++){
                    ans.add(matrix[ub][i]);
                }
                ub++;
                for(int i=ub; i<= bb; i++){
                    ans.add(matrix[i][rb]);
                }
                rb--;
                if(ub <= bb){
                    for(int i=rb; i>= lb; i--){
                        ans.add(matrix[bb][i]);
                    }
                    bb--;
                }
                if(lb <= rb){
                    for(int i=bb; i>= ub; i--){
                        ans.add(matrix[i][lb]);
                    }
                    lb++;
                }
                
            }
            return ans;
    }
}