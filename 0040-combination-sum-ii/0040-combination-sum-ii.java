class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // n -> 100 => easy N2 or Recursion
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        dfs(candidates, target, 0, curr, ans);
        return ans;
    }

    public void dfs(int nums[], int tar, int idx, List<Integer> curr, List<List<Integer>> ans) {
        if (tar == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (idx == nums.length)
            return;

        int num = nums[idx];

        // take only if the tar doesnt' go -ve
        if (tar - num >= 0) {
            curr.add(num);
            dfs(nums, tar - num, idx + 1, curr, ans);
            curr.remove(curr.size() - 1);
        }
        while(idx+1 < nums.length && nums[idx] == nums[idx+1]) idx++;

        dfs(nums, tar, idx + 1, curr, ans);
    }
}