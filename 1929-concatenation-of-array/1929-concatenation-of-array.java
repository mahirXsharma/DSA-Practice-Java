class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int ans[] = new int[2*n];
        for(int i=0, j=0; i<2*n; i++, j++){
            if(j == n) j = 0;
            ans[i] = nums[j];
        }
        return ans;
    }
}