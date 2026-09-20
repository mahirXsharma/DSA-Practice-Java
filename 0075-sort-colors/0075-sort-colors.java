class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i=0,p =0,  j = n-1;
        while( p <= j){
            int curr = nums[p];
            if(curr == 2){
                // swap with j
                int temp = nums[j];
                nums[j--] = nums[p];
                nums[p] = temp;
            }
            if(curr == 0){
                // swap with i
                int temp = nums[i];
                nums[i++] = nums[p];
                nums[p++] = temp;
            }
            if(curr == 1) p++;
        }
    }
}