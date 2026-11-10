class Solution {
    public int search(int[] nums, int target) {
        // 5*10^3 -> N2 will work easily, but they are forcing us for logN
        // So we will go with binary search
        int n = nums.length;
        return bs(nums, target, 0, n-1);
    }

    public int bs(int nums[], int t, int si, int ei){
        if(si == ei) return nums[si] == t? si : -1;

        while(si <= ei){
            int mid = si + (ei - si)/2;
            if(nums[mid] == t) return mid;
            int l = bs(nums, t, si, mid);
            if(l != -1) return l;
            else si = mid+1;       

        }
        return -1;
    }
}