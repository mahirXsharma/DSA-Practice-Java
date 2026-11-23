class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, ans, l, candidates.length);
        return ans;
    }

    public void dfs(int nums[], int tar, int idx, List<List<Integer>> ans, List<Integer> curr, int n){
        if(tar == 0){
            // snapshot
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(idx == n) return;

        // take only if its valid
        if(tar - nums[idx] >= 0){
            curr.add(nums[idx]);
            dfs(nums, tar - nums[idx], idx+1, ans, curr, n);
            curr.remove(curr.size() - 1);
        }
        // leave, but skip if its the same
        while(idx +1 < n && nums[idx] == nums[idx+1]) idx++;
        
        dfs(nums, tar, idx +1, ans, curr, n);
    }
}