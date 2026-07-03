class Solution {
    public int[] getConcatenation(int[] nums) {
        int i = 0, n = nums.length;
        int ans[] = new int[2*n];
        while(i < 2*n){
            ans[i] = nums[i % n];
            i++;
        }
        return ans;
    }
}