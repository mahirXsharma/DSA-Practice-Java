class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int p =-1;
        // finding the breaking point
        for(int i=n-1; i>= 1; i--){
            if(nums[i] > nums[i-1]){
                p = i-1;
                break;
            }
        }
        // swapping the bp
        if(p!= -1){
            for(int i=n-1; i>=0; i--){
                if(nums[i] > nums[p]){
                    int temp = nums[i];
                    nums[i] = nums[p];
                    nums[p] = temp;
                    break;
                }
            }
        }
        
        // swapping from p+1 to n-1
        int i=p+1, j = n-1;
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j--;
        }
    }
}