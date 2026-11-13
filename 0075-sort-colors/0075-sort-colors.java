class Solution {
    public void sortColors(int[] nums) {
        // n = 300 , wtf
        int n = nums.length;
        int left = 0, right = n-1, mid = 0;

        while(mid <= right){
            int curr = nums[mid];
            // put in left
            if(curr == 0){
                int temp = nums[left];
                nums[left] = 0;
                nums[mid] = temp;
                left++;
                mid++;
            }
            // put in right
            else if(curr == 2){
                int temp = nums[right];
                nums[right] = 2;
                nums[mid] = temp;
                right--;
            }
            else mid++;
        }
    }
}