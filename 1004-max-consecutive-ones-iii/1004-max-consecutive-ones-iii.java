class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length, sum = 0;
        int right = 0, left = 0;

        while(right < n){
            int curr = nums[right];
            if(curr == 0) k--;

            while(k < 0 ){
                if(nums[left] == 0) k++;
                left++;
            }
            right ++;
            int currSum = right -left;
            if(currSum > sum) sum = currSum;
        }
        return sum;
    }
}