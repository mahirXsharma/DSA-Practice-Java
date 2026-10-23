class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int si = 0, ei = n-1;
        while( si <= ei){
            int mid = (si + (ei-si)/2);
            long curr =(long)nums[mid];
            long left = mid == 0? Long.MIN_VALUE :(long) nums[mid-1];
            long right = mid == n-1? Long.MIN_VALUE : (long)nums[mid+1];     

            if(curr > left && curr > right) return mid;
            else if(curr < right) si = mid+1;
            else ei = mid-1;
        }
        return -1;
    }
}