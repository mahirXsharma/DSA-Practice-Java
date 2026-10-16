class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int si = 0, ei = n-1;
        while(si <= ei){
            int mid = (si + (ei-si)/2);
            if(nums[mid] == target) return mid;

            // ask if the left side is sorted
            else if(nums[si] <= nums[mid]){
                // and now check if the target lives here
                if(target >= nums[si] && target <= nums[mid]){
                    ei = mid-1;
                }
                else si = mid+1;
            }
            // other wise -> right side must be sorted
            else{
                if(target >= nums[mid] && target <= nums[ei]) si = mid+1;
                else ei = mid-1;
            }
        }
        return -1;
    }
}