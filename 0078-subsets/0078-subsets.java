class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        helper(nums, result, 0, subList);
        return result;
    }

    public void helper(int arr[], List<List<Integer>> list, int i, List<Integer> subList ){
        if( i == arr.length ){
            list.add(new ArrayList<>(subList));
            return ;
        }
        subList.add(arr[i]);
        helper(arr, list, i+1, subList);
        subList.remove(subList.size() - 1);
        helper(arr, list, i+1, subList);
    }
}