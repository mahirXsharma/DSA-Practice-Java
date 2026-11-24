class Solution {
    public int jump(int[] nums) {
        int jump = 0, far = 0, n = nums.length, start = 0;
        if(n == 1) return 0;
        for(int i=0; i<n; i++){
            far = Math.max(far, i+nums[i]);
            if(far >= n-1) break;
            if( i == start){
                jump++;
                start = far;
            }
        }
        // will jump++ gonna work?
        return jump+1;
    }
}