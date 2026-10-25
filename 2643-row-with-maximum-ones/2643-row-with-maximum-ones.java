class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int count = 0, row = 0;
        for(int i=0; i<mat.length; i++){
            int nums[] = mat[i];
            int currCount = 0;
            for(int num : nums){
                if(num == 1) currCount ++;
            }
            if(currCount > count){
                count = currCount;
                row = i;
            }
        }
        return new int[]{row, count};
        
    }
}