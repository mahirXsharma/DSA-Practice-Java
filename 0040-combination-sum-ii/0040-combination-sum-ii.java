class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // recursion + "only used once"
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(0, candidates, target, ans, list);
        return ans;
    }

    public void dfs(int idx, int nums[], int tar, List<List<Integer>> ans, List<Integer> curr){
        if(tar == 0){
            // found a valid answer
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(idx >= nums.length) return;

        // take or leave
        if(tar - nums[idx] >= 0){
            curr.add(nums[idx]);
            dfs(idx+1, nums, tar - nums[idx], ans, curr);
            curr.remove(curr.size() - 1);
        }

        // skip all the duplicates
        while(idx +1 < nums.length && nums[idx] == nums[idx+1])idx++;
        dfs(idx+1, nums, tar, ans, curr);
    }
}