class Solution {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n =nums.length;
        boolean lonely = true;
        for(int i=0; i<n; i++){
            if(i+1 < n ){
                if(nums[i+1] == nums[i] + 1 || nums[i+1] == nums[i]) lonely = false;
            }
            if(i-1 >= 0){
                if( nums[i-1] == nums[i] || nums[i-1] == nums[i]-1)lonely = false;
            } 
            if(lonely) ans.add(nums[i]);
            lonely = true;
        }
        return ans;        
    }
}