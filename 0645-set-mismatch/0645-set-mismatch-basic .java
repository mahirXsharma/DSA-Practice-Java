class Solution {
    public int[] findErrorNums(int[] nums) {
        boolean arr[] = new boolean[nums.length+1];
        int ans[] = new int[2];
        for(int num : nums){
            if(!arr[num]) arr[num] = true;
            else ans[0] = num;
        }
        for(int i=0; i<arr.length; i++){
            if(!arr[i] ) ans[1] = i;
        }
        return ans;
    }
}