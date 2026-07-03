class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int globalCount =0;
        int localCount = 0;
        for(int i : nums){
            if(i == 1) {
                localCount++;
                if(localCount > globalCount){
                    globalCount = localCount;
                }
            }
            else localCount = 0;
        }
        return globalCount;
    }
}