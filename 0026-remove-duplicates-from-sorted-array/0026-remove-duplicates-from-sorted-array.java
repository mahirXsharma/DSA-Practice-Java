class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        // replacing duplicate with 101
        int prev = nums[0];
        for(int i=1; i<n; i++){
            while(i < n && nums[i] == prev){
                nums[i] = 101;
                i++;
            }
            if(i == n) break;
            prev = nums[i];
        }
        // 2 pointer swap
        for(int i=0; i<n; i++){
            if(nums[i] == 101){
                int j= i+1;
                while(j < n && nums[j] == 101){
                    j++;
                }
                if(j == n) break;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        // counting k 
        int k=0; 
        for(int num : nums){
            if(num != 101) k++;
            else break;
        }
        return k;
    }
}