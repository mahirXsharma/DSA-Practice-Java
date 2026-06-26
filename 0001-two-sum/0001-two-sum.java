class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0; i<n; i++){
           int curr = nums[i];
            int key = target - curr;
            if(map.containsKey(key)){
                return new int[]{map.get(key), i};
            }
            else{
                map.put(curr, i);
            }
        }
        return null;
    }
}