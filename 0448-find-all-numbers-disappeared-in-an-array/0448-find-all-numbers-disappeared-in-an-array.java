class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        boolean vis[] = new boolean[n+1];
        for(int num : nums){
            vis[num] = true;
        }
        for(int i=1; i<n+1; i++){
            if(!vis[i]) ans.add(i);
        }
        return ans;
    }
}