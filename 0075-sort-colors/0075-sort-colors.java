class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
       int i=0, j = n-1, mid = i;
       while(mid <= j){
            int curr = nums[mid];
        if(curr == 1) mid++;
        else if(curr == 0){
            swap(nums, i, mid);
            mid++; i++;
        }
        else{
            swap(nums, mid, j);
            j--;
        }
       }
    }
    public void swap(int nums[], int i, int j){
        int temp = nums[i];
         nums[i] = nums[j];
        nums[j] = temp;
    }
}