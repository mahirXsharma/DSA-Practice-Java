class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int globalCount =0, n = nums.length;
        int localCount = 0;
        for(int i : nums){
            if(i == 1) {
                localCount++;
                globalCount = Math.max(globalCount, localCount);
            }
            else localCount = 0;
        }
        return globalCount;
    }
}