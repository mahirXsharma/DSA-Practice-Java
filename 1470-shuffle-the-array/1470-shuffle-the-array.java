class Solution {
    public int[] shuffle(int[] nums, int n) {
        int i=0, j=n;
        int ans[] = new int[2*n];
        for(int p=0; p< 2*n; p++){
            ans[p] = nums[i];
            ans[++p] = nums[j];
            i++;
            j++;
        }
        return ans;
    }
}