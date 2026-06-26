import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for(int i=0; i<n; i++){
            int runningSum = nums[i];
            if(runningSum == k) count ++;
            for(int j=i+1; j<n; j++){
                runningSum += nums[j];
                if(runningSum == k ) count ++;
            }
        }
        return count;
    }
}