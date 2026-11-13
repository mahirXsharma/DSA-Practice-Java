class Solution {
    public void moveZeroes(int[] nums) {
        // 10^4 mean N
        int n = nums.length;
        int left = 0, right = 0;
        while(right < n){
            if(nums[right] != 0){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left ++;
            }
            right ++;
        }
    }
}